package br.pro.em.escola.resource;

public class TesteResource {
    private final String mensagem;

    public TesteResource(String mensagem) {
        this.mensagem = mensagem;
    }

    public void teste() {
        System.out.println("Mensagem: " + mensagem);
    }
}
