package Lista;

public class TesteListaDE {

    // Contador de testes
    private static int totalTestes = 0;
    private static int testesPassaram = 0;

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("   TESTES — Lista Duplamente Encadeada (ListaDE)");
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
        testarOrdemDosElementos();
        testarExcecaoRankInvalido();

        System.out.println("\n=================================================");
        System.out.printf("  Resultado: %d/%d testes passaram%n", testesPassaram, totalTestes);
        System.out.println("=================================================");
    }

    // -------------------------------------------------------
    // Métodos de teste
    // -------------------------------------------------------

    private static void testarListaVazia() {
        System.out.println("[ TESTE ] Lista recém-criada");
        ListaDEImpl<Integer> lista = new ListaDEImpl<>();

        verificar("size() == 0", lista.size() == 0);
        verificar("isEmpty() == true", lista.isEmpty());
        verificar("toString() == []", lista.toString().equals("[]"));
        System.out.println();
    }

    private static void testarInsercaoNoFim() {
        System.out.println("[ TESTE ] Inserção no fim");
        ListaDEImpl<String> lista = new ListaDEImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "B");
        lista.insertAtRank(2, "C");

        verificar("size() == 3", lista.size() == 3);
        verificar("lista == [A, B, C]", lista.toString().equals("[A, B, C]"));
        System.out.println();
    }

    private static void testarInsercaoNoInicio() {
        System.out.println("[ TESTE ] Inserção no início");
        ListaDEImpl<String> lista = new ListaDEImpl<>();

        lista.insertAtRank(0, "C");
        lista.insertAtRank(0, "B");
        lista.insertAtRank(0, "A");

        verificar("lista == [A, B, C]", lista.toString().equals("[A, B, C]"));
        System.out.println();
    }

    private static void testarInsercaoNoMeio() {
        System.out.println("[ TESTE ] Inserção no meio");
        ListaDEImpl<String> lista = new ListaDEImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "C");
        lista.insertAtRank(1, "B"); // insere B entre A e C

        verificar("lista == [A, B, C]", lista.toString().equals("[A, B, C]"));
        System.out.println();
    }

    private static void testarElemAtRank() {
        System.out.println("[ TESTE ] elemAtRank");
        ListaDEImpl<Integer> lista = new ListaDEImpl<>();

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
        ListaDEImpl<Integer> lista = new ListaDEImpl<>();

        lista.insertAtRank(0, 10);
        lista.insertAtRank(1, 20);
        lista.insertAtRank(2, 30);

        Integer antigo = lista.replaceAtRank(1, 99);

        verificar("valor antigo == 20", antigo == 20);
        verificar("novo valor em rank 1 == 99", lista.elemAtRank(1) == 99);
        verificar("lista == [10, 99, 30]", lista.toString().equals("[10, 99, 30]"));
        System.out.println();
    }

    private static void testarRemocaoNoInicio() {
        System.out.println("[ TESTE ] Remoção no início");
        ListaDEImpl<String> lista = new ListaDEImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "B");
        lista.insertAtRank(2, "C");

        String removido = lista.removeAtRank(0);

        verificar("removido == A", removido.equals("A"));
        verificar("lista == [B, C]", lista.toString().equals("[B, C]"));
        verificar("size() == 2", lista.size() == 2);
        System.out.println();
    }

    private static void testarRemocaoNoFim() {
        System.out.println("[ TESTE ] Remoção no fim");
        ListaDEImpl<String> lista = new ListaDEImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "B");
        lista.insertAtRank(2, "C");

        String removido = lista.removeAtRank(2);

        verificar("removido == C", removido.equals("C"));
        verificar("lista == [A, B]", lista.toString().equals("[A, B]"));
        System.out.println();
    }

    private static void testarRemocaoNoMeio() {
        System.out.println("[ TESTE ] Remoção no meio");
        ListaDEImpl<String> lista = new ListaDEImpl<>();

        lista.insertAtRank(0, "A");
        lista.insertAtRank(1, "B");
        lista.insertAtRank(2, "C");

        String removido = lista.removeAtRank(1);

        verificar("removido == B", removido.equals("B"));
        verificar("lista == [A, C]", lista.toString().equals("[A, C]"));
        System.out.println();
    }

    private static void testarOrdemDosElementos() {
        System.out.println("[ TESTE ] Ordem e navegação (muitos elementos)");
        ListaDEImpl<Integer> lista = new ListaDEImpl<>();

        for (int i = 0; i < 10; i++) {
            lista.insertAtRank(i, i * 10);
        }

        verificar("size() == 10", lista.size() == 10);
        verificar("elemAtRank(0) == 0",  lista.elemAtRank(0) == 0);
        verificar("elemAtRank(9) == 90", lista.elemAtRank(9) == 90);
        verificar("elemAtRank(5) == 50", lista.elemAtRank(5) == 50);
        System.out.println();
    }

    private static void testarExcecaoRankInvalido() {
        System.out.println("[ TESTE ] Exceções para ranks inválidos");
        ListaDEImpl<Integer> lista = new ListaDEImpl<>();
        lista.insertAtRank(0, 42);

        // elemAtRank com rank negativo
        try {
            lista.elemAtRank(-1);
            verificar("elemAtRank(-1) lança exceção", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("elemAtRank(-1) lança exceção", true);
        }

        // elemAtRank com rank fora do limite
        try {
            lista.elemAtRank(5);
            verificar("elemAtRank(5) lança exceção (size=1)", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("elemAtRank(5) lança exceção (size=1)", true);
        }

        // insertAtRank com rank inválido
        try {
            lista.insertAtRank(-1, 99);
            verificar("insertAtRank(-1) lança exceção", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("insertAtRank(-1) lança exceção", true);
        }

        // removeAtRank em lista vazia
        ListaDEImpl<Integer> vazia = new ListaDEImpl<>();
        try {
            vazia.removeAtRank(0);
            verificar("removeAtRank(0) em lista vazia lança exceção", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("removeAtRank(0) em lista vazia lança exceção", true);
        }

        System.out.println();
    }

    // -------------------------------------------------------
    // Helpers
    // -------------------------------------------------------

    private static <T> T castHelper(Object obj) {
        return (T) obj;
    }

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
