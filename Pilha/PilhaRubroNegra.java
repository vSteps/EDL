public class PilhaRubroNegra{
    private int posicaoPreta;
    private int posicaoVermelha;
    private int capacidade;
    private Object[] arrayRN;

    public PilhaRubroNegra(int capacidade) {
        this.capacidade = capacidade;
        this.arrayRN = new Object[capacidade];
        this.posicaoVermelha = -1;
        this.posicaoPreta = capacidade;
    }

    public Object topVermelho() throws PilhaVaziaExcecao {
        if (isEmptyVermelho() ) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia");
        }
        return arrayRN[posicaoVermelha];
    }
    public Object topPreto() throws PilhaVaziaExcecao {
        if (isEmptyPreto() ) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia");
        }
        return arrayRN[posicaoPreta];
    }

    public int sizeVermelho() {
        return posicaoVermelha + 1;
    }

    public int sizePreto() {
        return capacidade - posicaoPreta;
    }

    public boolean isEmptyVermelho() {
        return posicaoVermelha == -1;
    }

    public boolean isEmptyPreto() {
        return posicaoPreta == capacidade;
    }

    public void pushVermelho(Object elemento) {
        verificaCheio();
        arrayRN[++posicaoVermelha] = elemento;
    }

    public void pushPreto(Object elemento) {
        verificaCheio();
        arrayRN[--posicaoPreta] = elemento;
    }

    public Object popVermelho() throws PilhaVaziaExcecao {
        if (isEmptyVermelho()) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia");
        }
        verificaUmTerco();
        Object valor = topVermelho();
        posicaoVermelha--;
        return valor;
    }
    public Object popPreto() throws PilhaVaziaExcecao {
        if (isEmptyPreto()) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia");
        }
        verificaUmTerco();
        Object valor = topPreto();
        posicaoPreta++;
        return valor;
    }

    public void verificaCheio(){
        if (sizeVermelho() + sizePreto() == capacidade){
            dobraCapacidade();
        }
    }

    public void verificaUmTerco(){
        if (sizeVermelho() + sizePreto() <= capacidade / 3){
            reduzCapacidade();
        }
    }

    public void dobraCapacidade(){
        Object[] novoArray = new Object[capacidade * 2];

        // Copia a pilha vermelha pro novo array
        for (int i = 0; i <= posicaoVermelha; i++) {
            novoArray[i] = arrayRN[i];
        }

        int novaPosicaoPreta = sizePreto();

        // Copia a pilha preta pro novo array
        for (int i = capacidade - 1; i >= posicaoPreta; i--){
            novoArray[i + capacidade] = arrayRN[i];
        }
        
        capacidade *= 2;
        // ajustando o indice da posicaoPreta no novo array
        posicaoPreta = capacidade - novaPosicaoPreta;
        arrayRN = novoArray;
    }

    public void reduzCapacidade(){
        Object[] novoArray = new Object[capacidade / 2];

        // Copia a pilha vermelha pro novo array
        for (int i = 0; i <= posicaoVermelha; i++) {
            novoArray[i] = arrayRN[i];
        }
        
        // salva a nova posição da pilha preta
        int novaPosicaoPreta = capacidade/2 - sizePreto();

        // Copia a pilha preta pro novo array
        for (int i = capacidade - 1; i >= posicaoPreta; i--){
            novoArray[i - capacidade / 2] = arrayRN[i];
        }
        arrayRN = novoArray;
        capacidade /= 2;
        // ajustando o indice da posicaoPreta no novo array
        posicaoPreta = novaPosicaoPreta;
    }

    public void printEstado() {
    System.out.print("\nArray: [ ");
    for (int i = 0; i < capacidade; i++) {
        System.out.print(arrayRN[i] + " ");
    }
    System.out.println("]");

    System.out.println("Capacidade: " + capacidade);
    System.out.println("Topo Vermelho (pos): " + posicaoVermelha);
    System.out.println("Topo Preto (pos): " + posicaoPreta);
    System.out.println("Size Vermelho: " + sizeVermelho());
    System.out.println("Size Preto: " + sizePreto());
}
}