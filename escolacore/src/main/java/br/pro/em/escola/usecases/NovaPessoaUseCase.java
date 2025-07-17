package br.pro.em.escola.usecases;

import br.pro.em.escola.entities.Pessoa;
import br.pro.em.escola.gateways.IPessoaGateway;
import br.pro.em.escola.util.Generator;

import java.time.LocalDate;

public class NovaPessoaUseCase {

    private final IPessoaGateway pessoaGateway;

    public NovaPessoaUseCase(IPessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public Pessoa run(String nome, String enderecoEmail, LocalDate dataNascimento) {
        String novoId;
        do {
            novoId = Generator.gerarStringAleatoria(20);
        } while (this.pessoaGateway.obterPorId(novoId) != null);

        Pessoa pessoa = new Pessoa(novoId, nome, enderecoEmail, dataNascimento);
        this.pessoaGateway.save(pessoa);
        return pessoa;
    }

}
