package br.pro.em.escola.gateways;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.entities.Curso;

import java.util.List;

public interface ICursoGateway {
    List<Curso> listarAtivos();
}
