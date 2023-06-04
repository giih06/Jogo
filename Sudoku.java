import java.util.Scanner;
import java.util.Random;
public class Sudoku {
/**
 * @author Samuel Pereira
 * @version 1.02
 */
	
	public static void main(String[] args) {
		/**
		 * Variaveis que vão ser usadas
		 * Cores, unicode 
		 * Scanner = SC
		 * Matriz = M
		 * 
		 * Boleanos Um pra validar as variaveis
		 * e o outro pra continuar questionando 
		 * usado na parte do Aperte enter
		 * 
		 * Linha e Coluna == L > linha, C > coluna
		 * ChosenNB > Número escolhido
		 *  nivDif > Nivel de dificuldade
		 */
        String resetColor = "\u001B[0m";
        String backgroundColor = "\u001B[31;46m";
        String outroBackground = "\u001B[41;43m";
        Scanner sc = new Scanner(System.in);
        int[][] m = new int[9][9];
        boolean[][] poCasas = new boolean[9][9];
        int l = -1, c = -1, chosenNB = -1, nivDif = 0;
        boolean keepAsk = true;
        int[][] sudoku = gerValidSudoku(1);
		sudoku = gerValidSudoku(1);
		for (int i = 0; i < sudoku.length; i++) {
    		for (int j = 0; j < sudoku[i].length; j++) {
       		m[i][j] = sudoku[i][j];
   			}
		}
        System.out.println(backgroundColor +
						   "****************************************\n"
						  +"*                                      *\n"
						  +resetColor+outroBackground+
						  "*            JOGO DE SUDOKU            *\n"
						  +resetColor+backgroundColor
						  +"*                                      *\n"
						  +"****************************************\n"
						  +"*                                      *\n"
						  +resetColor+outroBackground+
						  "*    Dificuldades Disponíveis:         *\n"
						  +resetColor+backgroundColor
						  +"*                                      *\n"
						  +resetColor+outroBackground+
						  "*   1. Fácil                           *\n"
						  +resetColor+backgroundColor
						  +resetColor+outroBackground+
						  "    2. Médio                           *\n"
						  +resetColor+backgroundColor
						  +resetColor+outroBackground+
						  "*   3. Díficil                         *\n"
						  +resetColor+backgroundColor
						  +"*                                      *\n"
						  +"****************************************\n"
						  + resetColor);
		
		do {
			System.out.println("Digite o número da opção desejada:\n> ");
			nivDif = Integer.parseInt(sc.next());
			if(nivDif < 1 || nivDif > 3)
				System.out.println("Opção inválida, escolha 1, 2 ou 3");
			else
				keepAsk = false;
		} while (keepAsk);
        if (nivDif == 1) {
            sudoku = gerValidSudoku(1);
            exibitM(sudoku, 8, 8, 3);
        }
        if (nivDif == 2) {
            sudoku = gerValidSudoku(2);
            exibitM(sudoku, 8, 8, 3);
        }
        if (nivDif == 3) {
            sudoku = gerValidSudoku(3);
            exibitM(sudoku, 8, 8, 3);
        }
		poCasas = defyOcupation(poCasas, m);        
        do {
            keepAsk = true;
            System.out.println();
            showM(m);
            // Questiona o usúario os valores a ser inseridos no tabuleiro
            System.out.println("Informe números de 1 a 9 para linha, coluna e o número a ser inserido no tabuleiro.");
            do {
                System.out.print("Linha > ");
                l = Integer.parseInt(sc.next()) - 1;
            
                System.out.print("Coluna > ");
                c = Integer.parseInt(sc.next()) - 1;
            
                System.out.print("Número > ");
                chosenNB = Integer.parseInt(sc.next());
                // Números escolhidos de 1 a 9, não pode se menor que 1 e maior que 9
                if(l < 0 || l > 8 || c < 0 || c > 8 || chosenNB < 1 || chosenNB > 9)
                    System.out.println(outroBackground + "Somente números de 1 a 9 são válidos!" + resetColor);
                else
                    keepAsk = false;
            } while (keepAsk);
            keepAsk = true; // Quando finaliza, retorna para questionar novamente
            // Linhas que não podem ser alteradas
            if(poCasas[l][c]) {
                System.out.println(outroBackground + " Essas posicões são fixas, você não pode alterá-las! " + resetColor);
                showPosFix(poCasas, m);
            } else {
                if (possibleHere(m, l, c, chosenNB)) {
                    m[l][c] = chosenNB;
                } else {
                    exibitM(m, l, c, chosenNB);
                }
            }
            // Continua até finalizar o jogo
            if (verifyTab(sudoku))
                keepAsk = false;
            Enter();
        } while (keepAsk);
        System.out.println("Parabéns");
	}
	
