package br.pro.em.webapi.controller.comm;

public record NovaPessoaDTO(
    String nome, 
    String enderecoEmail, 
    String dataNascimento
){}
