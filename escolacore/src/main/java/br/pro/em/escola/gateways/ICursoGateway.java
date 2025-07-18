package br.pro.em.escola.gateways;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.entities.CursoEntity;

import java.util.List;

public interface ICursoGateway {
    List<CursoEntity> listarAtivos();
}