	/**
	 *  A primeira parte, define a quantidade de céluals a serem zeradas
	 *  com base na dificuldade
	 *  Depois na outra parte, vem o aleatorizador, que vai de forma
	 *  aleatoria, duh, vai zerar algumas células com base na quantidade
	 *  definida 
	 */
	 public static int[][] gerValidSudoku(int nivDif) {
		int[][] m = new int[9][9];
	
		// Zera todas as células da matriz
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = 0;
			}
		}
		// Define a quantidade de células a serem preenchidas com base na dificuldade
		int celulas;
		if (nivDif == 1) {
			celulas = 30; // Fácil
		} else if (nivDif == 2) {
			celulas = 40; // Médio
		} else if (nivDif == 3) {
			celulas = 50; // Difícil
		} else {
			System.out.println("Nível de dificuldade inválido.");
			return null;
		}
		// Preenche de maneira aleatória com valores de 1 a 9
		Random aleatorio = new Random();
		int celulasFull = 0;
		while (celulasFull < celulas) {
			int l = aleatorio.nextInt(9);
			int c = aleatorio.nextInt(9);
			int value = aleatorio.nextInt(9) + 1;
			if (m[l][c] == 0 && possibleHere(m, l, c, value)) {
				m[l][c] = value;
				celulasFull++;
			}
		}
	
		return m;
	}
	/**
	 * Questiona se pode colocar um número na linha
	 */
	public static boolean possibleHere(int[][] m , int l, int c, int n){
		int boxL = l - l % 3;
		int boxC = c - c % 3;
		// Está na linha?
		for (int i = 0; i < m[0].length; i ++) {
			if(m[l][i] == n)
				return false;
		}
		// Ou está na coluna?
		for (int i = 0; i < m.length; i++) {
			if(m[i][c] == n)
				return false;
		}
			//Verifica nos boxes
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(m[boxL + i][boxC + j] == n)
					return false;
			}
		}
		return true; 
	}
/**
 * Analisa os movimentos que são bloqueados
 * E devolve a resposta para o usuário
 * m = Matriz
 * l = Linha
 * c = Coluna
 * n = Número
 */
