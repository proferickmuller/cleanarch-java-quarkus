package br.pro.em.escola.gateways;

import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.entities.PessoaEntity;
import br.pro.em.escola.interfaces.DataSource;

public class PessoaGateway implements IPessoaGateway {

    private final DataSource dataSource;

    public PessoaGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(PessoaEntity p) {
        PessoaDTO pessoaDTO = new PessoaDTO(
                p.getId(),
                p.getNome(),
                p.getEnderecoEmail(),
                p.getDataNascimento()
        );

        this.dataSource.savePessoa(pessoaDTO);
    }

    @Override
    public PessoaEntity obterPorId(String id) {
        var pessoaDTO = this.dataSource.pessoaPorId(id);
        
        if (pessoaDTO == null) {
            return null;
        }
        
        var pessoa = toEntity(pessoaDTO);
        return pessoa;
    }

    @Override
    public PessoaEntity obterPorEnderecoEmail(String enderecoEmail) {
        var pessoaDTO = this.dataSource.pessoaPorEnderecoEmail(enderecoEmail);
        if (pessoaDTO == null) {
            return null;
        }
        var pessoa = toEntity(pessoaDTO);
        return pessoa;
    }

    private PessoaEntity toEntity(PessoaDTO pessoaDTO) {
        var pessoa = new PessoaEntity(
                pessoaDTO.id(),
                pessoaDTO.nome(),
                pessoaDTO.enderecoEmail(),
                pessoaDTO.dataNascimento()
        );

        return pessoa;
    }
}
