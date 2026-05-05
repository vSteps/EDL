package Lista;

public interface ListaDE<T> {
    int size();
    boolean isEmpty();
    T elemAtRank(int r);
    T replaceAtRank(int r, T e);
    void insertAtRank(int r, T e);
    T removeAtRank(int r);
}
