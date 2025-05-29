import java.io.*;

public class LeitorArquivo {
    private ArvoreBinariaBusca arvore;
    private String[] palavrasChave;

    public LeitorArquivo(String[] palavrasChave) {
        this.arvore = new ArvoreBinariaBusca();
        this.palavrasChave = palavrasChave;
    }

    public void lerArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int numeroLinha = 1;

            while ((linha = br.readLine()) != null) {
                String[] palavras = linha.toLowerCase().replaceAll("[^a-z\\- ]", "").split("\\s+");

                for (String palavra : palavras) {
                    for (String chave : palavrasChave) {
                        if (palavra.equals(chave)) {
                            Palavra existente = arvore.busca(chave);
                            if (existente == null) {
                                Palavra nova = new Palavra(chave);
                                nova.adicionarOcorrencia(numeroLinha);
                                arvore.insere(nova);
                            } else {
                                existente.adicionarOcorrencia(numeroLinha);
                            }
                        }
                    }
                }
                numeroLinha++;
            }

            System.out.println("Arquivo lido com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void imprimirEmOrdem() {
        arvore.imprimeEmOrdem();
    }

    public void exportar(String caminhoSaida) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoSaida))) {
            exportaEmOrdem(arvore.getRaiz(), writer);
            System.out.println("Exportado para " + caminhoSaida);
        } catch (IOException e) {
            System.err.println("Erro ao exportar: " + e.getMessage());
        }
    }

    private void exportaEmOrdem(ArvoreBinariaBusca.Nodo nodo, BufferedWriter writer) throws IOException {
        if (nodo == null) return;

        exportaEmOrdem(nodo.esquerdo, writer);
        writer.write(nodo.elemento.palavra + ": ");
        nodo.elemento.exportarOcorrencias(writer);
        writer.newLine();
        exportaEmOrdem(nodo.direito, writer);
    }
}
