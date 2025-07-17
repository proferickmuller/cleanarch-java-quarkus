package br.pro.em.escola.presenters;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.Pessoa;
import br.pro.em.escola.mappers.PessoaMapper;

public class PessoaPresenter {

    public static PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO pessoaDto = PessoaMapper.INSTANCE.pessoaParaPessoaDTO(pessoa);
        return pessoaDto;
    }

}
