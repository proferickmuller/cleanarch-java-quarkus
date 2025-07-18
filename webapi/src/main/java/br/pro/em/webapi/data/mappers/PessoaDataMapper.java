package br.pro.em.webapi.data.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.webapi.data.Pessoa;


@Mapper
public interface PessoaDataMapper {
    PessoaDataMapper INSTANCE = Mappers.getMapper(PessoaDataMapper.class);

    @Mapping(target = "endEmail", source = "enderecoEmail")
    Pessoa pessoaDTOParaPessoa(PessoaDTO pessoaDTO);

    @Mapping(target = "enderecoEmail", source = "endEmail")
    PessoaDTO pessoaParaPessoaDTO(Pessoa pessoa);
}
