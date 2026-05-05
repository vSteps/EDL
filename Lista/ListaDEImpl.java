package Lista;

public class ListaDEImpl<T> implements ListaDE<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int n;

    public ListaDEImpl() {
        cabeca = new No<>(null, null, null);
        cauda = new No<>(null, cabeca, null);
        cabeca.proximo = cauda;
        n = 0;
    }

    private No<T> navegarAte(int r) {
        No<T> atual;
        if (r < n / 2) {
            atual = cabeca.proximo;
            for (int i = 0; i < r; i++) {
                atual = atual.proximo;
            }
        } else {
            atual = cauda.anterior;
            for (int i = n - 1; i > r; i--) {
                atual = atual.anterior;
            }
        }
        return atual;
    }

    private void inserirEntre(T e, No<T> ant, No<T> prox) {
        No<T> novo = new No<>(e, ant, prox);
        ant.proximo = novo;
        prox.anterior = novo;
        n++;
    }

    private T removerNo(No<T> no) {
        no.anterior.proximo = no.proximo;
        no.proximo.anterior = no.anterior;
        n--;
        return no.elemento;
    }


    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public T elemAtRank(int r) {
        if (r < 0 || r >= n) throw new IndexOutOfBoundsException("Rank inválido: " + r);
        return navegarAte(r).elemento;
    }

    @Override
    public T replaceAtRank(int r, T e) {
        if (r < 0 || r >= n) throw new IndexOutOfBoundsException("Rank inválido: " + r);
        No<T> no = navegarAte(r);
        T antigo = no.elemento;
        no.elemento = e;
        return antigo;
    }

    @Override
    public void insertAtRank(int r, T e) {
        if (r < 0 || r > n) throw new IndexOutOfBoundsException("Rank inválido: " + r);

        if (r == n) {
            inserirEntre(e, cauda.anterior, cauda);
        } else {
            No<T> noAtual = navegarAte(r);
            inserirEntre(e, noAtual.anterior, noAtual);
        }
    }

    @Override
    public T removeAtRank(int r) {
        if (r < 0 || r >= n) throw new IndexOutOfBoundsException("Rank inválido: " + r);
        return removerNo(navegarAte(r));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        No<T> atual = cabeca.proximo;
        while (atual != cauda) {
            sb.append(atual.elemento);
            if (atual.proximo != cauda) sb.append(", ");
            atual = atual.proximo;
        }
        sb.append("]");
        return sb.toString();
    }
}
