package Arvore;

import java.util.ArrayList;
import java.util.List;

public class NoImpl implements No {

    private Object elemento;
    private NoImpl pai;
    private List<NoImpl> filhos;

    public NoImpl(Object elemento) {
        this.elemento = elemento;
        this.pai = null;
        this.filhos = new ArrayList<>();
    }

    @Override
    public Object getElemento() {
        return elemento;
    }

    @Override
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NoImpl getPai() {
        return pai;
    }

    public void setPai(NoImpl pai) {
        this.pai = pai;
    }

    public List<NoImpl> getFilhos() {
        return filhos;
    }

    public void addFilho(NoImpl filho) {
        filho.setPai(this);
        filhos.add(filho);
    }

    public void removeFilho(NoImpl filho) {
        filhos.remove(filho);
    }
}
