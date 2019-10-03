package br.com.bossini.usjt_ads3anmca_helpdesk;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Chamado implements Serializable {
    private Fila fila;
    private String descricao;
    private Date dataAbertura;
    private Date dataFechamento;
    private String status;

    public Chamado(Fila fila, String descricao,
                        Date dataAbertura, Date dataFechamento, String status) {
        setFila(fila);
        setDescricao(descricao);
        setDataAbertura(dataAbertura);
        setDataFechamento(dataFechamento);
        setStatus(status);
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Chamado{" +
                "descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
