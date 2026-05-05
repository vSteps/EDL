package Vetor;

// TAD Vetor implementado com Array. Acesso por rank é O(1) mas inserção e remoção são O(n) pois é necessário deslocar elementos.

public class VetorArrayImpl<T> implements VetorTAD<T> {

    private Object[] dados;
    private int capacidade;

    public VetorArrayImpl(int capacidade) {
        this.capacidade = capacidade; 
        this.dados = new Object[capacidade];
    }

    @Override
    public int size() {
        return capacidade;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < capacidade; i++) {
            if (dados[i] != null) return false;
        }
        return true;
    }

    @Override
    public T elemAtRank(int r) {
        validarRank(r);
        return (T) dados[r];
    }

    @Override
    public T replaceAtRank(int r, T e) {
        validarRank(r);
        T antigo = (T) dados[r];
        dados[r] = e;
        return antigo;
    }

    private void validarRank(int r) {
        if (r < 0 || r >= capacidade)
            throw new IndexOutOfBoundsException(
                "Rank invalido: " + r + ". Capacidade: " + capacidade);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VetorArray[");
        for (int i = 0; i < capacidade; i++) {
            sb.append(dados[i] == null ? "null" : dados[i].toString());
            if (i < capacidade - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
