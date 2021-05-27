package org.example;

public class Filtro {
    public enum TipoItem {
        Livro, Celular, Tablet
    }

    private TipoItem tipoItem;
    private String nome;

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
