package br.pro.em.escola.mappers;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO pessoaParaPessoaDTO(Pessoa pessoa);
}
