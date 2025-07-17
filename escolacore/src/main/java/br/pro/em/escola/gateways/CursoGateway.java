package br.pro.em.escola.gateways;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.entities.Curso;
import br.pro.em.escola.interfaces.DataSource;

import java.util.List;

public class CursoGateway implements ICursoGateway {
    private final DataSource dataSource;

    public CursoGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Curso> listarAtivos() {

        List<CursoDTO> cursos = this.dataSource.cursosAtivos();
        List<Curso> cursosAtivos = cursos.stream()
                .map(c -> new Curso(c.id(), c.nome(), c.ativo()))
                .toList();
        return cursosAtivos;
    }

    public Curso obterPorId(String idCurso, boolean ativo) {
        CursoDTO curso = this.dataSource.cursoPorId(idCurso, ativo);
        if (curso == null) {
            return null;
        }
        Curso cursoEntity = new Curso(curso.id(), curso.nome(), curso.ativo());
        return cursoEntity;
    }
}
