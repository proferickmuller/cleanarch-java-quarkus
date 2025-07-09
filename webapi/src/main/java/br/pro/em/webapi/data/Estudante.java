package br.pro.em.webapi.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name="estudantes")
public class Estudante extends PanacheEntity {

    @Column(name="pessoaId", nullable = false, unique = true)
    private String pessoaId;

    @Column(name="curso", nullable = false, length = 100)
    private String curso;

    public String getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(String pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
