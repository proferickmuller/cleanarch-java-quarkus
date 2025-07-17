package br.pro.em.escola.presenters;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.PessoaEntity;

public class PessoaPresenter {
    public static PessoaDTO toDTO(PessoaEntity pessoaEntity) {
        return new PessoaDTO(
                pessoaEntity.getId(),
                pessoaEntity.getNome(),
                pessoaEntity.getEnderecoEmail(),
                pessoaEntity.getDataNascimento()
        );
    }
}