public static void exibitM(int[][] m, int l, int c, int n) {
    int[][] newM = copyM(m);
    String resetColor = "\u001B[0m";
    String backgroundColor = "\u001B[31;46m";
    String outroBackground = "\u001B[41;43m";
    String headColor = "\u001B[104m";
    String lineColor = "\u001B[106m";

    int boxL = l - l % 3;
    int boxC = c - c % 3;

    /** Cada par representa uma posição de destaque
     *  L e C == Linha e Coluna: Representa a jogada do usuário 
     * Primeiro par: Bloqueio na l = Linha 
     * Segundo  par: Bloqueio na c = Coluna
     * Terceiro par: Bloqueio na caixa 
     */
    int[] posDest = {l, c, -1, -1, -1, -1, -1, -1};
    System.out.println("    " + outroBackground + " Movimento inválido " + resetColor);
    newM[l][c] = n;

    // Verifica a linha
    for(int i = 0; i < m.length; i++) {
        if(m[l][i] == n) {
            posDest[2] = l;
            posDest[3] = i;
        }
    }
    // Verifica a coluna
    for(int i = 0; i < m.length; i++) {
        if(m[i][c] == n) {
            posDest[4] = i;
            posDest[5] = c;
        }
    }
    // Verifica os boxes
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j ++) {
            if(m[boxL+i][boxC+j] == n) {
                posDest[6] = boxL + i;
                posDest[7] = boxC + j;
            }
        }
    }
    /**
     *  posDest(¨¨valores pares) && posDest(¨¨valores impares)
     *  postDest[0] == i && postDest[1] == j até 7
     */
	System.out.print(headColor + "     C1 C2 C3 |  C4 C5 C6 |  C7 C8 C9\n" + resetColor); 
    for(int i = 0; i < m.length; i++) {
        System.out.print(lineColor + "L"+(i+1) + " - "+ resetColor);
        for(int j = 0; j < m.length; j++) {
            boolean destQ = shDest(posDest, i, j);
            if (destQ) {
                System.out.print(outroBackground + newM[i][j] + resetColor + outroBackground + "  " + resetColor);
			} else {
                System.out.print(backgroundColor + newM[i][j] + "  " + resetColor); }
            if (j == 2 || j == 5) System.out.print(headColor + "|  " + resetColor);
        }
        System.out.println();
        if (i == 2 || i == 5)
            System.out.println(headColor + "     ---------|-----------|-----------\n" + resetColor);
		}
	}
	/**
	 * Ele que é utilizado quando o usúario tenta modificar um número
	 * ja gerado pela maquina, ou tentar alterar um número ja correto
	 *
	 */
	public static void showPosFix(boolean [][] poCasas, int[][] m) {
        String resetColor = "\u001B[0m";
        String backgroundColor = "\u001B[102m";
        String headColor = "\u001B[104m";
        String lineColor = "\u001B[106m";
		
        
		System.out.print(headColor + "     C1 C2 C3 |  C4 C5 C6 |  C7 C8 C9\n" + resetColor); 
        for (int i = 0; i < m.length; i++) {
             System.out.print(lineColor + "L" + (i+1) + " - " + resetColor);
             for (int j = 0; j < m.length; j++) {
                 System.out.print(backgroundColor + m[i][j] + resetColor + backgroundColor +"  "+ resetColor);
                 if (j == 2 || j == 5) System.out.print(headColor + "|  " + resetColor);
             }
             System.out.println();
             if (i == 2 || i == 5)
                 System.out.print(headColor + "     ---------|-----------|-----------\n" + resetColor);	
		}
	}
	
	/**
	 * Cria as tabelas e as casas da tabela de matrizes
	 *  A parte do codigo "L" (i+1) - é para indentificar as linhas. 
	 *  Depois dessa parte ele começa a alinhar os números com 
	 *  o System.out.print(m[i][j] + "" então as | com J == 2 para fazer
	 *  a barra da divisão depois do C3 e J == 5 pra fazer depois do C6
	 *  pois ele trabalha da mesma forma que as matrizes de 0 1 2 3
	 *  
	 *   Strings de cor usando Unicode
	 *   
	 */
	public static void showM(int[][] m) {
        String resetColor = "\u001B[0m";
        String backgroundColor = "\u001B[102m";
        String headColor = "\u001B[104m";
        String lineColor = "\u001B[106m";
        
        System.out.print(headColor + "     C1 C2 C3 |  C4 C5 C6 |  C7 C8 C9\n" + resetColor); 
        for (int i = 0; i < m.length; i++) {
             System.out.print(lineColor + "L" + (i+1) + " - " + resetColor);
             for (int j = 0; j < m.length; j++) {
                 System.out.print(backgroundColor + m[i][j] + resetColor + backgroundColor +"  "+ resetColor);
                 if (j == 2 || j == 5) System.out.print(headColor + "|  " + resetColor);
             }
             System.out.println();
             if (i == 2 || i == 5)
                 System.out.print(headColor + "     ---------|-----------|-----------\n" + resetColor);
         }
     } 
	
	/**
	 * Essa classe vai analizar as posições em destaque
	 * Resumindo, quando você adicionar um número
	 * ela vai pegar e vai comparar com as linhas da matriz, se é
	 * possivel adicionar aquele número na linha escolhida.
	 * Porém essa é so uma parte do cálculo
	 * 
	 */
	public static boolean shDest (int[] posDest, int i, int j) {
		for(int k = 0; k < posDest.length; k++) {
			int l =  k; int c = k + 1;
			if(posDest[l] == i && posDest[c] == j) {
				return true;
			}
			k++;
		}
		return false;
	} 
	
	/** 
	 * Ele copia as matriz ja geradas e fazem com que seja mais facil
	 *  eu adicionar em outras partes do código. Na verdade eu so
	 *  usei em uma parte, mas mesmo assim eu crio uma classe
	 *  pra ficar mais facil pra usar.
	 *  
	 */
	public static int[][] copyM (int[][] m) {
		int[][] newM = new int[m.length][m[0].length];
		for (int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				newM[i][j] = m[i][j];
			}
		}
		return newM;
	}
			
	/**
	 * Aqui, nessa parte do codigo eu utilizo pra criar as 
	 * divisórias da vertical e da horizontal
	 * Além de ficar a parte onde as cores são definidas 
	 * para amostrar o usúario, quais partes estão erradas.
	 */
	public static void posFix(boolean[][] slots, int[][] m) {
		String reset = "\u001B[0m"; // Cor pra amostar os erros
        String YellowHighLight = "\u001B[31;46m";
		for (int i = 0; i < m.length; i++) {
			System.out.print((i+1) + " - ");
			for (int j = 0; j < m.length; j++) {
                if (slots[i][j])            
                	System.out.print(YellowHighLight + m[i][j] + " " + reset); // Highlite dos erros
                else
                    System.out.print(m[i][j] + " ");
			if (j == 2 || j == 5)
				System.out.print("| "); // Divisórias da vertical	
			}
			System.out.println(); // Tem que colocar aqui, se colocar antes a amostragem fica errada
			if(i == 2 || i == 5)
				System.out.print("    ------|-------|-------\n");  // Divisórias da Horizontal
		}
	}
	
	/**
	 * Essa função vai fazer a analize dos valores que estão fixos
	 * Caso o valor seja diferente de zero, vai retornar verdadeiro
	 * Caso seja 0 ele vai reotrnar a variavel (slots)
	 */
	public static boolean[][] defyOcupation(boolean[][] slots, int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++){
				if (m[i][j] != 0)
					slots[i][j] = true;
			}
		}
		return slots;
	}
						
	/**
	 * Faz a verificação do tabuleiro, caso o valor retorne falso, ele da erro,
	 * caso dê verdadeiro ele continua até finalizar o jogo
	 * Tem um algoritmo mais acima que responde ao usuário quando todas as al-
	 * ternativas estiverem preenchidas.
	 */
	public static boolean verifyTab(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if(m[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	/** Pressiona Enter para continuar
	 * 
	 */
	public static void Enter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Pressione pra continuar");
		sc.nextLine();
	}
}
