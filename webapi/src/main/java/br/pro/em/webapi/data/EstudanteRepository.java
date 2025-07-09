package br.pro.em.webapi.data;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstudanteRepository implements PanacheRepositoryBase<Estudante, Integer> {}
