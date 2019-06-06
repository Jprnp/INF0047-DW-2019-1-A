package com.github.jprnp.dw20191.calculadoraimc.controllers;

import com.github.jprnp.dw20191.calculadoraimc.model.Mock.ResultMock;
import com.github.jprnp.dw20191.calculadoraimc.model.CalculoModel;
import com.github.jprnp.dw20191.calculadoraimc.model.Result;
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

        ArrayList<Result> tabelaResult = ResultMock.getResultList();

        float imc = CalculoModel.calcImc(altura, peso);

        String resultado = "";

        if (altura > 0 && peso > 0) {
            resultado = CalculoModel.determinaResultado(imc);
        }

        model.addAttribute("imc", imc);
        model.addAttribute("resultado", resultado);
        model.addAttribute("tabelaResult", tabelaResult);

        return "calculadora";
    }
}
