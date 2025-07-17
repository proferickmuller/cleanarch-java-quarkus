package br.pro.em.escola.gateways;

import br.pro.em.escola.entities.Pessoa;
import br.pro.em.escola.interfaces.DataSource;

public class PessoaGateway implements IPessoaGateway {

    private final DataSource dataSource;

    public PessoaGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Pessoa p) {
        this.dataSource.savePessoa(p);
    }

    @Override
    public Pessoa obterPorId(String id) {
        var pessoaDTO = this.dataSource.pessoaPorId(id);
        var pessoa = new Pessoa(
                pessoaDTO.id(),
                pessoaDTO.nome(),
                pessoaDTO.enderecoEmail(),
                pessoaDTO.dataNascimento()
        );

        return pessoa;
    }
}
