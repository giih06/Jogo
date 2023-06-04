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
        String[] palavras = {"Java", "Gato", "Frio", "Mente", "Chat"}; // Array de string com 5 palavras
        return palavras[ran.nextInt(palavras.length)]; // retorna aleatoriamente uma das 5 palavras do array "palavra"
    }

    // método da palavra adivinhada
    public void inicializarPalavraOculta() { 
        palavraOculta = obterPalavraOculta().toLowerCase(); // atribui o metodo a variavel e converte a palavra oculta para letras minusculas
        palavraAtual = "_".repeat(palavraOculta.length()); // cada letra da palavra oculta será substituida por um "_" 
    }

    // Método para validar a jogada
    public boolean validarJogada(char letra) {
        letra = Character.toLowerCase(letra); // a letra fornecida será convertida para miníscula
        return palavraOculta.contains(String.valueOf(letra)); // Verifica se a palavra oculta contém a letra fornecida.O metodo valueOf da classe String converte a letra em uma string. O método contains() é usado para verificar se a letra está presente na palavra. Se a letra estiver presente, o método retorna true, indicando que a jogada é válida. Caso contrário, retorna false, indicando que a jogada é inválida.
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
        letra = Character.toLowerCase(letra); // converte a letra digitada para minúsculo
        if (validarJogada(letra)) { // se a letra informada estiver presente na palavra oculta
            StringBuilder novaPalavraAtual = new StringBuilder(palavraAtual); // cria-se uma representação atual da palavra oculta
            // StringBuilder é usado quando você precisa modificar uma string com frequência, pois ele oferece métodos para adicionar, remover ou substituir caracteres em uma sequência de caracteres.
            for (int i = 0; i < palavraOculta.length(); i++) { // percorre cada posição da palavra oculta
                if (palavraOculta.charAt(i) == letra) { // verifica-se se a letra na posição i é igual à letra informada. e o charAt retorna o caractere em uma localização específica em uma String
                    novaPalavraAtual.setCharAt(i, letra); // se a letra for encontrada, ela é substituída na novaPalavraAtual na mesma posição i. o método charAt substitui a letra na posição especificada, nesse caso é i
                }
            }
            palavraAtual = novaPalavraAtual.toString(); // A palavraAtual é atualizada com o conteúdo da novaPalavraAtual convertida de volta para uma String.

            if (!palavraAtual.contains("_")) { // Se a palavra atual não houver mais "_"
                jogoTerminado = true; // o jogo foi terminado
                jogadorVenceu = true; // e o jogador venceu
            }
        } else { // se a letra não estiver na palavra oculta
            tentativasRestantes--; // são diminuidas as tentativas restantes
            if (tentativasRestantes <= 0) { // se as tentativas restantes forem menor ou igual a zero
                jogoTerminado = true; // o jogo termina e o jogador perdeu
            }
        }
    }

    // método para a forca
    public void exibirForca() {
        System.out.println(" ______     ");
        System.out.println("|      |    ");
    
        if (tentativasRestantes < 6) {
            System.out.println("|      O    ");
        } else {
            System.out.println("|            ");
        }
    
        if (tentativasRestantes <= 4) {
            if (tentativasRestantes == 4) {
                System.out.println("|      |    ");
            } else if (tentativasRestantes == 3) {
                System.out.println("|     /|    ");
            } else if (tentativasRestantes == 2) {
                System.out.println("|     /|\\  ");
            } else if (tentativasRestantes == 1) {
                System.out.println("|     /|\\  ");
                System.out.println("|     /     ");
            } else if (tentativasRestantes == 0) {
                System.out.println("|     /|\\  ");
                System.out.println("|     / \\  ");
            }
        } else {
            System.out.println("|            ");
            System.out.println("|            ");
        }
    
        System.out.println("|");
        System.out.println("|");
        System.out.println("|_____");
        System.out.println();
    }
}

