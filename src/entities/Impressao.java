package entities;
import java.util.Scanner;
import entities.*;

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
			System.out.println("Jogo da Forca");
			JogoDaForca forca = new JogoDaForca();
			forca.jogar();
			break;
		
		case 3:
			System.out.println("Jogo da Velha");
			break;
			
		default:
			
			break;
			
		}

		sc.close();

    
    }
    
    public static void imprimirSudoku(){
        /* Define Cores */
        String resetar = "\u001B[0m";     
        String messageSystem = "\u001B[41;43m"; 
        /* Define cores*/
        Scanner sc = new Scanner(System.in);

        int[][] m = new int[9][9]; // Matriz que vai ser usada.
        int l = -1, c = -1, chosenNB = -1, levelDiff = -1;

        boolean keepAsk = true; // Garante validez dos números digitados.
        boolean[][] poCasas = new boolean[9][9]; // Posições físicas das quais não podem ser alteradas

        // Dificuldade Fácil
        int[][] easy = {{0,8,0,0,0,5,0,0,0},{0,3,9,2,0,1,0,8,7},{0,0,6,0,8,0,9,2,0},{7,2,0,0,0,0,0,3,0},
            {0,0,4,0,0,0,1,0,0},{0,6,0,0,0,0,0,7,2},{0,4,5,0,3,0,7,0,0},{8,7,0,1,0,9,2,6,0},{0,0,0,5,0,0,0,9,0}};

        // Dificuldade Médium
        int[][] medium = {{7,8,0,0,0,0,0,3,0},{0,0,0,0,3,0,0,0,0},{0,6,3,5,0,2,0,0,0},{3,0,0,0,0,1,9,4,0},
            {0,0,0,4,0,5,0,0,0},{0,4,2,3,0,0,0,0,8},{0,0,0,2,0,9,3,6,0},{0,0,0,0,8,0,0,0,0},{0,5,0,0,0,0,0,1,4}};

        // Dificuldade Hard
        int[][] hard = {{8,1,0,0,0,0,0,2,7},{0,0,4,0,0,0,1,0,0},{2,3,0,0,0,0,0,4,5},{0,0,0,1,7,4,0,0,0},
            {4,0,0,5,0,6,0,0,9},{0,7,0,0,3,0,0,1,0},{0,0,0,0,1,0,0,0,0},{0,4,3,0,0,0,6,5,0},{1,0,0,3,0,7,0,0,8}};

        // Dificuldade Módelo Base
        int[][] Sudoku = {{8,1,0,0,0,0,0,2,7},{0,0,4,0,0,0,1,0,0},{2,3,0,0,0,0,0,4,5},{0,0,0,1,7,4,0,0,0},
            {4,0,0,5,0,6,0,0,9},{0,7,0,0,3,0,0,1,0},{0,0,0,0,1,0,0,0,0},{0,4,3,0,0,0,6,5,0},{1,0,0,3,0,7,0,0,8}};


        System.out.println("********************************************");
        System.out.println("*              JOGO DE SUDOKU              *");
        System.out.println("*                                          *");
        System.out.println("********************************************");
        System.out.println("*          Dificuldades disponíveis:       *");
        System.out.println("*                 1. Fácil                 *");
        System.out.println("*                 2. Médio                 *");
        System.out.println("*                 3. Dificil               *");
        System.out.println("********************************************");

        // Seleção de dificuldade        
        do {
            System.out.print("Digite o numero da opção desejada:\n> ");
            levelDiff = Integer.parseInt(sc.next());
            if (levelDiff < 1 || levelDiff > 3)
                System.out.println(messageSystem + "Opção inválida! Escolha 1, 2 ou 3" + resetar);
            else
                keepAsk = false;
        } while (keepAsk);

        if (levelDiff == 1) {
            m = easy;
            System.out.print("     " + messageSystem + " Dificuldade: Fácil  " + resetar);
        }
        if (levelDiff == 2) {
            m = medium;
            System.out.print("     " + messageSystem + " Dificuldade: Médio  " + resetar);
        }
        if (levelDiff == 3) {
            m = hard;
            System.out.print("     " + messageSystem + " Dificuldade: Difícil" + resetar);
        }
        poCasas = JogoSudoko.defOcup(poCasas, m);        
        do {
            keepAsk = true;
            System.out.println();
            JogoSudoko.showM(m);
            // Questiona o usúario os valores a ser inseridos no tabuleiro
            System.out.println("Informe números de 1 a 9 para l, c e numero a ser inserido no tabuleiro.");
            do {
                System.out.print("Linha > ");
                l = Integer.parseInt(sc.next()) - 1;

                System.out.print("Coluna > ");
                c = Integer.parseInt(sc.next()) - 1;

                System.out.print("Número > ");
                chosenNB = Integer.parseInt(sc.next());
                if(l < 0 || l > 8 || c < 0 || c > 8 || chosenNB < 1 || chosenNB > 9)
                    System.out.println(messageSystem + "Somente números de 1 a 9 são válidos!" + resetar);
                else
                    keepAsk = false;
            } while (keepAsk);
            keepAsk = true; // Quando finaliza, retorna para questionar novamente
            // Linhas que não podem ser alteradas
            if(poCasas[l][c]) {
                System.out.println(messageSystem + " Essas posicões são fixas, você não pode alterá-las! " + resetar);
                JogoSudoko.showPosFix(poCasas, m);
            } else {
                if (JogoSudoko.possibleHere(m, l, c, chosenNB)) {
                    m[l][c] = chosenNB;
                } else {
                    JogoSudoko.exibitM(m, l, c, chosenNB);;
                }
            }
            // Continua até finalizar o jogo
            if (JogoSudoko.verifyTabM(Sudoku))
                keepAsk = false;
            JogoSudoko.pressEnter();
        } while (keepAsk);
        System.out.println("Parabéns");
    }
    
    public static void imprimir(double arg){
        System.out.println(arg);
    }
    
    public static void imprimir(String arg){
        System.out.println(arg);
    }
    
    public static void imprimir(boolean arg){
        System.out.println(arg);
    }

}

