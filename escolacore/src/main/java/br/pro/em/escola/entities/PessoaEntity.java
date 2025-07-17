package br.pro.em.escola.entities;


public class PessoaEntity {

    private  String id;
    private  String nome;
    private  String enderecoEmail;
    private  String dataNascimento;

    public PessoaEntity(
            String id,
            String nome,
            String enderecoEmail,
            String dataNascimento
    ) {
        if (id.trim().equals("")) {
            throw new RuntimeException("ID invalido");
        }

        if (nome.trim().equals("")) {
            throw new RuntimeException("Nome invalido");
        }

        if (enderecoEmail.trim().equals("")) {
            throw new RuntimeException("Endereco de email invalido");
        }

        if (dataNascimento.trim().equals("")) {
            throw new RuntimeException("data de nascimento invalida");
        }

        // if idade < 18, throw excecao

        this.id = id;
        this.nome = nome;
        this.enderecoEmail = enderecoEmail;
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
