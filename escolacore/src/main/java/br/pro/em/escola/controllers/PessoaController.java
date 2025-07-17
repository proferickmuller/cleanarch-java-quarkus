package br.pro.em.escola.controllers;

import br.pro.em.escola.dtos.NovaPessoaDTO;
import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.PessoaEntity;
import br.pro.em.escola.gateways.IPessoaGateway;
import br.pro.em.escola.interfaces.DataSource;
import br.pro.em.escola.presenters.PessoaPresenter;
import br.pro.em.escola.usecases.NovaPessoaUseCase;

public class PessoaController {

    private final DataSource dataSource;

    public PessoaController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public PessoaDTO novaPessoa(NovaPessoaDTO novaPessoaDTO) {

        IPessoaGateway pessoaGateway = new PessoaGateway(this.dataSource);
        NovaPessoaUseCase useCase = new NovaPessoaUseCase(pessoaGateway);

        PessoaEntity pessoaEntity = useCase.run(
                novaPessoaDTO
        );

        return PessoaPresenter.toDTO(pessoaEntity);

        // usecase
        // fonte de dados
        // "formatador" / adaptador

    }

}
