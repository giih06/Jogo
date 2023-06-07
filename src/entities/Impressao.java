package entities;
import java.util.Scanner;

public class Impressao {

    public static void imprimirMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------");
		System.out.println("|               MENU DE JOGOS!!!            |");
		System.out.println("---------------------------------------------");
		System.out.println("1- Sudoku  2- Jogo Da Forca  3- Jogo Da Velha");
		System.out.println("---------------------------------------------");
		System.out.print("Informe o numero do jogo desejado: ");
		int jogoEscolhido = sc.nextInt();
		System.out.println("---------------------------------------------");
		
		
		switch (jogoEscolhido) {
		case 1:
			Impressao.imprimirSudoku();
			break;

		case 2:
			Impressao.imprimirJogoDaForca();
			break;
		
		case 3:
			Impressao.imprimirJogoDaVelha();
			break;
			
		default:
			
			break;
			
		}

		sc.close();

    
    }
    
    public static void imprimirSudoku(){
        JogoSudoko.jogoSudoku();
    }
    
    public static void imprimirJogoDaVelha(){
        int tabuleiro[][] = new int[3][3];
		int vencedor=0;
		
		JogoDaVelha.introducao(tabuleiro); // Exibe a introdução e o tabuleiro inicial do jogo
		
		for(int rodada=0;vencedor==0;rodada++) {
			// Loop principal do jogo
			
			JogoDaVelha.efetuar_jogada(tabuleiro, rodada);; // Solicita e efetua uma jogada
			
			vencedor=JogoDaVelha.verifica_vitoria(tabuleiro); // Verifica se há um vencedor ou empate
		}
		
		if(vencedor==1)
			System.out.println("JOGADOR 1 É O VENCEDOR!! PARABÉNS!!");
		else if(vencedor==2)
			System.out.println("JOGADOR 2 É O VENCEDOR!! PARABÉNS!!");
		else if(vencedor==3)
			System.out.println("EMPATE!!");
		
		System.out.print("Obrigado por jogar!");
    }

    // Método para efetuar a jogada
    public static void imprimirJogoDaForca() {
        JogoDaForca jogo = new JogoDaForca(); // instanciei o jogo da forca
        jogo.exibirForca(); // exibe a forca

        Scanner sc = new Scanner(System.in);
        jogo.inicializarPalavraOculta(); // inicializa a palavra oculta a ser adivinhada

        while (!jogo.jogoTerminado) {  // enquanto o jogo não tiver terminado 
            System.out.println("Palavra atual: " + jogo.palavraAtual); // exibe a palavra atualmente adivinhada pelo jogador
            System.out.print("Digite uma letra: ");
            char letra = sc.nextLine().charAt(0); // pula a linha e lê converte a letra em char e armazena a letra na variável "letra"
            jogo.efetuarEstrategia(letra); // efetua a estratégia da letra
            jogo.exibirForca(); // atualiza a exibição visual da forca após a jogada
        }

        jogo.Placar(); // exibe o placar final da jogada
        sc.close();
    }

}
