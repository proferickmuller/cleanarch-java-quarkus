package br.pro.em.escola.entities;

public class Matricula {

    private final Curso curso;
    private final Pessoa pessoa;
    private final String id;

    public Matricula(String id, Pessoa pessoa, Curso curso) {
        this.id = id;
        this.pessoa = pessoa;
        this.curso = curso;
    }



}
