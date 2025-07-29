package br.pro.em.escola.controllers;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.entities.CursoEntity;
import br.pro.em.escola.interfaces.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CursoControllerTest {

    private DataSource dataSource;
    List<CursoEntity> cursos;

    @BeforeEach
    void setUp() {
        cursos = new ArrayList<>();
        cursos.add(new CursoEntity("1","Biologia", true));
        cursos.add(new CursoEntity("2","Matematica", true));
        cursos.add(new CursoEntity("3","Fisica", false));

        this.dataSource = mock(DataSource.class);
        var cursosAtivos = cursos
                .stream()
                .filter(c -> c.isAtivo())
                .map(c -> new CursoDTO(c.getId(), c.getNome(), c.isAtivo()))
                .toList();
        when(this.dataSource.cursosAtivos()).thenReturn(cursosAtivos);
    }

    @Test
    void listarAtivos() {
        CursoController controller = new CursoController(this.dataSource);
        List<CursoDTO> cursosAtivosTestReturn = controller.listarAtivos();
        assertNotNull(cursosAtivosTestReturn);
        assertEquals(cursosAtivosTestReturn.size(), 2);
        var c_local = cursosAtivosTestReturn.stream().filter(c -> c.id() == "1").findFirst().get();
        var c_total = cursos.stream().filter(c -> c.getId() == "1").findFirst().get();
        assertEquals(c_local.nome(), c_total.getNome());

    }
}