package entities;

import java.util.Random;

// Giovanna Mendonça Federico
// PROBLEMAS: quando o usuário acerta, a forca continua colocando parte do corpo
public class JogoDaForca {

    // Declarando os atributos
    private String palavraOculta;
    public String palavraAtual;
    private int tentativasRestantes;
    public boolean jogoTerminado;
    public boolean jogadorVenceu;

    // Construtor
    public JogoDaForca() {
        tentativasRestantes = 6;
        jogoTerminado = false;
        jogadorVenceu = false;
    }

    // Método para definir a palavra oculta
    public String obterPalavraOculta() {
        Random ran = new Random(); // Chamei a classe Random que gera números aleatórios
        String[] palavras = {"java", "gato", "frio", "mente", "chat"}; // Array de string com 5 palavras
        return palavras[ran.nextInt(palavras.length)]; // retorna aleatoriamente uma das 5 palavras do array "palavra"
    }

    // método da palavra adivinhada
    public void inicializarPalavraOculta() {
        palavraOculta = obterPalavraOculta();
        palavraOculta.toLowerCase();
        palavraAtual = "_".repeat(palavraOculta.length());
    }

    // Método para validar a jogada
    public boolean validarJogada(char letra) {
        letra = Character.toLowerCase(letra); // a letra fornecida será convertida para miníscula
        return palavraOculta.contains(String.valueOf(letra)); // Verifica se a palavra oculta contém a letra fornecida. A palavra oculta é armazenada como uma string na variável palavraOculta. O método contains() é usado para verificar se a letra está presente na palavra. Se a letra estiver presente, o método retorna true, indicando que a jogada é válida. Caso contrário, retorna false, indicando que a jogada é inválida.
    }

    // Método para identificar o vencedor / perdedor
    public void Placar() {
        if (jogadorVenceu) {
            System.out.println("Parabéns! Você venceu o jogo!");
        } else {
            System.out.println("Você perdeu o jogo, a palavra correta era " + palavraOculta);
        }
    }

    // Método para efetuar a estratégia
    public void efetuarEstrategia(char letra) {
        letra = Character.toLowerCase(letra);
        if (validarJogada(letra)) { // se a letra informada estiver na palavra oculta
            StringBuilder novaPalavraAtual = new StringBuilder(palavraAtual);
            for (int i = 0; i < palavraOculta.length(); i++) {
                if (palavraOculta.charAt(i) == letra) {
                    novaPalavraAtual.setCharAt(i, letra);
                }
            }
            palavraAtual = novaPalavraAtual.toString();

            if (!palavraAtual.contains("_")) {
                jogoTerminado = true;
                jogadorVenceu = true;
            }
        } else { // se a letra não estiver na palavra oculta
            tentativasRestantes--;
            if (tentativasRestantes <= 0) {
                jogoTerminado = true;
            }
        }
    }

    // método para a forca
    public void exibirForca() {
        System.out.println(" ______     ");
        System.out.println("|      |    ");
    
        if (tentativasRestantes < 6) {
            System.out.println("|      O    ");
        }
    
        if (tentativasRestantes <= 4) {
            if(tentativasRestantes == 4) {
                System.out.println("|      |    ");
            } else if(tentativasRestantes == 3) {
                System.out.println("|     /|    ");
            } else if (tentativasRestantes == 2) {
                System.out.println("|     /|\\  ");
            } else if (tentativasRestantes == 1) {
                System.out.println("|     /|\\  ");
                System.out.println("|     /     ");
            }
        }
    
        if (tentativasRestantes <= 0) {
            System.out.println("|     / \\  ");
        }
        System.out.println("|");
        System.out.println("|");
        System.out.println("|_____");
        System.out.println();
    }
}

