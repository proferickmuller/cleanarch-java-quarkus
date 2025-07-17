package br.pro.em.webapi.controller;

import br.pro.em.escola.controllers.PessoaController;
import br.pro.em.escola.interfaces.DataSource;
import br.pro.em.escola.usecases.NovaPessoaUseCase;
import br.pro.em.webapi.data.PessoaRepository;
import jakarta.ws.rs.Path;

@Path("/pessoa/v2")
public class NovoPessoaController {

    DataSource dataSource;

    public NovoPessoaController() {
        this.dataSource = new PessoaRepository();

        PessoaController pc = new PessoaController(this.dataSource);
    }

}
