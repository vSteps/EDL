public class FilaListaLigada {
    private No inicio;
    private No fim;
    private int tamanho;

    public FilaListaLigada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public class No {
        Object elemento;
        No proximo;

        public No(Object elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }

        public Object getElemento() {
            return elemento;
        }

        public void setElemento(Object elemento) {
            this.elemento = elemento;
        }

        public No getProximo() {
            return proximo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    }

    public void enqueue(Object o) {
        No novoNo = new No(o);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        tamanho++;
    }

    public Object dequeue() {
        if (isEmpty()) throw new FilaVaziaExcecao("A Fila está vazia");
        Object temp = inicio.elemento; // armazena o valor a ser retornado em uma variável temporária
        inicio = inicio.proximo; // move o início para o próximo nó
        tamanho--; // decrementa o tamanho da fila
        if (isEmpty()) { // se a fila ficou vazia, ajusta o fim também
            fim = null;
        }
        return temp; // retorna o valor armazenado na variável temporária
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}