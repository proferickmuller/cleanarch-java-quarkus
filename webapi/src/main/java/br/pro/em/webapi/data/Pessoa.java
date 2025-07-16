package br.pro.em.webapi.data;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name="pessoas")
public class Pessoa extends PanacheEntityBase {

    @Id
    private String id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "endereco_email", nullable = false, length = 100)
    private String endEmail;

    @Column(name  = "data_nascimento", nullable = false,  length = 10)
    private String dataNascimento;

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

    public String getEndEmail() {
        return endEmail;
    }

    public void setEndEmail(String endEmail) {
        this.endEmail = endEmail;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
