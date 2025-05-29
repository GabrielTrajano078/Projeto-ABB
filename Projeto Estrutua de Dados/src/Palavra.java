import java.io.BufferedWriter;
import java.io.IOException;

public class Palavra {
    public String palavra;
    public ListaEncadeada<Integer> ocorrencias;

    public void exportarOcorrencias(BufferedWriter writer) throws IOException {
        ListaEncadeada<Integer>.No atual = ocorrencias.getPrimeiro();
        while (atual != null) {
            writer.write(atual.dado + " ");
            atual = atual.proximo;
        }
    }


    public Palavra(String palavra) {
        this.palavra = palavra;
        this.ocorrencias = new ListaEncadeada<>();
    }

    public void adicionarOcorrencia(int linha) {
        if (!ocorrencias.contem(linha)) {
            ocorrencias.inserir(linha);
        }
    }

    public void imprimirOcorrencias() {
        ocorrencias.imprimir();
    }


}
