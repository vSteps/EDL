public class TestePilhaRubroNegra {

    public static void main(String[] args) {
        PilhaRubroNegra p = new PilhaRubroNegra(4);

        try {
            System.out.println("=== INICIO ===");
            p.printEstado();

            // 🔴 1. Push inicial
            System.out.println("\n=== PUSH INICIAL ===");
            p.pushVermelho("A");
            p.pushVermelho("B");
            p.pushPreto("1");
            p.pushPreto("2");
            p.printEstado();

            // 🔴 2. Força expansão
            System.out.println("\n=== EXPANSAO ===");
            p.pushVermelho("C"); // deve expandir
            p.printEstado();

            // 🔴 3. Mais inserções
            System.out.println("\n=== MAIS PUSH ===");
            p.pushPreto("3");
            p.pushVermelho("D");
            p.printEstado();

            // 🔴 4. Pops alternados
            System.out.println("\n=== POP ALTERNADO ===");
            System.out.println("Pop V: " + p.popVermelho());
            System.out.println("Pop P: " + p.popPreto());
            p.printEstado();

            // 🔴 5. Só vermelho (crescimento)
            System.out.println("\n=== MUITO VERMELHO ===");
            for (int i = 0; i < 10; i++) {
                p.pushVermelho("V" + i);
            }
            p.printEstado();

            // 🔴 6. Só preto (crescimento)
            System.out.println("\n=== MUITO PRETO ===");
            for (int i = 0; i < 10; i++) {
                p.pushPreto("P" + i);
            }
            p.printEstado();

            // 🔴 7. Remoções pesadas (força redução)
            System.out.println("\n=== REMOCAO PESADA ===");
            for (int i = 0; i < 8; i++) {
                if (!p.isEmptyVermelho()) {
                    System.out.println("Pop V: " + p.popVermelho());
                }
                if (!p.isEmptyPreto()) {
                    System.out.println("Pop P: " + p.popPreto());
                }
            }
            p.printEstado();

            // 🔴 8. Esvaziar tudo
            System.out.println("\n=== ESVAZIANDO ===");
            while (!p.isEmptyVermelho()) {
                System.out.println("Pop V: " + p.popVermelho());
            }
            while (!p.isEmptyPreto()) {
                System.out.println("Pop P: " + p.popPreto());
            }
            p.printEstado();

            // 🔴 9. Teste final após tudo
            System.out.println("\n=== TESTE FINAL ===");
            p.pushVermelho("FINAL");
            p.pushPreto("END");
            p.printEstado();

        } catch (PilhaVaziaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}