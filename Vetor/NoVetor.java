package Vetor;

public class NoVetor<T> {
    public T elemento;
    public NoVetor<T> anterior;
    public NoVetor<T> proximo;

    public NoVetor(T elemento, NoVetor<T> anterior, NoVetor<T> proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo  = proximo;
    }
}
