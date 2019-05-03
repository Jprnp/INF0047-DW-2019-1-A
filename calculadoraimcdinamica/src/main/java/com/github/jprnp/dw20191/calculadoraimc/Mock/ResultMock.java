package com.github.jprnp.dw20191.calculadoraimc.Mock;

import com.github.jprnp.dw20191.calculadoraimc.Model.Result;

import java.util.ArrayList;

public class ResultMock {

    public static ArrayList<Result> getResultList() {
        ArrayList<Result> lista = new ArrayList<Result>();

        lista.add(new Result("Menos do que 18,5", "Abaixo do peso"));
        lista.add(new Result("Entre 18,5 e 24,9", "Peso normal"));
        lista.add(new Result("Entre 25 e 29,9", "Sobrepeso"));
        lista.add(new Result("Entre 30 e 34,9", "Obesidade grau 1"));
        lista.add(new Result("Entre 35 e 39,9", "Obesidade grau 2"));
        lista.add(new Result("Mais do que 40", "Obesidade grau 3"));

        return lista;
    }
}
