package br.pro.em.escola.presenters;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.Curso;
import br.pro.em.escola.mappers.CursoMapper;

import java.util.ArrayList;
import java.util.List;

public class CursoPresenter {

    public static List<CursoDTO> toListDTO(List<Curso> cursos) {
        List<CursoDTO> cursosDTO = CursoMapper.INSTANCE.cursosParaCursoDTOs(cursos);
        return cursosDTO;
    }
}
