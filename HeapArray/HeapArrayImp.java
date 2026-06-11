package HeapArray;

import java.util.NoSuchElementException;

public class HeapArrayImp<K extends Comparable<K>>
        implements HeapArray<K> {

    private Object[] heap;
    private int size;

    public HeapArrayImp(int n) {
        this.heap = new Object[n + 1]; // posição 0 não é usada
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public K min() {
        if (isEmpty())
            throw new NoSuchElementException("Fila de prioridade está vazia.");
        return (K) heap[1];
    }

    @Override
    public void insert(K key) {
        if (key == null)
            throw new IllegalArgumentException("Elemento nulo não é permitido.");
        if (size >= heap.length - 1)
            throw new IllegalStateException("Heap cheio.");

        heap[++size] = key;  // insere na posição n+1
        upHeap(size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public K removeMin() {
        if (isEmpty())
            throw new NoSuchElementException("Fila de prioridade está vazia.");

        K minKey   = (K) heap[1];  // salva o mínimo (raiz)
        heap[1]    = heap[size];   // move posição n para a raiz
        heap[size] = null;         // remove da posição n
        size--;

        if (!isEmpty())
            downHeap(1);

        return minKey;
    }

    @SuppressWarnings("unchecked")
    private void upHeap(int i) {
        while (i > 1) {
            int parent = i / 2;
            K child  = (K) heap[i];
            K father = (K) heap[parent];

            if (child.compareTo(father) >= 0)
                break;

            swap(i, parent);
            i = parent;
        }
    }

    @SuppressWarnings("unchecked")
    private void downHeap(int i) {
        while (2 * i <= size) {
            int left     = 2 * i;
            int right    = 2 * i + 1;
            int smallest = left;

            if (right <= size) {
                K leftChild  = (K) heap[left];
                K rightChild = (K) heap[right];
                if (rightChild.compareTo(leftChild) < 0)
                    smallest = right;
            }

            K current       = (K) heap[i];
            K smallestChild = (K) heap[smallest];

            if (current.compareTo(smallestChild) <= 0)
                break;

            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int a, int b) {
        Object tmp = heap[a];
        heap[a]    = heap[b];
        heap[b]    = tmp;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 1; i <= size; i++) {
            sb.append(heap[i]);
            if (i < size) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}