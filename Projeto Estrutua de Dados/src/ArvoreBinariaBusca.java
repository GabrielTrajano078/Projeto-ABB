public class ArvoreBinariaBusca {

    class Nodo {
        public Palavra elemento;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(Palavra elemento) {
            this.elemento = elemento;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    private Nodo raiz;
    private int nElementos;

    public ArvoreBinariaBusca() {
        this.raiz = null;
        this.nElementos = 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public void insere(Palavra nova) {
        this.raiz = insere(nova, this.raiz);
    }

    private Nodo insere(Palavra nova, Nodo nodo) {
        if (nodo == null) {
            nElementos++;
            return new Nodo(nova);
        }

        int comparacao = nova.palavra.compareTo(nodo.elemento.palavra);

        if (comparacao < 0) {
            nodo.esquerdo = insere(nova, nodo.esquerdo);
        } else if (comparacao > 0) {
            nodo.direito = insere(nova, nodo.direito);
        } else {
            // Palavra já existe: lógica de atualização deve estar fora
        }

        return nodo;
    }

    public Palavra busca(String chave) {
        return busca(chave, this.raiz);
    }

    private Palavra busca(String chave, Nodo nodo) {
        if (nodo == null) return null;

        int comparacao = chave.compareTo(nodo.elemento.palavra);

        if (comparacao < 0) {
            return busca(chave, nodo.esquerdo);
        } else if (comparacao > 0) {
            return busca(chave, nodo.direito);
        } else {
            return nodo.elemento;
        }
    }

    public void imprimeEmOrdem() {
        emOrdem(this.raiz);
    }

    private void emOrdem(Nodo nodo) {
        if (nodo == null) return;

        emOrdem(nodo.esquerdo);
        System.out.print(nodo.elemento.palavra + ": ");
        nodo.elemento.imprimirOcorrencias();
        emOrdem(nodo.direito);
    }

    public int altura() {
        return altura(this.raiz);
    }

    private int altura(Nodo nodo) {
        if (nodo == null) return -1;

        int esquerda = altura(nodo.esquerdo);
        int direita = altura(nodo.direito);

        return Math.max(esquerda, direita) + 1;
    }

    public Nodo getRaiz() {
        return this.raiz;
    }
}
