package br.pro.em.escola.dtos;

import java.time.LocalDate;

public record MatriculaCompletoDTO(
        String matriculaId,
        String pessoaId,
        String pessoaNome,
        String pessoaEnderecoEmail,
        LocalDate pessoaDataNascimento,
        String cursoId,
        String cursoNome,
        boolean cursoAtivo
) {
}
