package entities;
import java.util.Scanner; 
/**
 * @author Samuel Pereira
 * @version 1.0
 * 
 */
public class JogoSudoko {
<<<<<<< HEAD
    public static void jogar () {
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
        poCasas = defOcup(poCasas, m);        
        do {
            keepAsk = true;
            System.out.println();
            showM(m);
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
                showPosFix(poCasas, m);
            } else {
                if (possibleHere(m, l, c, chosenNB)) {
                    m[l][c] = chosenNB;
                } else {
                    exibitM(m, l, c, chosenNB);
                }
            }
            // Continua até finalizar o jogo
            if (verifyTabM(Sudoku))
                keepAsk = false;
            pressEnter();
        } while (keepAsk);
        System.out.println("Parabéns");
    }
=======
    
>>>>>>> ff159f21d1fe62a28b522b0526dcd187888b3daf
    public static boolean possibleHere(int[][] m, int l, int c, int numero) {
        // Questiona se o número correto está na linha
        for (int i = 0; i < m[0].length; i++) {
            if (m[l][i] == numero)
                return false;
        }      
        // Ou se ta na coluna
        for (int i = 0; i < m.length; i++) {
            if (m[i][c] == numero)
                return false;
        }
        // Verifica os Boxes
        int boxLinha = l - l % 3;
        int boxColuna = c - c % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (m[boxLinha + i][boxColuna + j] == numero)
                    return false;
            }
        }
        return true; // Caso tudo esteja certo, então o jogo acaba né?
    }

    // Cria as tabelas e as casas da tabela
    public static void showM(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.print("L" + (i+1) + " - ");
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
                if (j == 2 || j == 5) System.out.print("| ");
            }
            System.out.println();
            if (i == 2 || i == 5)
                System.out.print("     ------|-------|------\n");
        }
    }
    // Mostra os movimentos bloqueiados
    public static void exibitM(int[][] m, int l, int c, int numero) {
        int[][] newM = copyM(m);
        // Cores
        String resetar = "\u001B[0m";
        String RedBlueBackground = "\u001B[31;46m";
        String RedWhiteBackground = "\u001B[41;43m";

        // Cada par representa uma posição de destaque
        /*  L e C == Linha e Coluna: Representa a jogada do usuário 
        / Primeiro par: Bloqueio na l 
        / Segundo  par: Bloqueio na c 
        / Terceiro par: Bloqueio na caixa */
        int[] posDest = {l, c, -1, -1, -1, -1, -1, -1};
        System.out.println("    " + RedWhiteBackground + " Movimento inválido! " + resetar);
        newM[l][c] = numero;

        // Verifica a linha L
        for (int i = 0; i < m.length; i++) {
            if (m[l][i] == numero) {
                posDest[2] = l;
                posDest[3] = i;
            }
        }
        // Verifica a Coluna C
        for (int i = 0; i < m.length; i++) {
            if (m[i][c] == numero) {
                posDest[4] = i;
                posDest[5] = c;   
            }
        }

        // Verifica os boxes
        int boxLinha = l - l % 3;
        int boxColuna = c - c % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (m[boxLinha + i][boxColuna + j] == numero) {
                    posDest[6] = boxLinha + i;
                    posDest[7] = boxColuna + j;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            System.out.print((i+1) + " - ");
            for (int j = 0; j < m.length; j++) {
                    boolean destaques = showDest(posDest, i, j);

                    /*  
                    posDest(Valores Pares) && posDest(Valores Impares)
                    */
                    if (destaques)            
                        System.out.print(RedBlueBackground + newM[i][j] + " " + resetar);
                    else
                        System.out.print(newM[i][j] + " ");

                if (j == 2 || j == 5) System.out.print("| "); // Divisorias
            }
            System.out.println();
            if (i == 2 || i == 5)
                System.out.print("    ------|-------|-------\n"); // Divisorias
        }
    }
    // Define os valroes em destaque
    public static boolean showDest(int[] posDest, int i, int j){
        for (int k = 0; k < posDest.length; k++) {
            int l = k; int c = k + 1;
            if(posDest[l] == i && posDest[c] == j) {
                return true;
            }
            k++;
        }
        return false;
    }
    public static int[][] copyM(int[][] m) {
        int[][] newM = new int[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                newM[i][j] = m[i][j];
            }
        }
        return newM;
    }
    // Exibe as posições fixas
    public static void showPosFix(boolean [][] poCasas, int[][] m) {
        String resetar = "\u001B[0m";
        String RedBlueBackground = "\u001B[31;46m";

        for (int i = 0; i < m.length; i++) {
            System.out.print((i+1) + " - ");
            for (int j = 0; j < m.length; j++) {
                    if (poCasas[i][j])            
                        System.out.print(RedBlueBackground + m[i][j] + " " + resetar);
                    else
                        System.out.print(m[i][j] + " ");

                if (j == 2 || j == 5) System.out.print("| "); // Divisorias internas vertical
                System.out.println();
            }
            if (i == 2 || i == 5)
                System.out.print("    ------|-------|-------\n"); // Divisorias internas horizontal
        }
    }
    // Define a ocupação das casas
    static boolean[][] defOcup(boolean[][] poCasas, int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != 0)
                    poCasas[i][j] = true;
            }
        }
        return poCasas;
    }
    // Verifica o tabuleiro por completo
    public static boolean verifyTabM(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if(m[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    // Pressiona Enter para continuar
    public static void pressEnter() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pressione Enter para continuar...");
        sc.nextLine();
    }
}