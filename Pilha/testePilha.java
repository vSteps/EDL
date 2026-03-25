public class testePilha {

    public static void main(String[] args) {        

        PilhaArray pp = new PilhaArray(1, 1000);

        System.out.println("inserindo");

        long inicio = System.currentTimeMillis();

        for(int f = 0; f < 1000000; f++){ 
            pp.push(Integer.valueOf(f));
        }

        long fim = System.currentTimeMillis(); 

        System.out.println("Tempo de inserção: " + (fim - inicio) + " ms");

        System.out.println("retirando");

        for(int f = 0; f < 10; f++){
            System.out.print(f);
            System.out.println(" - " + pp.pop());
        }
    }
}