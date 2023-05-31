package entities;

import java.util.Random;
import java.util.Scanner;

// Giovanna Mendonça Federico
public class JogoDaForca {

    // método para a forca
    public static void forca(String[] args) {
        System.out.println("------");
        System.out.println("|    |");
        System.out.println("|     ");
        System.out.println("|     ");
        System.out.println("|     ");
        System.out.println("---");
    }
    // métodos para o enforcado
    public static void enforcado0(String[] args) {
        System.out.println("------");
        System.out.println("|    |");
        System.out.println("|    O");
        System.out.println("|     ");
        System.out.println("|     ");
        System.out.println("---");
    }

    public static void enforcado1(String[] args) {
        System.out.println("------");
        System.out.println("|    |");
        System.out.println("|    O");
        System.out.println("|    |");
        System.out.println("|     ");
        System.out.println("---");
    }

    public static void enforcado2(String[] args) {
        System.out.println("------");
        System.out.println("|    |");
        System.out.println("|    O");
        System.out.println("|   /|");
        System.out.println("|     ");
        System.out.println("---");
    }

    public static void enforcado3(String[] args) {
        System.out.println("------");
        System.out.println("|    |");
        System.out.println("|    O");
        System.out.println("|   /|\\");
        System.out.println("|     ");
        System.out.println("---");
    }

    public static void enforcado4(String[] args) {
        System.out.println("------");
        System.out.println("|    |");
        System.out.println("|    O");
        System.out.println("|   /|\\");
        System.out.println("|   /  ");
        System.out.println("---");
    }

    public static void enforcado5(String[] args) {
        System.out.println("------");
        System.out.println("|    |");
        System.out.println("|    O");
        System.out.println("|   /|\\");
        System.out.println("|   / \\");
        System.out.println("---");
    }
    // atributos
    String letrasUsadas = "";
    String palavraAdivinhada = "";
    int maxTentativas = 10;
    // Construtor
    public JogoDaForca() {

    }

    // Método para definir a palavra oculta
    public static String palavraOculta() {
        Random ran = new Random(); // Chamei a classe Random que gera números aleatórios
        String[] palavras = {"java", "gato", "frio", "mente", "chat"}; // Array de string com 5 palavras
        return palavras[ran.nextInt(palavras.length)]; // retorna aleatoriamente uma das 5 palavras do array "palavra"
    }

    // Método para efetuar a jogada 
    public static String digitaLetra() { // remover isso
        Scanner sc = new Scanner(System.in); 
            for(int i=0; i <= 5; i++) { 
                System.out.print("\nInforme a letra da" + (i+1) + "tentativa: ");
            }
            return sc.next();
    }

    // Método para validar a jogada // AJUDA
    public boolean verificaAcerto() {
    }

    // Método para efetuar a estratégia // AJUDA
    public void efetuaEstrategia() {
        // 
        for(int i=0; i < palavraOculta().length(); i++) {
            palavraAdivinhada += "_";
            
            // Conta as tentativas
            for(int tentativas = 0; ; tentativas++) {

                System.out.println("Informe a letra da " + tentativas + "a tentativa: "); // cada tentativa é mostrado a rodada

                char letraTentada = new Scanner(System.in).next().charAt(0);// pega a entrada do usuário (.next lê a string até o primeiro espaço e o charAt Retorna o caractere em uma localização específica em uma String)

                // verifica se a letra é repetida               
                // se o caractere de letra tentada for encontrado em letras usadas, retornará -1. Caso seja encontrada, retornará 1, ou seja, será uma letra repetida
                if(letrasUsadas.indexOf(letraTentada) >= 0){ 
                    System.out.println("Você já tentou a letra " + letraTentada);
                } else {
                    letrasUsadas += letraTentada;// adicionando as letras usadas ás tentadas

                    // Caso a letra tentada exista na palavra oculta, então execute:
                    if(palavraOculta().indexOf(letraTentada) >= 0) {
                        palavraAdivinhada = ""; // substituir _ pela letra

                        // loop do comprimento da palavra oculta para substituir os _ pelas letras tentadas que existem na palavra oculta
                        for(int j=0; j<palavraOculta().length(); j++) {
                            //  pegamos o indice das letras usadas e verifica se a palavra oculta, na posição j, existe. Se existir, pega a letra da palavra chave e coloca na palavra adivinhada e se nao existir coloca o _
                            palavraAdivinhada += letrasUsadas.indexOf(palavraOculta().charAt(j)) >= 0 ? palavraOculta().charAt(j) : "_";
                        }

                        // análise se o jogo continua ou nao(se há mais "_")
                        if(palavraAdivinhada.contains("_")) {
                            System.out.println("Ainda existem letras escondidas");
                        } else {
                            System.out.println("Parabéns, a palavra adivinhada era " + palavraAdivinhada);
                            System.exit(0);
                        }

                    // Caso a letra tentada não exista na palavra oculta, então execute:
                    } else {
                        System.out.println("Infelizmente a letra " + letraTentada + "não existe na palavra");
                    }

                }

                // número de tentativa do usuário for igual a 10
                if(tentativas == maxTentativas) {
                    System.out.println("Já se foram 10 tentativas, a palavra era" + palavraOculta());

                    System.exit(0); // finaliza o programa
                }
            }
        }
    }

    // Método para identificar o vencedor / perdedor // AJUDA
    public String Placar() {
    }
}

