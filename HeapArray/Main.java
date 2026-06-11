package HeapArray;
import HeapArray.HeapArray;
import HeapArray.HeapArrayImp;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        HeapArray<Integer> pq = new HeapArrayImp<>(10);

        System.out.println("isEmpty() → " + pq.isEmpty());
        System.out.println("size()    → " + pq.size());

        int[] valores = {15, 3, 22, 7, 1, 11, 9, 4, 18, 6};
        for (int v : valores) {
            pq.insert(v);
            System.out.printf("insert(%2d)  →  heap: %s%n", v, pq);
        }

        System.out.println("min()     → " + pq.min());
        System.out.println("size()    → " + pq.size());
        System.out.println("isEmpty() → " + pq.isEmpty());

        while (!pq.isEmpty())
            System.out.printf("removeMin() → %2d  |  heap: %s%n",
                    pq.removeMin(), pq);

        try { pq.min(); }
        catch (NoSuchElementException e) { System.out.println(e.getMessage()); }

        try { pq.removeMin(); }
        catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
    }
}