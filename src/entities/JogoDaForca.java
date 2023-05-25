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
        String[] palavras = {"java", "gato", "frio", "quente", "chat"}; // Array de string com 5 palavras
        return palavras[ran.nextInt(palavras.length - 1)]; // retorna um número inteiro aleatório entre 0 e o comprimento do array palavras ( nesse caso é 5)
    }

    // Método para transormar a palavra oculta em um vetor
    public static void palavraEscolhida() {
        String palavra = palavraOculta();
        if(palavra == "java") {
            char[] letras = new char[4];
            letras[0] = 'j';
            letras[1] = 'a';
            letras[2] = 'v';
            letras[3] = 'a';
            char[] underline = new char[4];
            underline[0] = '_';
            underline[1] = '_';
            underline[2] = '_';
            underline[3] = '_';
        } else if(palavra == "gato") {
            char[] letras = new char[4];
            letras[0] = 'g';
            letras[1] = 'a';
            letras[2] = 't';
            letras[3] = 'o';
            char[] underline = new char[4];
            underline[0] = '_';
            underline[1] = '_';
            underline[2] = '_';
            underline[3] = '_';
        } else if(palavra == "frio") {
            char[] letras = new char[4];
            letras[0] = 'f';
            letras[1] = 'r';
            letras[2] = 'i';
            letras[3] = 'o';
            char[] underline = new char[4];
            underline[0] = '_';
            underline[1] = '_';
            underline[2] = '_';
            underline[3] = '_';
        } else if(palavra == "quente") {
            char[] letras = new char[6];
            letras[0] = 'q';
            letras[1] = 'u';
            letras[2] = 'e';
            letras[3] = 'n';
            letras[4] = 't';
            letras[5] = 'e';
            char[] underline = new char[6];
            underline[0] = '_';
            underline[1] = '_';
            underline[2] = '_';
            underline[3] = '_';
            underline[4] = '_';
            underline[5] = '_';
        } else if(palavra == "chat") {
            char[] letras = new char[4];
            letras[0] = 'c';
            letras[1] = 'h';
            letras[2] = 'a';
            letras[3] = 't';
            char[] underline = new char[4];
            underline[0] = '_';
            underline[1] = '_';
            underline[2] = '_';
            underline[3] = '_';
        }
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
    public static boolean verificaAcerto(String letraUsuario) {
        boolean resposta; 
        String var = JogoDaForca.palavraOculta();
        if(letraUsuario.equals(var)) {
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
          if(letras[0] == underline[0])  
        }
}

