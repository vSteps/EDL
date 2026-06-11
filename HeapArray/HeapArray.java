package HeapArray;
public interface HeapArray<K extends Comparable<K>> {

    // Retorna o número de elementos na fila de prioridade.
    int size();

    // Verifica se a fila de prioridade está vazia.
    boolean isEmpty();

    // Retorna (sem remover) o menor elemento da fila de prioridade.
    K min();

    //Insere um novo elemento na fila de prioridade.

    void insert(K key);

    //Remove e retorna o menor elemento da fila de prioridade.
    K removeMin();
}
