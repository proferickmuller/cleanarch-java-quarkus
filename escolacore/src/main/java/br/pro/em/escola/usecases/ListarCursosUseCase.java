package br.pro.em.escola.usecases;

import br.pro.em.escola.entities.Curso;
import br.pro.em.escola.gateways.ICursoGateway;
import br.pro.em.escola.interfaces.DataSource;

import java.util.List;

public class ListarCursosUseCase {
    private final ICursoGateway cursoGateway;

    public ListarCursosUseCase(ICursoGateway cursoGateway) {
        this.cursoGateway = cursoGateway;
    }

    public List<Curso> run() {
        var cursos = this.cursoGateway.listarAtivos();
        if (cursos == null || cursos.isEmpty()) {
            return List.of();
        }
        return cursos;
    }
}
