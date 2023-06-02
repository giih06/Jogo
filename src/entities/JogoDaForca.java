package entities;

import java.util.Random;
import java.util.Scanner;

// Giovanna Mendonça Federico
// PROBLEMAS: quando o usuário acerta, a forca continua colocando parte do corpo
public class JogoDaForca {

    // Declarando os atributos
    private String letrasUsadas;
    private String palavraAdivinhada;
    private int maxTentativas;
    private int tentativas;

    // Construtor
    public JogoDaForca() {
        letrasUsadas = "";
        palavraAdivinhada = "";
        maxTentativas = 6;
        tentativas = 0;
    }

    // Método para definir a palavra oculta
    public String obterPalavraOculta() {
        Random ran = new Random(); // Chamei a classe Random que gera números aleatórios
        String[] palavras = {"java", "gato", "frio", "mente", "chat"}; // Array de string com 5 palavras
        return palavras[ran.nextInt(palavras.length)]; // retorna aleatoriamente uma das 5 palavras do array "palavra"
    }

    // método da palavra adivinhada
    private void inicializarPalavraAdivinhada() {
        // enqunato não tiver atingido o tamanho maximo da palavra
        for (int i = 0; i < obterPalavraOculta().length(); i++) {
            palavraAdivinhada += "_"; // a palavra adivinhada será preenchida com _
        }
    }

    // Método para validar a jogada
    public boolean validarJogada(char letraTentada) {
        // verifica se a letra é repetida               
        // se o caractere de letra tentada for encontrado em letras usadas, retornará -1. Caso seja encontrada, retornará 1, ou seja, será uma letra repetida
        if (letrasUsadas.indexOf(letraTentada) >= 0) {
            return false; // letra repetida
        } else {
            letrasUsadas += letraTentada; // adicionando as letras usadas ás tentadas
            return true;
        }
    }

    // Método para efetuar a estratégia
    public void efetuarEstrategia(char letraTentada) {
        palavraAdivinhada = ""; // substituir _ pela letra

        // loop do comprimento da palavra oculta para substituir os _ pelas letras tentadas que existem na palavra oculta
        for (int j = 0; j < obterPalavraOculta().length(); j++) {
            //  pegamos o indice das letras usadas e verifica se a palavra oculta, na posição j, existe. Se existir, pega a letra da palavra chave e coloca na palavra adivinhada e se nao existir coloca o _
            palavraAdivinhada += letrasUsadas.indexOf(obterPalavraOculta().charAt(j)) >= 0 ? obterPalavraOculta().charAt(j) : "_";
        }

        // Caso a letra tentada não exista na palavra oculta, então execute:
        if (obterPalavraOculta().indexOf(letraTentada) < 0) { // quando o indexof retorna -1 significa que não existe a letra tentada dentro da palavra oculta
            System.out.println("Infelizmente a letra " + letraTentada + " não existe na palavra");
            tentativas++; // conta mais uma tentativa
        }
    }

    // Método para identificar o vencedor / perdedor
    public void Placar(boolean venceu) {
        if (venceu) {
            System.out.println("Parabéns! Você venceu o jogo!");
        } else {
            System.out.println("Você perdeu o jogo. Tente novamente!");
        }
    }

    // Método para efetuar a jogada
    public void jogar() {
        for (int tentativas = 0; tentativas < maxTentativas; tentativas++) { // serão percorridas as 6 tentativas
            exibirForca(tentativas);
            inicializarPalavraAdivinhada();
            System.out.println("Informe a letra da " + (tentativas + 1) + "ª tentativa: ");
            char letraTentada = new Scanner(System.in).next().charAt(0); //Pega a entrada do usuário (.next lê a string até o primeiro espaço e o charAt Retorna o caractere em uma localização específica em uma String)

            if (validarJogada(letraTentada)) { // se a letra não for repetida 
                efetuarEstrategia(letraTentada); // substitua a letra pelo _ e caso não exista, avise

                if (palavraAdivinhada.contains("_")) { // se a palavra adivinhada ainda não foi descoberta
                    System.out.println("Ainda existem letras escondidas");
                } else { // se o usuário descobriu a palavra
                    System.out.println("Parabéns, a palavra adivinhada era " + palavraAdivinhada);
                    Placar(true);
                    System.exit(0);
                }
            } else { // se a letra for repetida
                System.out.println("Você já tentou a letra " + letraTentada);
            }
        }

        System.out.println("Já se foram 10 tentativas, a palavra era " + obterPalavraOculta());
        Placar(false);
        System.exit(0);
    }


    // método para a forca
    public void exibirForca(int tentativas) {
        if(tentativas == 0) {

        }
    }

    // método para a forca
    // public void exibirForca(int tentativas) {
    //     switch (tentativas) {
    //         case :
    //             System.out.println("------");
    //             System.out.println("|    |");
    //             System.out.println("|    O");
    //             System.out.println("|     ");
    //             System.out.println("|     ");
    //             System.out.println("---");
    //             break;
    //         case 2:
    //             System.out.println("------");
    //             System.out.println("|    |");
    //             System.out.println("|    O");
    //             System.out.println("|    |");
    //             System.out.println("|     ");
    //             System.out.println("---");
    //             break;
    //         case 3:
    //             System.out.println("------");
    //             System.out.println("|    |");
    //             System.out.println("|    O");
    //             System.out.println("|   /|");
    //             System.out.println("|     ");
    //             System.out.println("---");
    //             break;
    //         case 4:
    //             System.out.println("------");
    //             System.out.println("|    |");
    //             System.out.println("|    O");
    //             System.out.println("|   /|\\");
    //             System.out.println("|     ");
    //             System.out.println("---");
    //             break;
    //         case 5:
    //             System.out.println("------");
    //             System.out.println("|    |");
    //             System.out.println("|    O");
    //             System.out.println("|   /|\\");
    //             System.out.println("|   /  ");
    //             System.out.println("---");
    //             break;
    //         case 6:
    //             System.out.println("------");
    //             System.out.println("|    |");
    //             System.out.println("|    O");
    //             System.out.println("|   /|\\");
    //             System.out.println("|   / \\");
    //             System.out.println("---");
    //             break;
    //         default:
    //         System.out.println("------");
    //         System.out.println("|    |");
    //         System.out.println("|     ");
    //         System.out.println("|     ");
    //         System.out.println("|     ");
    //         System.out.println("---");
    //         break;
    //     }
    // }

}

