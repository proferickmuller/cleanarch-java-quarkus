package br.pro.em.webapi.controller;

import br.pro.em.webapi.data.Estudante;
import br.pro.em.webapi.data.EstudanteRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import br.pro.em.escola.resource.TesteResource;

@Path("/estudante")
public class EstudanteResource {

    @Inject
    private EstudanteRepository estudanteRepository;

    @GET
    @Path("/curso/{curso}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<br.pro.em.webapi.data.Estudante> getEstudantePorCurso(String curso) {
        var t = new TesteResource("Teste de recurso");
        t.teste();

        return estudanteRepository.find("curso", curso).firstResult();
    }

    @GET
    @Path("/pessoa/{pessoaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public br.pro.em.webapi.data.Estudante getEstudantePorPessoaId(String pessoaId) {
        return estudanteRepository.find("pessoaId", pessoaId).firstResult();
    }

    @POST
    @Transactional
    public String criarEstudante(Estudante estudante) {
        estudanteRepository.persist(estudante);
        return "OK";
    }
}
