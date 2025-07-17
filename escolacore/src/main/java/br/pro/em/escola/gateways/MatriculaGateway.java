package br.pro.em.escola.gateways;

import br.pro.em.escola.dtos.MatriculaCompletoDTO;
import br.pro.em.escola.dtos.MatriculaDTO;
import br.pro.em.escola.entities.Curso;
import br.pro.em.escola.entities.Matricula;
import br.pro.em.escola.entities.Pessoa;
import br.pro.em.escola.interfaces.DataSource;

public class MatriculaGateway {
    private final DataSource dataSource;

    public MatriculaGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Matricula buscar(String pessoaId, String cursoId) {
        MatriculaDTO matriculaDTO = this.dataSource.obterMatricula(pessoaId, cursoId);
        if (matriculaDTO == null) {
            return null; // ou lançar uma exceção, dependendo do caso de uso
        }

        var pData = this.dataSource.pessoaPorId(pessoaId);
        var cData = this.dataSource.cursoPorId(cursoId, true);

        var pessoa = new Pessoa(
                pData.id(), pData.nome(), pData.enderecoEmail(), pData.dataNascimento()
        );
        var curso = new Curso(
                cData.id(), cData.nome(), cData.ativo()
        );

        Matricula matricula = new Matricula(
                matriculaDTO.id(), pessoa, curso
        );

        return matricula;
    }

    public Matricula buscar(String matriculaId) {
        MatriculaCompletoDTO matriculaCompletoDTO = this.dataSource.obterMatriculaPorId(matriculaId);
        if (matriculaCompletoDTO == null) {
            return null; // ou lançar uma exceção, dependendo do caso de uso
        }
        var matricula = new Matricula(
                matriculaCompletoDTO.matriculaId(),
                new Pessoa(
                        matriculaCompletoDTO.pessoaId(),
                        matriculaCompletoDTO.pessoaNome(),
                        matriculaCompletoDTO.pessoaEnderecoEmail(),
                        matriculaCompletoDTO.pessoaDataNascimento()
                ),
                new Curso(
                        matriculaCompletoDTO.cursoId(),
                        matriculaCompletoDTO.cursoNome(),
                        matriculaCompletoDTO.cursoAtivo()
                )
        );
        return matricula;
    }

    public void matricularPessoa(String matriculaId, Pessoa pessoa, Curso curso) {
        MatriculaDTO m = new MatriculaDTO(matriculaId, pessoa.getId(), curso.getId());
        this.dataSource.saveMatricula(m);
    }
}
