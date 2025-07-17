package br.pro.em.escola.controllers;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.gateways.CursoGateway;
import br.pro.em.escola.gateways.ICursoGateway;
import br.pro.em.escola.interfaces.DataSource;
import br.pro.em.escola.presenters.CursoPresenter;
import br.pro.em.escola.usecases.ListarCursosUseCase;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private final DataSource dataSource;

    public CursoController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    static CursoController build(DataSource dataSource) {
        return new CursoController(dataSource);
    }

    public List<CursoDTO> listarAtivos() {
        ICursoGateway cursoGateway = new CursoGateway(dataSource);
        var uc = new ListarCursosUseCase(cursoGateway);
        var cursos = uc.run();
        if (cursos == null || cursos.isEmpty()) {
            return new ArrayList<>();
        }
        return CursoPresenter.toListDTO(cursos);
    }

}
