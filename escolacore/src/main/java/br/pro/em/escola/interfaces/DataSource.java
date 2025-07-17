package br.pro.em.escola.interfaces;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.dtos.MatriculaCompletoDTO;
import br.pro.em.escola.dtos.MatriculaDTO;
import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.Pessoa;

import java.util.List;

public interface DataSource {
    PessoaDTO pessoaPorId(String id);

    void savePessoa(Pessoa p);

    List<CursoDTO> cursosAtivos();

    CursoDTO cursoPorId(String idCurso, boolean ativo);
    CursoDTO cursoPorId(String idCurso);

    MatriculaDTO obterMatricula(String idPessoa, String idCurso);

    MatriculaCompletoDTO obterMatriculaPorId(String matriculaId);  // ex: uma ReadOnly Query CQRS

    void saveMatricula(MatriculaDTO m);
}
