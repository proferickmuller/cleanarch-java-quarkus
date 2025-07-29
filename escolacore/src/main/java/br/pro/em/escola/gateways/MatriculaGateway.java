package br.pro.em.escola.gateways;

import br.pro.em.escola.dtos.MatriculaCompletoDTO;
import br.pro.em.escola.dtos.MatriculaDTO;
import br.pro.em.escola.entities.CursoEntity;
import br.pro.em.escola.entities.MatriculaEntity;
import br.pro.em.escola.entities.PessoaEntity;
import br.pro.em.escola.interfaces.DataSource;

public class MatriculaGateway {
    private final DataSource dataSource;

    public MatriculaGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public MatriculaEntity buscar(String pessoaId, String cursoId) {
        MatriculaDTO matriculaDTO = this.dataSource.obterMatricula(pessoaId, cursoId);
        if (matriculaDTO == null) {
            return null; // ou lançar uma exceção, dependendo do caso de uso
        }

        var pData = this.dataSource.pessoaPorId(pessoaId);
        var cData = this.dataSource.cursoPorId(cursoId, true);

        var pessoa = new PessoaEntity(
                pData.id(), pData.nome(), pData.enderecoEmail(), pData.dataNascimento()
        );
        var curso = new CursoEntity(
                cData.id(), cData.nome(), cData.ativo()
        );

        MatriculaEntity matricula = new MatriculaEntity(
                matriculaDTO.id(), pessoa, curso
        );

        return matricula;
    }

    public MatriculaEntity buscar(String matriculaId) {
        MatriculaCompletoDTO matriculaCompletoDTO = this.dataSource.obterMatriculaPorId(matriculaId);
        if (matriculaCompletoDTO == null) {
            return null; // ou lançar uma exceção, dependendo do caso de uso
        }
        var matricula = new MatriculaEntity(
                matriculaCompletoDTO.matriculaId(),
                new PessoaEntity(
                        matriculaCompletoDTO.pessoaId(),
                        matriculaCompletoDTO.pessoaNome(),
                        matriculaCompletoDTO.pessoaEnderecoEmail(),
                        matriculaCompletoDTO.pessoaDataNascimento()
                ),
                new CursoEntity(
                        matriculaCompletoDTO.cursoId(),
                        matriculaCompletoDTO.cursoNome(),
                        matriculaCompletoDTO.cursoAtivo()
                )
        );
        return matricula;
    }

    public void matricularPessoa(String matriculaId, PessoaEntity pessoa, CursoEntity curso) {
        MatriculaDTO m = new MatriculaDTO(matriculaId, pessoa.getId(), curso.getId());
        this.dataSource.gravarMatricula(m);
    }
}
