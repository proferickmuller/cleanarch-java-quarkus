package br.pro.em.escola.gateways;

import br.pro.em.escola.entities.Pessoa;

public interface IPessoaGateway {
    void save(Pessoa p);

    Pessoa obterPorId(String id);
}
