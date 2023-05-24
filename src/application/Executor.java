package application;
import entities.Impressao;
import entities.JogoDaForca;

public class Executor {
    // Executor
    public static void main(String[] args) throws Exception {
        JogoDaForca forca = new JogoDaForca();
        Impressao.imprimir(forca);

    }
}
