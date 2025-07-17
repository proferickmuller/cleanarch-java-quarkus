package br.pro.em.escola.controllers;

import br.pro.em.escola.gateways.CursoGateway;
import br.pro.em.escola.gateways.MatriculaGateway;
import br.pro.em.escola.gateways.PessoaGateway;
import br.pro.em.escola.interfaces.DataSource;
import br.pro.em.escola.usecases.MatricularPessoaUseCase;

public class MatriculaController {

    private final DataSource dataSource;

    public MatriculaController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String matricularPessoa(String pessoaId, String cursoId) {
        // retorna o id da matrícula
        CursoGateway cursoGateway = new CursoGateway(dataSource);
        PessoaGateway pessoaGateway = new PessoaGateway(dataSource);
        MatriculaGateway matriculaGateway = new MatriculaGateway(dataSource);

        var uc = new MatricularPessoaUseCase(
                pessoaGateway,
                cursoGateway,
                matriculaGateway
        );
        String matriculaId = uc.run(pessoaId, cursoId);

        return matriculaId;
    }

}
