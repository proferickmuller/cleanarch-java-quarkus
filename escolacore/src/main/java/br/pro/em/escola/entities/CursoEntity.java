package br.pro.em.escola.entities;

import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class CursoEntity {

    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @NotBlank
    private String nome;

    private boolean ativo;

    public CursoEntity(
            String id,
            String nome,
            boolean ativo
    ) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CursoEntity>> violations = validator.validate(this);

        if  (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
