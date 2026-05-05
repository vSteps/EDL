package Lista;

public class ListaVetorImpl<T> implements ListaVetor<T> {

    private Object[] V;
    private int n;

    public ListaVetorImpl() {
        V = new Object[10];
        n = 0;
    }

    private void expandir() {
        if (n == V.length) {

            Object[] novo = new Object[V.length * 2];

            for (int i = 0; i < n; i++) {
                novo[i] = V[i];
            }

            V = novo;
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T elemAtRank(int r) {
        if (r < 0 || r >= n) throw new IndexOutOfBoundsException();
        return (T) V[r];
    }

    public T replaceAtRank(int r, T e) {
        if (r < 0 || r >= n) throw new IndexOutOfBoundsException();

        T antigo = (T) V[r];
        V[r] = e;
        return antigo;
    }

    public void insertAtRank(int r, T e) {
        if (r < 0 || r > n) throw new IndexOutOfBoundsException();

        expandir();

        for (int i = n; i > r; i--) {
            V[i] = V[i - 1];
        }

        V[r] = e;
        n++;
    }

    public T removeAtRank(int r) {
        if (r < 0 || r >= n) throw new IndexOutOfBoundsException();

        T removido = (T) V[r];

        for (int i = r; i < n - 1; i++) {
            V[i] = V[i + 1];
        }

        n--;

        return removido;
    }
}