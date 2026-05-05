package Vetor;

/**
 * Classe de testes para VetorArrayImpl e VetorDEImpl.
 *
 * Cada cenário é executado nas DUAS implementações para garantir
 * que ambas se comportam de forma idêntica.
 */
public class TesteVetor {

    private static int totalTestes   = 0;
    private static int testesPassaram = 0;

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("   TESTES — TAD Vetor");
        System.out.println("   Array  vs  Lista Duplamente Encadeada");
        System.out.println("=================================================\n");

        // Executa todos os testes nas duas implementações
        executarTodos("Array", new VetorArrayImpl<>(5), new VetorArrayImpl<>(1));
        System.out.println();
        executarTodos("ListaDE", new VetorDEImpl<>(5), new VetorDEImpl<>(1));

        System.out.println("\n=================================================");
        System.out.printf("  Resultado final: %d/%d testes passaram%n",
                testesPassaram, totalTestes);
        System.out.println("=================================================");
    }

    // -------------------------------------------------------
    // Executa todos os cenários para uma implementação
    // -------------------------------------------------------

    private static void executarTodos(String nome,
                                      VetorTAD<Integer> v5,
                                      VetorTAD<Integer> v1) {

        System.out.println("─────────────────────────────────────────────────");
        System.out.println("  Implementacao: " + nome);
        System.out.println("─────────────────────────────────────────────────");

        testarCriacao(nome, v5);
        testarIsEmpty(nome);
        testarElemAtRankNulo(nome, v5);
        testarReplaceAtRank(nome, v5);
        testarSobrescritaMultipla(nome);
        testarLimitesDasExtremidades(nome);
        testarCapacidade1(nome, v1);
        testarExcecaoRankNegativo(nome);
        testarExcecaoRankForaDoLimite(nome);
        testarTipoString(nome);
        testarToString(nome);
    }

    // -------------------------------------------------------
    // Cenários de teste
    // -------------------------------------------------------

    private static void testarCriacao(String impl, VetorTAD<Integer> v) {
        System.out.println("\n[ TESTE ] Criacao — size() e valores iniciais (" + impl + ")");
        verificar("size() == 5", v.size() == 5);
        for (int i = 0; i < 5; i++) {
            verificar("elemAtRank(" + i + ") == null", v.elemAtRank(i) == null);
        }
    }

    private static void testarIsEmpty(String impl) {
        System.out.println("\n[ TESTE ] isEmpty (" + impl + ")");

        VetorTAD<Integer> v = criarVetor(impl, 3);
        verificar("isEmpty() == true quando tudo null", v.isEmpty());

        v.replaceAtRank(1, 42);
        verificar("isEmpty() == false apos inserir elemento", !v.isEmpty());

        v.replaceAtRank(1, null);
        verificar("isEmpty() == true apos remover elemento (null)", v.isEmpty());
    }

    private static void testarElemAtRankNulo(String impl, VetorTAD<Integer> v) {
        System.out.println("\n[ TESTE ] elemAtRank com valores null (" + impl + ")");
        verificar("rank 0 == null", v.elemAtRank(0) == null);
        verificar("rank 2 == null", v.elemAtRank(2) == null);
        verificar("rank 4 == null", v.elemAtRank(4) == null);
    }

    private static void testarReplaceAtRank(String impl, VetorTAD<Integer> v) {
        System.out.println("\n[ TESTE ] replaceAtRank (" + impl + ")");

        // Insere valores
        Integer antigoR0 = v.replaceAtRank(0, 10);
        Integer antigoR2 = v.replaceAtRank(2, 30);
        Integer antigoR4 = v.replaceAtRank(4, 50);

        verificar("replaceAtRank(0,10) retorna null (anterior)", antigoR0 == null);
        verificar("replaceAtRank(2,30) retorna null (anterior)", antigoR2 == null);
        verificar("replaceAtRank(4,50) retorna null (anterior)", antigoR4 == null);

        verificar("elemAtRank(0) == 10", v.elemAtRank(0) == 10);
        verificar("elemAtRank(1) == null (nao alterado)", v.elemAtRank(1) == null);
        verificar("elemAtRank(2) == 30", v.elemAtRank(2) == 30);
        verificar("elemAtRank(3) == null (nao alterado)", v.elemAtRank(3) == null);
        verificar("elemAtRank(4) == 50", v.elemAtRank(4) == 50);

        // Substitui valores existentes
        Integer substituido = v.replaceAtRank(2, 99);
        verificar("replaceAtRank(2,99) retorna 30 (valor anterior)", substituido == 30);
        verificar("elemAtRank(2) == 99 apos substituicao", v.elemAtRank(2) == 99);
    }

    private static void testarSobrescritaMultipla(String impl) {
        System.out.println("\n[ TESTE ] Sobrescrita multipla na mesma posicao (" + impl + ")");

        VetorTAD<Integer> v = criarVetor(impl, 3);
        v.replaceAtRank(1, 100);
        v.replaceAtRank(1, 200);
        Integer ret = v.replaceAtRank(1, 300);

        verificar("retornou 200 (penultimo valor)", ret == 200);
        verificar("elemAtRank(1) == 300 (ultimo valor)", v.elemAtRank(1) == 300);
        verificar("rank 0 continua null", v.elemAtRank(0) == null);
        verificar("rank 2 continua null", v.elemAtRank(2) == null);
    }

    private static void testarLimitesDasExtremidades(String impl) {
        System.out.println("\n[ TESTE ] Limites das extremidades (" + impl + ")");

        VetorTAD<Integer> v = criarVetor(impl, 4);
        v.replaceAtRank(0, 1);        // primeira posicao
        v.replaceAtRank(3, 9);        // ultima posicao

        verificar("rank 0 == 1 (primeira posicao)", v.elemAtRank(0) == 1);
        verificar("rank 3 == 9 (ultima posicao)",  v.elemAtRank(3) == 9);
        verificar("rank 1 == null",                v.elemAtRank(1) == null);
        verificar("rank 2 == null",                v.elemAtRank(2) == null);
        verificar("size() nao muda == 4",          v.size() == 4);
    }

    private static void testarCapacidade1(String impl, VetorTAD<Integer> v1) {
        System.out.println("\n[ TESTE ] Vetor de capacidade 1 (" + impl + ")");

        verificar("size() == 1", v1.size() == 1);
        verificar("elemAtRank(0) == null", v1.elemAtRank(0) == null);

        Integer antigo = v1.replaceAtRank(0, 77);
        verificar("replaceAtRank(0,77) retorna null", antigo == null);
        verificar("elemAtRank(0) == 77", v1.elemAtRank(0) == 77);
    }

    private static void testarExcecaoRankNegativo(String impl) {
        System.out.println("\n[ TESTE ] Excecao rank negativo (" + impl + ")");

        VetorTAD<Integer> v = criarVetor(impl, 3);

        try {
            v.elemAtRank(-1);
            verificar("elemAtRank(-1) deve lancar excecao", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("elemAtRank(-1) lancou IndexOutOfBoundsException", true);
        }

        try {
            v.replaceAtRank(-1, 10);
            verificar("replaceAtRank(-1) deve lancar excecao", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("replaceAtRank(-1) lancou IndexOutOfBoundsException", true);
        }
    }

    private static void testarExcecaoRankForaDoLimite(String impl) {
        System.out.println("\n[ TESTE ] Excecao rank fora do limite (" + impl + ")");

        VetorTAD<Integer> v = criarVetor(impl, 3);

        try {
            v.elemAtRank(3);   // validos: 0,1,2
            verificar("elemAtRank(3) em vetor de size 3 deve lancar excecao", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("elemAtRank(3) lancou IndexOutOfBoundsException", true);
        }

        try {
            v.replaceAtRank(10, 99);
            verificar("replaceAtRank(10) deve lancar excecao", false);
        } catch (IndexOutOfBoundsException e) {
            verificar("replaceAtRank(10) lancou IndexOutOfBoundsException", true);
        }
    }

    private static void testarTipoString(String impl) {
        System.out.println("\n[ TESTE ] Vetor com tipo String (" + impl + ")");

        VetorTAD<String> v;
        if (impl.equals("Array")) {
            v = new VetorArrayImpl<>(3);
        } else {
            v = new VetorDEImpl<>(3);
        }

        v.replaceAtRank(0, "alpha");
        v.replaceAtRank(1, "beta");
        v.replaceAtRank(2, "gamma");

        verificar("rank 0 == alpha",  "alpha".equals(v.elemAtRank(0)));
        verificar("rank 1 == beta",   "beta".equals(v.elemAtRank(1)));
        verificar("rank 2 == gamma",  "gamma".equals(v.elemAtRank(2)));

        String antigo = v.replaceAtRank(1, "delta");
        verificar("substituiu beta por delta, retornou beta", "beta".equals(antigo));
        verificar("rank 1 == delta apos substituicao", "delta".equals(v.elemAtRank(1)));
    }

    private static void testarToString(String impl) {
        System.out.println("\n[ TESTE ] toString (" + impl + ")");

        VetorTAD<Integer> v = criarVetor(impl, 3);
        v.replaceAtRank(0, 1);
        v.replaceAtRank(2, 3);

        String resultado = v.toString();
        verificar("toString nao e null", resultado != null);
        verificar("toString nao esta vazio", !resultado.isEmpty());
        System.out.println("  toString: " + resultado);
    }

    // -------------------------------------------------------
    // Helpers
    // -------------------------------------------------------

   
    private static VetorTAD<Integer> criarVetor(String impl, int cap) {
        if (impl.equals("Array")) return new VetorArrayImpl<>(cap);
        else                      return new VetorDEImpl<>(cap);
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