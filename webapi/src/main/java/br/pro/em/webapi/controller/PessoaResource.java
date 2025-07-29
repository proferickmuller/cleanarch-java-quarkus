package br.pro.em.webapi.controller;

import br.pro.em.escola.controllers.PessoaController;
import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.exceptions.PessoaJaExistenteException;
import br.pro.em.webapi.controller.comm.NovaPessoaDTO;
import br.pro.em.webapi.data.DataRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

@Path("/api/v1/pessoa")
public class PessoaResource {

    @Inject
    DataRepository dataRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response pessoaPorId(String id) {
        PessoaController pessoaController = PessoaController.build(dataRepository);
        PessoaDTO pessoaDTO = pessoaController.obterPessoaPorId(id);
        if (pessoaDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Pessoa não encontrada").build();
        }
        return Response.ok().entity(pessoaDTO).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response criarPessoa(NovaPessoaDTO novaPessoaDTO) {
        LocalDate dataNascimento = LocalDate.parse(novaPessoaDTO.dataNascimento());

        PessoaDTO pessoaDTO;

        try {
            PessoaController pessoaController =  PessoaController.build(dataRepository);
            pessoaDTO = pessoaController.novaPessoa(
                    novaPessoaDTO.nome(),
                    novaPessoaDTO.enderecoEmail(),
                    dataNascimento
            );
        } catch (PessoaJaExistenteException e) {
            var msg = "Endereco de email ja registrado: " +  e.getMessage();
            return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
        }

        if (pessoaDTO == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Pessoa não criada").build();
        }

        return Response.ok().entity(pessoaDTO).build();
    }

    public static String gerarStringAleatoria(int tamanho) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(tamanho);
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

}
