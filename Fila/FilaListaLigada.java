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

    public static void main(String[] args) {
        FilaListaLigada fila = new FilaListaLigada();
        fila.dequeue(); // Deve lançar uma exceção de fila vazia
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        System.out.println(fila.dequeue()); // Imprime 1
        System.out.println(fila.dequeue()); // Imprime 2
        System.out.println(fila.size());    // Imprime 1
        System.out.println(fila.isEmpty()); // Imprime false
        System.out.println(fila.dequeue()); // Imprime 3
        System.out.println(fila.isEmpty()); // Imprime true

    }
}