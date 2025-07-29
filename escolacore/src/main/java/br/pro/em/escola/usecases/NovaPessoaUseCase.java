package br.pro.em.escola.usecases;

import br.pro.em.escola.entities.PessoaEntity;
import br.pro.em.escola.exceptions.PessoaJaExistenteException;
import br.pro.em.escola.gateways.PessoaGateway;
import br.pro.em.escola.util.Generator;

import java.time.LocalDate;

public class NovaPessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public NovaPessoaUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public PessoaEntity run(String nome, String enderecoEmail, LocalDate dataNascimento) {
        String novoId;
        do {
            novoId = Generator.gerarStringAleatoria(20);
        } while (this.pessoaGateway.obterPorId(novoId) != null);

        // essa pessoa já existe?
        PessoaEntity p = this.pessoaGateway.obterPorEnderecoEmail(enderecoEmail);
        if (p != null) {
            throw new PessoaJaExistenteException(enderecoEmail);
        }

        PessoaEntity pessoaEntity = new PessoaEntity(novoId, nome, enderecoEmail, dataNascimento);
        this.pessoaGateway.save(pessoaEntity);
        return pessoaEntity;
    }

}
