package entities;

public class JogoAdivinhacao {
    // a função dos vetores é pra guardar um mesmo tipo de dado 
    // métoso para retornar a palavra oculta
    public static String palavraOculta() {
        String palavra;
        int chave = 0;
        switch (chave) {
            case 1: palavra = "Treinamento"; break;
            case 2: palavra = "Lógica"; break;
            case 3: palavra = "java"; break;
            default: palavra = "Salvador"; break;
        }
        return palavra;
    }
}
