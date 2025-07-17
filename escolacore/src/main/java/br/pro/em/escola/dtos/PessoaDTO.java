package br.pro.em.escola.dtos;

import java.time.LocalDate;

public record PessoaDTO(
        String id,
        String nome,
        String enderecoEmail,
        LocalDate dataNascimento
) {
}
