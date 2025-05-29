public class ListaEncadeada<T> {

    public No getPrimeiro() {
        return primeiro;
    }

    public class No {
        public T dado;
        public No proximo;

        public No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    private No primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }



    public void inserir(T dado) {
        No novo = new No(dado);
        novo.proximo = primeiro;
        primeiro = novo;
    }

    public boolean contem(T dado) {
        No atual = primeiro;
        while (atual != null) {
            if (atual.dado.equals(dado)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void imprimir() {
        No atual = primeiro;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
