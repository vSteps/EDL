package Vetor;
public interface VetorTAD<T> {
    int size();
    boolean isEmpty();
    T elemAtRank(int r);
    T replaceAtRank(int r, T e);
}
