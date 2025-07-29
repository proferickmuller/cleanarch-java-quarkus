package br.pro.em.escola.interfaces;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.dtos.MatriculaCompletoDTO;
import br.pro.em.escola.dtos.MatriculaDTO;
import br.pro.em.escola.dtos.PessoaDTO;

import java.util.List;

public interface DataSource {
    // Pessoa
    void gravarPessoa(PessoaDTO p);
    PessoaDTO pessoaPorId(String id);
    PessoaDTO pessoaPorEnderecoEmail(String enderecoEmail);

    // Curso
    List<CursoDTO> cursosAtivos();
    CursoDTO cursoPorId(String idCurso, boolean ativo);
    CursoDTO cursoPorId(String idCurso);

    // Matricula
    MatriculaDTO obterMatricula(String idPessoa, String idCurso);
    MatriculaCompletoDTO obterMatriculaPorId(String matriculaId);  // ex: uma ReadOnly Query CQRS
    void gravarMatricula(MatriculaDTO m);
}
