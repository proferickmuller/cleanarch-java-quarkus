package br.pro.em.escola.entities;

public class MatriculaEntity {

    private final CursoEntity curso;
    private final PessoaEntity pessoa;
    private final String id;

    public MatriculaEntity(String id, PessoaEntity pessoa, CursoEntity curso) {
        this.id = id;
        this.pessoa = pessoa;
        this.curso = curso;
    }



}
