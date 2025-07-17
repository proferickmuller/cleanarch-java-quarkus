package br.pro.em.escola.mappers;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.entities.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CursoMapper {
    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    List<CursoDTO> cursosParaCursoDTOs(List<Curso> cursos);
}
