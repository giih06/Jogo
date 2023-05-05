package entities;

public class Executor2 {
    public static void main(String[] args) throws Exception {
        String paUsuario = palavraDoUsuario();
        String paOculta = JogoAdivinhacao.palavraOculta();

        if(paUsuario.equals(paOculta)) {
            Impressao.imprimir("Acertou");
        } else {
            Impressao.imprimir("Errou");
        }

    }
}
