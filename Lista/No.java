package Lista;

public class No<T> {
    public T elemento;
    public No<T> anterior;
    public No<T> proximo;

    public No(T elemento, No<T> anterior, No<T> proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }
}
