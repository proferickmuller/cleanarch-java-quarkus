package br.pro.em.escola.interfaces;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.dtos.MatriculaCompletoDTO;
import br.pro.em.escola.dtos.MatriculaDTO;
import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.PessoaEntity;

import java.util.List;

public interface DataSource {
    PessoaDTO pessoaPorId(String id);

    void savePessoa(PessoaDTO p);

    List<CursoDTO> cursosAtivos();

    CursoDTO cursoPorId(String idCurso, boolean ativo);
    CursoDTO cursoPorId(String idCurso);

    MatriculaDTO obterMatricula(String idPessoa, String idCurso);

    MatriculaCompletoDTO obterMatriculaPorId(String matriculaId);  // ex: uma ReadOnly Query CQRS

    void saveMatricula(MatriculaDTO m);
}
