public class PilhaArray implements Pilha{
    private int capacidade;
    private Object[] array;
    private int topo;
    private int FC; // Fator de Crescimento
    public PilhaArray(int capacidade, int crescimento) {
        this.capacidade = capacidade;
        topo = -1;
        FC = crescimento;
        if (crescimento <=0)
            FC = 0;
        array = new Object[capacidade];
    }

    public int size() {
        return topo + 1;
    }

    public boolean isEmpty(){
        return topo == -1;
    }

    public void emptyArray(){
        topo = -1;
    }

    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()) throw new PilhaVaziaExcecao("Pilha Vazia");
        return array[topo];
    }

    public Object pop() throws PilhaVaziaExcecao{
        if (isEmpty()) throw new PilhaVaziaExcecao("Pilha Vazia");
        Object valor = array[topo];
        topo--;
        return valor;

    }

    public void push(Object elemento){
        if (topo>=capacidade-1){
            if(FC==0)
                capacidade*=2;
            else
                capacidade+=FC;
            Object novoArray[] = new Object[capacidade];
            for (int i = 0; i < array.length; i++){
                novoArray[i] = array[i];
            }
            array = novoArray;
        }
        array[++topo] = elemento;
    }
    
}