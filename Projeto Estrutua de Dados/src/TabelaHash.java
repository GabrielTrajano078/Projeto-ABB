public class TabelaHash {
    private static final int TAMANHO = 26; // Uma posição para cada letra do alfabeto
    private ArvoreBinariaBusca[] tabela;

    public TabelaHash() {
        tabela = new ArvoreBinariaBusca[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new ArvoreBinariaBusca();
        }
    }



    private int calcularIndice(String palavra) {
        return Character.toLowerCase(palavra.charAt(0)) - 'a'; // Pega a posição da letra no alfabeto
    }

    public void inserir(Palavra palavra) {
        int indice = calcularIndice(palavra.palavra);
        if (indice >= 0 && indice < TAMANHO) {
            tabela[indice].insere(palavra);
        }
    }

    public Palavra buscar(String palavra) {
        int indice = calcularIndice(palavra);
        if (indice >= 0 && indice < TAMANHO) {
            return tabela[indice].busca(palavra);
        }
        return null;
    }

    public void imprimir() {
        for (int i = 0; i < TAMANHO; i++) {
            if (!tabela[i].estaVazia()) {
                tabela[i].imprimeEmOrdem();
            }
        }
    }

    public ArvoreBinariaBusca getArvore(int indice) {
        return tabela[indice];
    }
}
