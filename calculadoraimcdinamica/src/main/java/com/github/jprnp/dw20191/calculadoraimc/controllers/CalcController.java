package com.github.jprnp.dw20191.calculadoraimc.controllers;

import com.github.jprnp.dw20191.calculadoraimc.Mock.ResultMock;
import com.github.jprnp.dw20191.calculadoraimc.Model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class CalcController {

    @GetMapping("/")
    public String display(Model model) {

        ArrayList<Result> tabelaResult = ResultMock.getResultList();

        float imc = 0;
        String resultado = "";

        model.addAttribute("imc", imc);
        model.addAttribute("resultado", resultado);
        model.addAttribute("tabelaResult", tabelaResult);

        return "calculadora";
    }

    @GetMapping("/calcular")
    public String displayResults(
            @RequestParam(name = "altura", required = false, defaultValue = "0.0") float altura,
            @RequestParam(name = "peso", required = false, defaultValue = "1.0") float peso,
            Model model) {

        System.out.println("altura: " + altura + " peso: " + peso);

        ArrayList<Result> tabelaResult = ResultMock.getResultList();

        float imc = calcImc(altura, peso);

        String resultado = "";

        if (altura > 0 && peso > 0) {
            resultado = determinaResultado(imc);
        }

        model.addAttribute("imc", imc);
        model.addAttribute("resultado", resultado);
        model.addAttribute("tabelaResult", tabelaResult);

        return "calculadora";
    }

    private float calcImc(float altura, float peso) {
        return (float) (peso / Math.pow(altura, 2));
    }

    private String determinaResultado(float imc) {
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
