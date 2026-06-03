package Arvore;

import java.util.Iterator;
public interface Arvore {

    int size();
    int height();
    boolean isEmpty();
    Iterator<Object> elements();
    Iterator<No> nos();
    No root();
    No parent(No v);
    Iterator<No> children(No v);
    boolean isInternal(No v);
    boolean isExternal(No v);
    boolean isRoot(No v);
    int depth(No v);
    Object replace(No v, Object o);
}
