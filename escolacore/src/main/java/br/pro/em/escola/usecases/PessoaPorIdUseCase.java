package br.pro.em.escola.usecases;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.Pessoa;
import br.pro.em.escola.gateways.IPessoaGateway;

public class PessoaPorIdUseCase {

    private IPessoaGateway pessoaGateway;

    public PessoaPorIdUseCase(IPessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public Pessoa run(String id) {
        var pessoa = this.pessoaGateway.obterPorId(id);
        if (pessoa == null) {
            return null;
        }
        return pessoa;
    }

}
