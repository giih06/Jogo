package application;
import entities.Impressao;
import entities.JogoDaForca;
import java.util.Scanner;

public class Executor {
    // Executor
    public static void main(String[] args) throws Exception {
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
			System.out.println("Sudoku");
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
}
