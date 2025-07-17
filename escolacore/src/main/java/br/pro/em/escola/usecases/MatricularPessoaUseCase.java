package br.pro.em.escola.usecases;

import br.pro.em.escola.entities.Curso;
import br.pro.em.escola.entities.Matricula;
import br.pro.em.escola.entities.Pessoa;
import br.pro.em.escola.gateways.CursoGateway;
import br.pro.em.escola.gateways.MatriculaGateway;
import br.pro.em.escola.gateways.PessoaGateway;
import br.pro.em.escola.util.Generator;

public class MatricularPessoaUseCase {
    private final CursoGateway cursoGateway;
    private final PessoaGateway pessoaGateway;
    private final MatriculaGateway matriculaGateway;

    public MatricularPessoaUseCase(PessoaGateway pessoaGateway, CursoGateway cursoGateway, MatriculaGateway matriculaGateway) {
        this.cursoGateway = cursoGateway;
        this.pessoaGateway = pessoaGateway;
        this.matriculaGateway = matriculaGateway;

    }

    public String run(String idPessoa, String idCurso) {
        // Verifica se a pessoa existe
        Pessoa pessoa = pessoaGateway.obterPorId(idPessoa);
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        // Verifica se o curso existe
        Curso curso = cursoGateway.obterPorId(idCurso, true);
        if (curso == null) {
            throw new IllegalArgumentException("Curso não encontrado");
        }

        // Verifica se a pessoa já está matriculada no curso
        Matricula matricula = matriculaGateway.buscar(idPessoa, idCurso);
        if (matricula != null) {
            throw new IllegalArgumentException("Pessoa já está matriculada neste curso");
        }

        // Realiza a matrícula
        String matriculaId = "";
        do {
            matriculaId = Generator.gerarNumericoAleatorio(10);
        } while (matriculaGateway.buscar(matriculaId) != null);
        matriculaGateway.matricularPessoa(matriculaId, pessoa, curso);

        return matriculaId;
    }


}
