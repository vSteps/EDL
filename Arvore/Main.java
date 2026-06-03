import java.util.Iterator;

/**
 * Classe de teste para a Árvore Genérica (TAD).
 *
 * Árvore montada:
 *
 *           A
 *         / | \
 *        B  C  D
 *       / \    |
 *      E   F   G
 *          |
 *          H
 */
public class Main {

    public static void main(String[] args) {

        ArvoreGenerica arvore = new ArvoreGenerica();

        // Inserção
        No raiz = arvore.insertRoot("A");
        No b    = arvore.insertChild(raiz, "B");
        No c    = arvore.insertChild(raiz, "C");
        No d    = arvore.insertChild(raiz, "D");
        No e    = arvore.insertChild(b, "E");
        No f    = arvore.insertChild(b, "F");
        No g    = arvore.insertChild(d, "G");
        No h    = arvore.insertChild(f, "H");

        System.out.println("=== Estrutura da Árvore ===");
        arvore.print();

        // -------------------------------------------------------------------
        // Métodos genéricos
        // -------------------------------------------------------------------
        System.out.println("\n=== Métodos Genéricos ===");
        System.out.println("size()    = " + arvore.size());
        System.out.println("height()  = " + arvore.height());
        System.out.println("isEmpty() = " + arvore.isEmpty());

        System.out.print("elements(): ");
        Iterator<Object> itElem = arvore.elements();
        while (itElem.hasNext()) System.out.print(itElem.next() + " ");
        System.out.println();

        System.out.print("nos()     : ");
        Iterator<No> itNos = arvore.nos();
        while (itNos.hasNext()) System.out.print(itNos.next().getElemento() + " ");
        System.out.println();

        // -------------------------------------------------------------------
        // Métodos de acesso
        // -------------------------------------------------------------------
        System.out.println("\n=== Métodos de Acesso ===");
        System.out.println("root()         = " + arvore.root().getElemento());
        System.out.println("parent(B)      = " + arvore.parent(b).getElemento());
        System.out.println("parent(H)      = " + arvore.parent(h).getElemento());

        System.out.print("children(B)    = ");
        Iterator<No> itFilhos = arvore.children(b);
        while (itFilhos.hasNext()) System.out.print(itFilhos.next().getElemento() + " ");
        System.out.println();

        // -------------------------------------------------------------------
        // Métodos de consulta
        // -------------------------------------------------------------------
        System.out.println("\n=== Métodos de Consulta ===");
        System.out.println("isInternal(B)  = " + arvore.isInternal(b));   // true
        System.out.println("isInternal(E)  = " + arvore.isInternal(e));   // false
        System.out.println("isExternal(E)  = " + arvore.isExternal(e));   // true
        System.out.println("isExternal(B)  = " + arvore.isExternal(b));   // false
        System.out.println("isRoot(A)      = " + arvore.isRoot(raiz));     // true
        System.out.println("isRoot(B)      = " + arvore.isRoot(b));        // false
        System.out.println("depth(A)       = " + arvore.depth(raiz));      // 0
        System.out.println("depth(B)       = " + arvore.depth(b));         // 1
        System.out.println("depth(H)       = " + arvore.depth(h));         // 3

        // -------------------------------------------------------------------
        // Método de atualização
        // -------------------------------------------------------------------
        System.out.println("\n=== Método de Atualização ===");
        Object anterior = arvore.replace(c, "C_NOVO");
        System.out.println("replace(C, C_NOVO) → anterior: " + anterior);
        System.out.println("Valor atual do nó : " + c.getElemento());

        // -------------------------------------------------------------------
        // Remoção (método adicional)
        // -------------------------------------------------------------------
        System.out.println("\n=== Remoção do nó D (e subárvore G) ===");
        arvore.remove(d);
        arvore.print();
        System.out.println("size() após remoção = " + arvore.size());
    }
}
