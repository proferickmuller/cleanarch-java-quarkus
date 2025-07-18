package br.pro.em.escola.entities;

import jakarta.validation.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.Set;

public class PessoaEntity {

    @NotNull @NotBlank final private String id;
    @NotNull @NotBlank final private String nome;
    @NotNull @Email final private String enderecoEmail;
    @Past final private LocalDate dataNascimento;

    public PessoaEntity(
            String id,
            String nome,
            String enderecoEmail,
            LocalDate dataNascimento
    ) {
        this.id = id;
        this.nome = nome;
        this.enderecoEmail = enderecoEmail;
        this.dataNascimento = dataNascimento;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<PessoaEntity>> violations = validator.validate(this);

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

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
