public class Main {
    public static void main(String[] args) {
        String[] palavrasChave = LeitorArquivo.lerPalavrasChaveDeArquivo("/Users/gabriel/projetos/Projeto Estrutua de Dados/src/palavras.txt");

        LeitorArquivo leitor = new LeitorArquivo(palavrasChave);
        leitor.lerArquivo("/Users/gabriel/projetos/Projeto Estrutua de Dados/src/estrutura.txt");
        leitor.imprimir();
        leitor.exportar("/Users/gabriel/projetos/Projeto Estrutua de Dados/src/saida.txt");
    }
}
