package entities;

import java.util.Random;

public class JogoAdivinhacao {
    // a função dos vetores é pra guardar um mesmo tipo de dado 
    // métoso para retornar a palavra escondida
    /* Vamos definir algumas palebras, e o usuário (executor)
     * vai tentar adivinhar a palavra */
    public static String palavraEscondida() {
        Random rd = new Random();
        String[] palavras = {"Bacalhau", "Universidade", "Java", "Objeto", "Reforma", "Programação", "Nenhuma"};
        return palavras[rd.nextInt(palavras.length - 1)];
    }
}
