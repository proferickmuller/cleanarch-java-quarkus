package br.pro.em.webapi.controller;

import br.pro.em.webapi.data.Pessoa;
import br.pro.em.webapi.data.PessoaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/pessoa")
public class PessoaResource {

    @Inject
    PessoaRepository pessoaRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> todasPessoas() {
        List<Pessoa> all = pessoaRepository.listAll();
        return all;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa pessoaPorId(String id) {
        var pessoa = pessoaRepository.porId(id);
        System.out.println(pessoa);
        return pessoa;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response criarPessoa(NovaPessoaDTO novaPessoaDTO) {
        String novoId;
        do {
            novoId = gerarStringAleatoria(20);
        } while (pessoaRepository.porId(novoId) != null);

        Pessoa p = pessoaRepository.porEnderecoEmail(novaPessoaDTO.enderecoEmail());
        if (p != null) {
            return Response.status(400).entity("Já existe uma pessoa com o mesmo endereço de email.").build();
        }

        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setId(novoId);
        novaPessoa.setNome(novaPessoaDTO.nome());
        novaPessoa.setEndEmail(novaPessoaDTO.enderecoEmail());
        novaPessoa.setDataNascimento(novaPessoaDTO.dataNascimento());

        pessoaRepository.persist(novaPessoa);
        return Response.ok().entity(novaPessoa).build();

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
