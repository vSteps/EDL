public class FilaReversa{
    private int i = 0; // início
    private int f = 0; // fim (próxima posição livre)
    private int N;     // capacidade;
    private Object arr[];
    private int size = 0;
    private boolean reversed = false;

    public FilaReversa(int N) {  //construtorrr
        this.N = N;
        this.arr = new Object[N];
        this.i = 0;
        this.f = 0;
        this.size = 0;
        this.reversed = false;
    }

    // para ser o(1) vamos simular uma reversao da fila sem copiar os elementos, que seria o(n). A fila ficaria assim: [a, b, c] -> [c, b, a], estamos mudando a direcao do acesso
    public void reverse(){
        reversed = !reversed;
    }

    // metodos genericos da fila
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == N;
    }

    public int size() {
        return size;
    }

    public void enqueue(Object elemento) {
        if (isFull()) {
            resize(N * 2);
        }
        if (!reversed){
            arr[f] = elemento;
            f = (f+1) % N; // coloca o elemento no fim da fila(pode ser circular)
        } else {
            i = (i-1+N) % N;
            arr[i] = elemento; // coloca o elemento no início da fila, visto que a direcao da fila esta invertida
        }
        size++;
    }

    public Object dequeue(){
        if(isEmpty()) throw new FilaVaziaExcecao("A Fila está vazia");

        Object valor;

        if (!reversed){
            valor = arr[i];
            i = (i+1) % N; // Move o início para a próxima posição
        } else{ 
            f = (f-1+N) % N;
            valor = arr[f];
        }
        size--;

        //reducao do array pela metade quando somente 1/3 esta sendo usado ex. [-, -, -, -, b, c] N=6 size = 2, o calculo sera 6/3 que da 2, entao nesse caso size <= N/3, entao vai reduzir pela metade
        if (size <= N / 3)
            resize(N / 2);

        return valor;
    }

    private Object get(int k){
        if (!reversed){
            return arr[(i+k) % N]; // Retorna o elemento(k) na posicao normal
        } else{
            return arr[(f-k-1+N) % N]; // Retorna o elemento(k) na posição inversa
        }
    
    }

    public void resize(int novoN){
        Object novoArr[] = new Object[novoN];

        for (int k = 0; k < size; k++){
            novoArr[k] = get(k);
        }
        arr = novoArr;
        N = novoN;
        i = 0;
        f = size;
    }

        public void printFila() {
        System.out.print("Fila: ");
        for (int k = 0; k < size; k++) {
            System.out.print(get(k) + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
    FilaReversa f = new FilaReversa(4);

    f.enqueue("A");
    f.enqueue("B");
    f.enqueue("C");
    f.enqueue("D");

    f.printFila(); // A B C D

    System.out.println("Removido: " + f.dequeue()); // A
    System.out.println("Removido: " + f.dequeue()); // B

    f.printFila(); // C D

    f.enqueue("E");
    f.enqueue("F");

    f.printFila(); // C D E F

    f.reverse();

    System.out.println("Após reverse:");

    f.printFila(); // F E D C

    System.out.println("Removido: " + f.dequeue()); // F

    f.printFila(); // E D C
}
}