package com.github.jprnp.dw20191.calculadoraimc.model;

public class CalculoModel {

    public static float calcImc(float altura, float peso) {
        return (float) (peso / Math.pow(altura, 2));
    }

    public static String determinaResultado(float imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (18.5 <= imc && imc <= 24.9) {
            return "Peso normal";
        } else if (25 <= imc && imc <= 29.9) {
            return "Sobrepeso";
        } else if (30 <= imc && imc <= 34.9) {
            return "Obesidade grau 1";
        } else if (35 <= imc && imc <= 39.9) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }
}
