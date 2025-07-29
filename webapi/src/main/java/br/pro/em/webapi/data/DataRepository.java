package br.pro.em.webapi.data;

import java.time.LocalDate;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import br.pro.em.escola.dtos.CursoDTO;
import br.pro.em.escola.dtos.MatriculaCompletoDTO;
import br.pro.em.escola.dtos.MatriculaDTO;
import br.pro.em.escola.dtos.PessoaDTO;
import br.pro.em.escola.interfaces.DataSource;

@ApplicationScoped
public class DataRepository implements DataSource {

    @Inject
    PessoaRepository pessoaRepository;

    @Inject
    CursoRepository cursoRepository;

    @Override
    public PessoaDTO pessoaPorId(String id) {
        var p =  pessoaRepository.porId(id);
        if (p == null) {
            return null;
        }
        return toDTO(p);
    }

    @Override
    public void savePessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.id());
        pessoa.setNome(pessoaDTO.nome());
        pessoa.setEndEmail(pessoaDTO.enderecoEmail());
        var dataNascimento = pessoaDTO.dataNascimento().toString();
        pessoa.setDataNascimento(dataNascimento);
        pessoaRepository.persist(pessoa);
    }

    @Override
    public List<CursoDTO> cursosAtivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cursosAtivos'");
    }

    @Override
    public CursoDTO cursoPorId(String idCurso, boolean ativo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cursoPorId'");
    }

    @Override
    public CursoDTO cursoPorId(String idCurso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cursoPorId'");
    }

    @Override
    public MatriculaDTO obterMatricula(String idPessoa, String idCurso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterMatricula'");
    }

    @Override
    public MatriculaCompletoDTO obterMatriculaPorId(String matriculaId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterMatriculaPorId'");
    }

    @Override
    public void saveMatricula(MatriculaDTO m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveMatricula'");
    }

    @Override
    public PessoaDTO pessoaPorEnderecoEmail(String enderecoEmail) {
        var p = pessoaRepository.porEnderecoEmail(enderecoEmail);
        if (p == null) {
            return null;
        }
        return toDTO(p);
    }

    private PessoaDTO toDTO(Pessoa p) {
        return new PessoaDTO(
                p.getId(),
                p.getNome(),
                p.getEndEmail(),
                LocalDate.parse(p.getDataNascimento())
        );
    }

}


