package br.pro.em.webapi.data;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PessoaRepository implements PanacheRepositoryBase<Pessoa, String> {
    public Pessoa porId(String id) {
        return find("id", id).firstResult();
    }
    public Pessoa porEnderecoEmail(String enderecoEmail) {
        return find("endEmail", enderecoEmail).firstResult();
    }

   
}