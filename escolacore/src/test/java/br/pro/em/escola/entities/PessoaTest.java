package br.pro.em.escola.entities;

import jakarta.validation.ConstraintViolationException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @org.junit.jupiter.api.Test
    void newPessoaEntityWorksAsExpected() {
        Pessoa p = new Pessoa(
                "123", "Erick", "erick@teste.com", LocalDate.of(2000,1,1)
        );

        assertEquals("123", p.getId());
        assertEquals("Erick", p.getNome());
        assertEquals("erick@teste.com", p.getEnderecoEmail());
        assertEquals(LocalDate.of(2000,1,1), p.getDataNascimento());
    }

    @org.junit.jupiter.api.Test
    void newPessoaEntityFails() {
        LocalDate dataNascimento = LocalDate.of(2020, 1, 1);

        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            Pessoa p = new Pessoa(
                    "123",
                    "Erick",
                    "erick",
                    dataNascimento
            );
        });
    }

}