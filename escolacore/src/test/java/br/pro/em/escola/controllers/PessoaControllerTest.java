package br.pro.em.escola.controllers;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.PessoaEntity;
import br.pro.em.escola.interfaces.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaControllerTest {

    private PessoaEntity pessoaCriada;

    @BeforeEach
    void setUp() {
        pessoaCriada = new PessoaEntity(
                "123",
                "Erick",
                "erick@em.pro.br",
                java.time.LocalDate.of(2000, 1, 1)
        );

    }

    @Test
    void TestNovaPessoaOk()
    {
        DataSource dataSource = mock(DataSource.class);
        when(dataSource.pessoaPorId(anyString())).thenReturn(null);

        PessoaController pessoaController = PessoaController.build(dataSource);
        PessoaDTO pessoaDTO = pessoaController.novaPessoa(
                pessoaCriada.getNome(),
                pessoaCriada.getEnderecoEmail(),
                pessoaCriada.getDataNascimento());
        assertNotNull(pessoaDTO);
        assertEquals(pessoaCriada.getNome(), pessoaDTO.nome());
        assertEquals(pessoaCriada.getEnderecoEmail(), pessoaDTO.enderecoEmail());
        assertEquals(pessoaCriada.getDataNascimento(), pessoaDTO.dataNascimento());
    }


}