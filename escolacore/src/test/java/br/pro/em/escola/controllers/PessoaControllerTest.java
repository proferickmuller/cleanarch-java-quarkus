package br.pro.em.escola.controllers;

import br.pro.em.escola.interfaces.DataSource;

import static org.junit.jupiter.api.Assertions.*;

class PessoaControllerTest {

    // mock do datasource
    DataSource mockDataSource = ...;

    var p = PessoaController.NovaPessoa(mockDataSource)
}