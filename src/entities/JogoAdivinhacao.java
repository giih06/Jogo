package entities;

public class JogoAdivinhacao {
    
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
