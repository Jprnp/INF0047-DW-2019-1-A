package com.github.jprnp.dw20191.calculadoraimc.Model;

public class Result {

    private String condicao;
    private String valor;

    public Result(String condicao, String valor) {
        this.condicao = condicao;
        this.valor = valor;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
