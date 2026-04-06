public class FilaArray{
    private int i = 0;
    private int f = 0 ;
    private int N;
    private int incremento;
    private Object O[];
    public FilaArray(int N, int incremento){
        O = new Object[N];
        this.N=N; //Tamanho
        this.incremento=incremento;
    }

    public void enqueue(Object o){
        if (size()==N-1) { //encheu a fila coleguinha
            int novoTam;
            if (incremento==0) novoTam=N*2; //dobra o tamanho
            else novoTam=N+incremento; //aumenta o tamanho em incremento
            Object[] b = new Object[novoTam]; // novo array
            int ii = i; // variável auxiliar para percorrer o array antigo
            for (int ff = 0; ff < size(); ff++){ // for para percorrer o array antigo e copiar pro novo
                b[ff] = O[ii]; // copia
                ii = (ii + 1)%N; // cálculo doido pra fazer o ii andar e voltar pro começo do array quando chegar no final
            }
            f = size(); // final do array é o tamanho da fila
            i = 0; // inicio do array é 0
            N = novoTam; // atualiza o tamanho da fila
            O = b; // atualiza para o novo array
        }
        O[f] = o; // insere o elemento no final da fila
        f = (f + 1) % N; // cálculo doido pra fazer o f andar e voltar pro começo do array quando chegar no final
    }

    public int size(){
        return (N-i+f)%N;
    }

    public boolean isEmpty(){
        return f==i;
    }

    public Object first(){
        if(isEmpty()) throw new FilaVaziaExcecao("A Pilha está vazia");
        return O[i];
    }

    public Object dequeue(){
        if(isEmpty()) throw new FilaVaziaExcecao("A Pilha está vazia");
            Object temp=O[i]; // armazena o valor a ser retornado em uma variável temporária
            i=(i+1) % N; // cálculo doido pra fazer o i andar e voltar pro começo do array quando chegar no final
            return temp;
    }

    public void mostrar(){
        int ii = this.i;
        for(int i = 0; i < size(); i++, ii=(ii+1)%N){
            System.out.print(O[ii]);
            System.out.print(", ");
        }
    }

    public static void main(String[] args){ // teste
        FilaArray fila = new FilaArray(5,0);
        fila.enqueue(5);
        fila.enqueue(6);
        fila.dequeue();
        fila.enqueue(8);
        fila.enqueue(2);


        fila.mostrar();
        System.out.println();
        System.out.println(fila.first());

        fila.dequeue();
        fila.dequeue();
        fila.enqueue(1);
        fila.enqueue(10);
        fila.enqueue(16);
        fila.enqueue(19);
        fila.enqueue(20);
        fila.enqueue(22);
        fila.dequeue();
        fila.dequeue();
        fila.mostrar();

        System.out.println();
        System.out.println(fila.first());

        fila.enqueue(37);
        fila.enqueue(45);
        fila.dequeue();
        fila.dequeue();
        fila.mostrar();

        System.out.println();
        System.out.println(fila.first());

        fila.dequeue();
        fila.dequeue();
        fila.mostrar();

        System.out.println();
        System.out.println(fila.first());

        fila.dequeue();
        fila.dequeue();
        fila.dequeue();
        fila.mostrar();
        //fila.dequeue();
        System.out.println();
    }
}