package br.pro.em.escola.util;

public class Generator {
    public static String gerarStringAleatoria(int tamanho) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(tamanho);
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    public static String gerarNumericoAleatorio(int tamanho) {
        if (tamanho >= 10) {
            throw new IllegalArgumentException("O tamanho deve ser menor que 10");
        }

        String caracteres = "0123456789";
        java.util.Random random = new java.util.Random();
        double numero = random.nextLong(1, (long)Math.pow(10, tamanho));

        return String.format("%09d", (long) numero);
    }
}
