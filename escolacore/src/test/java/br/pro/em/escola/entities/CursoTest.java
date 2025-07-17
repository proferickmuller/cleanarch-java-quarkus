package br.pro.em.escola.entities;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    @Test
    void newCursoEntityWorksAsExpected() {
        Curso curso = new Curso("123", "Curso de Testes", true);

        assertEquals("123", curso.getId());
        assertEquals("Curso de Testes", curso.getNome());
        assertTrue(curso.isAtivo());
    }

    @Test
    void newCursoEntityDoesNotWorkAsExpected() {

        Exception exception = assertThrows(
                ConstraintViolationException.class,
                () -> new Curso("", "Curso de Testes", false)
        );


    }

}