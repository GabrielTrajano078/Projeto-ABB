public class Main {
    public static void main(String[] args) {
        String[] palavrasChave = {
                "and", "be", "by", "easy", "human-engineered", "programming", "programs", "to"
        };

        LeitorArquivo leitor = new LeitorArquivo(palavrasChave);
        leitor.lerArquivo("/Users/gabriel/projetos/Projeto Estrutua de Dados/src/estrutura.txt");
        leitor.imprimirEmOrdem();
        leitor.exportar("/Users/gabriel/projetos/Projeto Estrutua de Dados/src/saida.txt");
    }
}
