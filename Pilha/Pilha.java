public interface Pilha {
    public int size();
    public boolean isEmpty();
    public Object top() throws PilhaVaziaExcecao;
    public void push(Object elemento);
    public Object pop() throws PilhaVaziaExcecao;
}
