package br.com.bossini.usjt_ads3anmca_helpdesk;

import java.io.Serializable;
import java.util.List;

class Fila implements Serializable {
    private int iconId;
    private String nome;
    private List<Chamado> chamados;

    public Fila(String nome, int iconId) {
        setNome(nome);
        setIconId(iconId);
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
