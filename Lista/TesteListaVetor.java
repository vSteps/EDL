package Lista;

public class TesteListaVetor {

    private static int totalTestes = 0;
    private static int testesPassaram = 0;

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("   TESTES — Lista com Array (ListaVetorImpl)");
        System.out.println("=================================================\n");

        testarListaVazia();
        testarInsercaoNoFim();
        testarInsercaoNoInicio();
        testarInsercaoNoMeio();
        testarElemAtRank();
        testarReplaceAtRank();
        testarRemocaoNoInicio();
        testarRemocaoNoFim();
        testarRemocaoNoMeio();
        testarExpansaoAutomatica();
        testarExcecaoRankInvalido();

        System.out.println("=================================================");
        System.out.printf("  Resultado: %d/%d testes passaram%n", testesPassaram, totalTestes);
        System.out.println("=================================================");
    }

    // -------------------------------------------------------
    // Testes
    // -------------------------------------------------------

    private static void testarListaVazia() {
        System.out.println("[ TESTE ] Lista recém-criada");
        ListaVetorImpl<Integer> lista = new ListaVetorImpl<>();

        verificar("size() == 0", lista.size() == 0);
        verificar("isEmpty() == true", lista.isEmpty());
        System.out.println();
    }

    private static void testarInsercaoNoFim() {
        System.out.println("[ TESTE ] Inserção no fim");
        ListaVetorImpl<String> lista = new ListaVetorImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "B");
        lista.insertAtRank(2, "C");

        verificar("size() == 3", lista.size() == 3);
        verificar("elemAtRank(0) == A", lista.elemAtRank(0).equals("A"));
        verificar("elemAtRank(1) == B", lista.elemAtRank(1).equals("B"));
        verificar("elemAtRank(2) == C", lista.elemAtRank(2).equals("C"));
        System.out.println();
    }

    private static void testarInsercaoNoInicio() {
        System.out.println("[ TESTE ] Inserção no início");
        ListaVetorImpl<String> lista = new ListaVetorImpl<>();

        lista.insertAtRank(0, "C");
        lista.insertAtRank(0, "B");
        lista.insertAtRank(0, "A");

        verificar("elemAtRank(0) == A", lista.elemAtRank(0).equals("A"));
        verificar("elemAtRank(1) == B", lista.elemAtRank(1).equals("B"));
        verificar("elemAtRank(2) == C", lista.elemAtRank(2).equals("C"));
        System.out.println();
    }

    private static void testarInsercaoNoMeio() {
        System.out.println("[ TESTE ] Inserção no meio");
        ListaVetorImpl<String> lista = new ListaVetorImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "C");
        lista.insertAtRank(1, "B"); // insere B entre A e C

        verificar("elemAtRank(0) == A", lista.elemAtRank(0).equals("A"));
        verificar("elemAtRank(1) == B", lista.elemAtRank(1).equals("B"));
        verificar("elemAtRank(2) == C", lista.elemAtRank(2).equals("C"));
        verificar("size() == 3", lista.size() == 3);
        System.out.println();
    }

    private static void testarElemAtRank() {
        System.out.println("[ TESTE ] elemAtRank");
        ListaVetorImpl<Integer> lista = new ListaVetorImpl<>();

        lista.insertAtRank(0, 10);
        lista.insertAtRank(1, 20);
        lista.insertAtRank(2, 30);

        verificar("elemAtRank(0) == 10", lista.elemAtRank(0) == 10);
        verificar("elemAtRank(1) == 20", lista.elemAtRank(1) == 20);
        verificar("elemAtRank(2) == 30", lista.elemAtRank(2) == 30);
        System.out.println();
    }

    private static void testarReplaceAtRank() {
        System.out.println("[ TESTE ] replaceAtRank");
        ListaVetorImpl<Integer> lista = new ListaVetorImpl<>();

        lista.insertAtRank(0, 10);
        lista.insertAtRank(1, 20);
        lista.insertAtRank(2, 30);

        Integer antigo = lista.replaceAtRank(1, 99);

        verificar("valor antigo == 20", antigo == 20);
        verificar("novo valor em rank 1 == 99", lista.elemAtRank(1) == 99);
        verificar("rank 0 não mudou == 10", lista.elemAtRank(0) == 10);
        verificar("rank 2 não mudou == 30", lista.elemAtRank(2) == 30);
        System.out.println();
    }

    private static void testarRemocaoNoInicio() {
        System.out.println("[ TESTE ] Remoção no início");
        ListaVetorImpl<String> lista = new ListaVetorImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "B");
        lista.insertAtRank(2, "C");

        String removido = lista.removeAtRank(0);

        verificar("removido == A", removido.equals("A"));
        verificar("novo rank 0 == B", lista.elemAtRank(0).equals("B"));
        verificar("novo rank 1 == C", lista.elemAtRank(1).equals("C"));
        verificar("size() == 2", lista.size() == 2);
        System.out.println();
    }

    private static void testarRemocaoNoFim() {
        System.out.println("[ TESTE ] Remoção no fim");
        ListaVetorImpl<String> lista = new ListaVetorImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "B");
        lista.insertAtRank(2, "C");

        String removido = lista.removeAtRank(2);

        verificar("removido == C", removido.equals("C"));
        verificar("size() == 2", lista.size() == 2);
        verificar("rank 0 == A", lista.elemAtRank(0).equals("A"));
        verificar("rank 1 == B", lista.elemAtRank(1).equals("B"));
        System.out.println();
    }

    private static void testarRemocaoNoMeio() {
        System.out.println("[ TESTE ] Remoção no meio");
        ListaVetorImpl<String> lista = new ListaVetorImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "B");
        lista.insertAtRank(2, "C");

        String removido = lista.removeAtRank(1);

        verificar("removido == B", removido.equals("B"));
        verificar("rank 0 == A", lista.elemAtRank(0).equals("A"));
        verificar("rank 1 == C", lista.elemAtRank(1).equals("C"));
        verificar("size() == 1", lista.size() == 1);
        System.out.println();
    }

    private static void testarExpansaoAutomatica() {
        System.out.println("[ TESTE ] Expansão automática do array (mais de 10 elementos)");
        ListaVetorImpl<Integer> lista = new ListaVetorImpl<>();

        // Array começa com tamanho 10, então inserir 15 força a expansão
        for (int i = 0; i < 15; i++) {
            lista.insertAtRank(i, i * 10);
        }

        verificar("size() == 15", lista.size() == 15);
        verificar("elemAtRank(0) == 0",   lista.elemAtRank(0) == 0);
        verificar("elemAtRank(10) == 100", lista.elemAtRank(10) == 100);
        verificar("elemAtRank(14) == 140", lista.elemAtRank(14) == 140);
        System.out.println();
    }

    private static void testarExcecaoRankInvalido() {
        System.out.println("[ TESTE ] Exceções para ranks inválidos");
        ListaVetorImpl<Integer> lista = new ListaVetorImpl<>();
        lista.insertAtRank(0, 42);

        // elemAtRank negativo
        try {
            lista.elemAtRank(-1);
            verificar("elemAtRank(-1) lança exceção", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("elemAtRank(-1) lança exceção", true);
        }

        // elemAtRank fora do limite
        try {
            lista.elemAtRank(5);
            verificar("elemAtRank(5) lança exceção (size=1)", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("elemAtRank(5) lança exceção (size=1)", true);
        }

        // insertAtRank negativo
        try {
            lista.insertAtRank(-1, 99);
            verificar("insertAtRank(-1) lança exceção", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("insertAtRank(-1) lança exceção", true);
        }

        // removeAtRank em lista vazia
        ListaVetorImpl<Integer> vazia = new ListaVetorImpl<>();
        try {
            vazia.removeAtRank(0);
            verificar("removeAtRank(0) em lista vazia lança exceção", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("removeAtRank(0) em lista vazia lança exceção", true);
        }

        // replaceAtRank fora do limite
        try {
            lista.replaceAtRank(10, 99);
            verificar("replaceAtRank(10) lança exceção (size=1)", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("replaceAtRank(10) lança exceção (size=1)", true);
        }

        System.out.println();
    }

    // -------------------------------------------------------
    // Helper
    // -------------------------------------------------------

    private static void verificar(String descricao, boolean condicao) {
        totalTestes++;
        if (condicao) {
            testesPassaram++;
            System.out.printf("  ✔ %s%n", descricao);
        } else {
            System.out.printf("  ✘ FALHOU: %s%n", descricao);
        }
    }
}