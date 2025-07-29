package br.pro.em.webapi.controller;

import br.pro.em.webapi.data.Curso;
import br.pro.em.webapi.data.CursoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/v1/curso")
public class CursoResource {

    @Inject
    CursoRepository cursoRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Curso> listarTodos() {
        List<Curso> cursos = cursoRepository.listAll();
        return cursos;
    }
}
