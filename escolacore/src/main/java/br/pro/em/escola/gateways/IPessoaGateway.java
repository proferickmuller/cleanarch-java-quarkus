package br.pro.em.escola.gateways;

import br.pro.em.escola.entities.PessoaEntity;

public interface IPessoaGateway {
    void save(PessoaEntity p);

    PessoaEntity obterPorId(String id);
    PessoaEntity obterPorEnderecoEmail(String id);
}
