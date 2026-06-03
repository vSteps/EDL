package Arvore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArvoreGenerica implements Arvore {

    private NoImpl raiz;
    private int tamanho;

    public ArvoreGenerica() {
        raiz = null;
        tamanho = 0;
    }

    public ArvoreGenerica(Object elementoRaiz) {
        raiz = new NoImpl(elementoRaiz);
        tamanho = 1;
    }

    //Retorna o número de nós da árvore.

    @Override
    public int size() {
        return tamanho;
    }

    //Retorna a altura da árvore.
    @Override
    public int height() {
        if (isEmpty()) 
            return 0;
        return height(raiz);
    }

    private int height(No v) {
        if (isExternal(v)) 
            return 0;
        int h = 0;
        NoImpl no = (NoImpl) v;
        for (NoImpl filho : no.getFilhos()) {
            h = Math.max(h, height(filho));
        }
        return 1 + h;
    }

    //indica se a árvore é vazia.
    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    //Retorna um iterador para os elementos armazenados nos nós.
    @Override
    public Iterator<Object> elements() {
        List<Object> lista = new ArrayList<>();
        coletarElementos(raiz, lista);
        return lista.iterator();
    }

    private void coletarElementos(NoImpl no, List<Object> lista) {
        if (no == null) return;
        lista.add(no.getElemento());
        for (NoImpl filho : no.getFilhos()) {
            coletarElementos(filho, lista);
        }
    }

    //Retorna um iterador para todos os nós da árvore.
    @Override
    public Iterator<No> nos() {
        List<No> lista = new ArrayList<>();
        coletarNos(raiz, lista);
        return lista.iterator();
    }

    private void coletarNos(NoImpl no, List<No> lista) {
        if (no == null) return;
        lista.add(no);
        for (NoImpl filho : no.getFilhos()) {
            coletarNos(filho, lista);
        }
    }

    //Retorna o nó raiz.
    @Override
    public No root() {
        if (isEmpty())
            throw new IllegalStateException("Árvore vazia.");
        return raiz;
    }

    //Retorna o nó pai de v.
    @Override
    public No parent(No v) {
        NoImpl no = (NoImpl) v;
        if (isRoot(no))
            throw new IllegalArgumentException("A raiz não possui pai.");
        return no.getPai();
    }

    //Retorna um iterador para os filhos de v.
    @Override
    public Iterator<No> children(No v) {
        NoImpl no = (NoImpl) v;
        List<No> filhos = new ArrayList<>(no.getFilhos());
        return filhos.iterator();
    }


    //verifica se v é interno (possui pelo menos um filho).
    @Override
    public boolean isInternal(No v) {
        return !isExternal(v);
    }

    //verifica se v é externo / folha (não possui filhos).
    @Override
    public boolean isExternal(No v) {
        NoImpl no = (NoImpl) v;
        return no.getFilhos().isEmpty();
    }

    //verifica se v é a raiz.
    @Override
    public boolean isRoot(No v) {
        NoImpl no = (NoImpl) v;
        return no == raiz;
    }

   //retorna a profundidade de v (raiz = 0).
    @Override
    public int depth(No v) {
        if (isRoot(v)) return 0;
        return 1 + depth(parent(v));
    }


    //substitui o elemento armazenado em v. Retorna o elemento anterior.
    @Override
    public Object replace(No v, Object o) {
        NoImpl no = (NoImpl) v;
        Object anterior = no.getElemento();
        no.setElemento(o);
        return anterior;
    }

    //Insere um novo nó com o elemento informado como filho de pai. Retorna o nó criado.
    public No insertChild(No pai, Object elemento) {
        NoImpl nodePai = (NoImpl) pai;
        NoImpl filho = new NoImpl(elemento);
        nodePai.addFilho(filho);
        tamanho++;
        return filho;
    }

    //Remove o nó v e toda sua subárvore. Retorna o elemento armazenado em v.
    public void remove(No v) {
        NoImpl no = (NoImpl) v;
        if (isRoot(no))
            throw new IllegalArgumentException("Use um método específico para remover a raiz.");
        NoImpl pai = no.getPai();
        pai.removeFilho(no);
        tamanho -= contarSubarvore(no);
    }

    private int contarSubarvore(NoImpl no) {
        int count = 1;
        for (NoImpl filho : no.getFilhos()) {
            count += contarSubarvore(filho);
        }
        return count;
    }

}
