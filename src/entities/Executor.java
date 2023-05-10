package entities;

import java.util.Scanner;

public class Executor {
    public static void main(String[] args) throws Exception {
        String resposta = palavraInformada().toUpperCase();
        Impressao.imprimir(verificaAcerto(resposta));
    }

    public static boolean verificaAcerto(String palavraUsuario) {
        boolean res;
        String var = JogoAdivinhacao.palavraEscondida();
        if(palavraUsuario.equals(var)) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public static String palavraInformada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Usuário, digite a palavra oculta: ");
        return sc.next();
    }
}
