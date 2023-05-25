package entities;

import java.util.Random;
import java.util.Scanner;

// Giovanna Mendonça Federico
public class JogoDaForca {
    // Construtor
    public JogoDaForca() {

    }

    // Método para definir a palavra oculta
    public static String palavraOculta() {
        Random ran = new Random(); // Chamei a classe Random que gera números aleatórios
        String[] palavras = {"java", "gato", "frio", "mente", "chat"}; // Array de string com 5 palavras
        return palavras[ran.nextInt(palavras.length - 1)]; // retorna um número inteiro aleatório entre 0 e o comprimento do array palavras ( nesse caso é 5)
    }

    // Método para transormar a palavra oculta em um vetor
    public static char[] palavraEscolhida() {
        char[] letras = new char[4];
        String palavra = palavraOculta();
        if(palavra == "java") {
            letras[0] = 'j';
            letras[1] = 'a';
            letras[2] = 'v';
            letras[3] = 'a';
        } else if(palavra == "gato") {
            letras[0] = 'g';
            letras[1] = 'a';
            letras[2] = 't';
            letras[3] = 'o';
        } else if(palavra == "frio") {
            letras[0] = 'f';
            letras[1] = 'r';
            letras[2] = 'i';
            letras[3] = 'o';
        } else if(palavra == "quente") {
            letras[0] = 'm';
            letras[1] = 'e';
            letras[2] = 'n';
            letras[3] = 't';
            letras[4] = 'e';
        } else if(palavra == "chat") {
            letras[0] = 'c';
            letras[1] = 'h';
            letras[2] = 'a';
            letras[3] = 't';
        }
        return letras;
    }


    // Método para efetuar a estratégia // AJUDA
    public static void estrategia() {

    }

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

    // Método para efetuar a jogada 
    public static String digitaLetra() { // AJUDA
        Scanner sc = new Scanner(System.in); 
            for(int i=0; i <= 5; i++) { 
                System.out.print("\nInforme a letra da" + (i+1) + "tentativa: ");
            }
            return sc.next();
    }

    // Método para validar a jogada // AJUDA
    public static boolean verificaAcerto(char letraUsuario) {
        boolean resposta; 
        char[] var = new JogoDaForca().palavraEscolhida();
        if(letraUsuario.equals(palavraEscolhida())) {
            resposta = true;
        } else {
            resposta = false;
        }
        return resposta;
        }

        // Método para efetuar a estratégia // AJUDA
        public static void efetuaEstrategia() {

        }

        // Método para identificar o vencedor / perdedor // AJUDA
        public static String Placar() {
            String a = "a";
            return a;
        }
}

