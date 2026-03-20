public class PilhaRubroNegra{
    private int posicaoPreta;
    private int posicaoVermelha;
    private int capacidade;
    private Object[] arrayRN;
    private int FC;

    public PilhaRubroNegra(int capacidade, int crescimento) {
        this.capacidade = capacidade;
        this.FC = crescimento;
        if (crescimento <= 0) {
            FC = 0;
        }
        this.arrayRN = new Object[capacidade];
        this.posicaoVermelha = -1;
        this.posicaoPreta = capacidade;
    }

    public Object topVermelho() throws PilhaVaziaExcecao {
        if (posicaoVermelha == -1) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia");
        }
        return arrayRN[posicaoVermelha];
    }

    public int sizeVermelho() {
        return posicaoVermelha + 1;
    }

    public boolean isEmptyVermelho() {
        return posicaoVermelha == -1;
    }

    public Object topPreto() throws PilhaVaziaExcecao {
        if (posicaoPreta == capacidade) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia");
        }
        return arrayRN[posicaoPreta];
    }

    public int sizePreto() {
        return capacidade - posicaoPreta - 1;
    }

    public boolean isEmptyPreto() {
        return posicaoPreta == capacidade;
    }

    public int sizeArray() {
        return sizeVermelho() + sizePreto();
    }

}