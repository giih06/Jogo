package entities;
import java.util.Scanner;


public class JogoDaVelha {
	
	public static void construir_tabuleiro(int tabuleiro[][], int flag) {
		// Função responsável por construir e exibir o tabuleiro de jogo da velha
		
		System.out.print("\n");
		for(int i=0; i<3; i++) {
			if(i>0)
				System.out.println("\n\t---|---|---");
			System.out.print("\t");
			for(int j=0; j<3; j++) {
				if(flag==1)
					System.out.printf(" %d ",3*i+j); // Mostra as posições do tabuleiro
				else if(tabuleiro[i][j]==0)
					System.out.printf("   "); // Mostra espaços vazios no tabuleiro
				else if(tabuleiro[i][j]==1)
					System.out.printf(" X "); // Mostra jogadas do jogador 1
				else if(tabuleiro[i][j]==2)
					System.out.printf(" O "); // Mostra jogadas do jogador 2

				if(j<2)
					System.out.print("|");
			}
		}
		System.out.print("\n\n");
	}
	
	public static void introducao(int tabuleiro[][]) {
		// Função responsável por exibir a introdução e o tabuleiro inicial do jogo
		
		System.out.println("Bem vindo ao jogo da velha!");
		System.out.println("===============================");
		System.out.println("Esse é o tabuleiro e suas posições:");
		construir_tabuleiro(tabuleiro,1); // Exibe o tabuleiro com as posições
		System.out.println("Você poderá sempre rever as posições do tabuleiro digitando 9");
		System.out.println("\nO jogador 1 será X");
		System.out.println("O jogador 2 será O");
		System.out.println("\nVamos começar!");
		System.out.println("=================================");
	}
	
	public static void efetuar_jogada (int tabuleiro[][], int rodada) {
		// Função responsável por solicitar e efetuar uma jogada
		
		Scanner input = new Scanner(System.in);
		int posicao=0,flag=0;
		
		if((rodada%2)==0) {
			System.out.println("\nVEZ DO JOGADOR 1");
			construir_tabuleiro(tabuleiro,0);
			
			while(flag==0) {
				do {
					System.out.print("Escolha sua posição (para relembrar as posições digite 9): ");
					posicao = input.nextInt();
				}while(posicao>9);
				
				if(posicao==9) {
					System.out.print("\nPOSICÕES ");
					construir_tabuleiro(tabuleiro,1);
					System.out.print("\nEscolha sua posição: ");
					posicao = input.nextInt();
				}
				
				int i=posicao/3;
				int j=posicao%3;
				
				if(tabuleiro[i][j]==0) {
					flag=1;
					tabuleiro[i][j]=1; // Marca a jogada do jogador 1 no tabuleiro
				}
				else
					System.out.println("Essa posição já está ocupada!!");
				
				construir_tabuleiro(tabuleiro,0);
			}
		}
		else {
			System.out.println("\nVEZ DO JOGADOR 2");
			construir_tabuleiro(tabuleiro,0);
			
			while(flag==0) {
				do {
					System.out.print("Escolha sua posição (para relembrar as posições digite 9): ");
					posicao = input.nextInt();
				}while(posicao>9);
				
				if(posicao==9) {
					System.out.print("\nPOSICÕES ");
					construir_tabuleiro(tabuleiro,1);
					System.out.print("\nEscolha sua posição: ");
					posicao = input.nextInt();
				}
				
				int i=posicao/3;
				int j=posicao%3;
				
				if(tabuleiro[i][j]==0) {
					flag=1;
					tabuleiro[i][j]=2; // Marca a jogada do jogador 2 no tabuleiro
				}
				else
					System.out.println("Essa posição já está ocupada!!");
				
				construir_tabuleiro(tabuleiro,0);
			}
		}
	}
	
	public static int verifica_vitoria(int tabuleiro[][]) {
		// Função responsável por verificar se houve um vencedor ou empate
		
		int flag=0;
		
		for(int i=0;i<3;i++) {
			// Verifica linhas
			if(tabuleiro[i][0]==tabuleiro[i][1] && tabuleiro[i][1]==tabuleiro[i][2])
				return tabuleiro[i][0]; // Retorna o jogador que venceu
		}
		
		for(int j=0;j<3;j++) {
			// Verifica colunas
			if(tabuleiro[0][j]==tabuleiro[1][j] && tabuleiro[1][j]==tabuleiro[2][j])
				return tabuleiro[0][j]; // Retorna o jogador que venceu
		}
					
		if(tabuleiro[0][0]==tabuleiro[1][1] && tabuleiro[1][1]==tabuleiro[2][2]) {
			// Verifica diagonal
			return tabuleiro[0][0]; // Retorna o jogador que venceu
		}
		
		if(tabuleiro[0][2]==tabuleiro[1][1] && tabuleiro[1][1]==tabuleiro[2][0]) {
			// Verifica diagonal
			return tabuleiro[0][2]; // Retorna o jogador que venceu
		}
		
		for(int i=0;i<3;i++) {
			// Verifica empate
			for(int j=0;j<3;j++) {
				if(tabuleiro[i][j]==0)
					flag=1;
			}
		}
		
		if(flag==0)
			return 3; // Retorna empate
		
		return 0; // Retorna nenhum vencedor ou empate ainda
	}

}