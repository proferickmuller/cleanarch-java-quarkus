package br.pro.em.escola.gateways;

import br.pro.em.escola.entities.PessoaEntity;

public interface IPessoaGateway {
    PessoaEntity save(PessoaEntity p);

    PessoaEntity obterPorId(String id);
}
