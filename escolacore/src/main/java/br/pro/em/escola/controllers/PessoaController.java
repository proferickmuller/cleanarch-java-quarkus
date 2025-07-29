package br.pro.em.escola.controllers;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.PessoaEntity;
import br.pro.em.escola.exceptions.PessoaJaExistenteException;
import br.pro.em.escola.gateways.IPessoaGateway;
import br.pro.em.escola.gateways.PessoaGateway;
import br.pro.em.escola.interfaces.DataSource;
import br.pro.em.escola.presenters.PessoaPresenter;
import br.pro.em.escola.usecases.NovaPessoaUseCase;
import br.pro.em.escola.usecases.PessoaPorIdUseCase;

import java.time.LocalDate;

public class PessoaController {

    private final DataSource dataSource;

    private PessoaController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static PessoaController build(DataSource dataSource) {
        return new PessoaController(dataSource);
    }

    public PessoaDTO novaPessoa(String nome, String enderecoEmail, LocalDate dataNascimento) {
        PessoaGateway pessoaGateway = new PessoaGateway(this.dataSource);
        NovaPessoaUseCase uc = new NovaPessoaUseCase(pessoaGateway);

        PessoaEntity pessoa;

        try {
            pessoa = uc.run(nome, enderecoEmail, dataNascimento);
        } catch (PessoaJaExistenteException e) {
            throw new PessoaJaExistenteException(enderecoEmail);
        }

        return PessoaPresenter.toDTO(pessoa);
    }

    public PessoaDTO obterPessoaPorId(String id) {
        IPessoaGateway pessoaGateway = new PessoaGateway(this.dataSource);
        var uc = new PessoaPorIdUseCase(pessoaGateway);
        var pessoa = uc.run(id);
        if (pessoa == null) {
            return null;
        }
        return PessoaPresenter.toDTO(pessoa);
    }

}
