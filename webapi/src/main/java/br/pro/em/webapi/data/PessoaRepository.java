package br.pro.em.webapi.data;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.interfaces.DataSource;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PessoaRepository implements PanacheRepositoryBase<Pessoa, String>, DataSource {
    public Pessoa porId(String id) {
        return find("id", id).firstResult();
    }
    public Pessoa porEnderecoEmail(String enderecoEmail) {
        return find("endEmail", enderecoEmail).firstResult();
    }


    @Override
    public Pessoa PessoaPorId(String id) {
        return find("id", id).firstResult();
    }
}