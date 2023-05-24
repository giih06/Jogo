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
        String[] palavras = {"java", "professor", "frio", "quente", "chat"}; // Array de string com 5 palavras
        return palavras[ran.nextInt(palavras.length - 1)]; // retorna um número inteiro aleatório entre 0 e o comprimento do array palavras ( nesse caso é 5)
    }

    // método para a forca do enforcado
    @Override
    public String toString() {
        return "-------\n|      |\n|      |\n|\n|\n|\n|\n-----"; 
    }

    // Método para efetuar a jogada 
    public static String digitaLetra() { // AJUDA
        Scanner sc = new Scanner(System.in); 
            for(int i=0; i <= 6; i++) { 
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
        public static void Placar() {

        }
}

