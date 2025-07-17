package br.pro.em.escola.usecases;

import br.pro.em.escola.dtos.NovaPessoaDTO;
import br.pro.em.escola.entities.PessoaEntity;
import br.pro.em.escola.gateways.IPessoaGateway;
import br.pro.em.escola.util.Generator;

import javax.swing.*;

public class NovaPessoaUseCase {

    IPessoaGateway pessoaGateway;

    public NovaPessoaUseCase(IPessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public PessoaEntity run(NovaPessoaDTO novaPessoaDTO) {
        // ver se o novo id existe.
        String novoId = "";
        do {
            novoId = Generator.gerarStringAleatoria(20);
        } while (pessoaGateway.obterPorId(novoId) == null);

        PessoaEntity p = new PessoaEntity(
                novoId,
                novaPessoaDTO.nome(),
                novaPessoaDTO.enderecoEmail(),
                novaPessoaDTO.dataNascimento()
        );

        var pn = this.pessoaGateway.save(p);
        return pn;
    }

}
