package Vetor;

// TAD Vetor implementado com Lista Duplamente Encadeada. Acesso por rank é O(n) é necessário navegar até a posição.
 
public class VetorDEImpl<T> implements VetorTAD<T> {

    private NoVetor<T> cabeca;
    private NoVetor<T> cauda; 
    private int capacidade;

    public VetorDEImpl(int capacidade) {


        this.capacidade = capacidade;

        // Cria nós
        cabeca = new NoVetor<>(null, null, null);
        cauda  = new NoVetor<>(null, cabeca, null);
        cabeca.proximo = cauda;

        // Preenche a lista com 'capacidade' nós de valor null
        NoVetor<T> atual = cabeca;
        for (int i = 0; i < capacidade; i++) {
            NoVetor<T> novo = new NoVetor<>(null, atual, cauda);
            atual.proximo = novo;
            cauda.anterior = novo;
            atual = novo;
        }
    }


    private NoVetor<T> navegarAte(int r) {
        NoVetor<T> atual;
        if (r < capacidade / 2) {
            // Começa do início
            atual = cabeca.proximo;
            for (int i = 0; i < r; i++) atual = atual.proximo;
        } else {
            // Começa do fim
            atual = cauda.anterior;
            for (int i = capacidade - 1; i > r; i--) atual = atual.anterior;
        }
        return atual;
    }
    
    @Override
    public int size() {
        return capacidade;
    }

    @Override
    public boolean isEmpty() {
        NoVetor<T> atual = cabeca.proximo;
        while (atual != cauda) {
            if (atual.elemento != null) return false;
            atual = atual.proximo;
        }
        return true;
    }

    @Override
    public T elemAtRank(int r) {
        validarRank(r);
        return navegarAte(r).elemento;
    }

    @Override
    public T replaceAtRank(int r, T e) {
        validarRank(r);
        NoVetor<T> no = navegarAte(r);
        T antigo = no.elemento;
        no.elemento = e;
        return antigo;
    }

    private void validarRank(int r) {
        if (r < 0 || r >= capacidade)
            throw new IndexOutOfBoundsException(
                "Rank invalido: " + r + ". Capacidade: " + capacidade);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VetorDE[");
        NoVetor<T> atual = cabeca.proximo;
        int i = 0;
        while (atual != cauda) {
            sb.append(atual.elemento == null ? "null" : atual.elemento.toString());
            if (i < capacidade - 1) sb.append(", ");
            atual = atual.proximo;
            i++;
        }
        return sb.append("]").toString();
    }
}
