package br.pro.em.escola.interfaces;

import br.pro.em.escola.dtos.PessoaDTO;

public interface DataSource {
    PessoaDTO PessoaPorId(String id);
}
