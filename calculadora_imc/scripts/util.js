function printQtd() {
    let altura = document.getElementById("altura");
    let peso = document.getElementById("peso");

    if (altura.value <= 0) {
        altura.value = "";
        document.getElementById("alerta").hidden = false;
        return;
    }

    if (peso.value <= 0) {
        peso.value = "";
        document.getElementById("alerta").hidden = false;
        return;
    }

    let imc = peso.value / Math.pow(altura.value, 2);

    document.getElementById("imc").value = imc;
    document.getElementById("categoria").value = determinaCategora(imc);
}

function determinaCategora(imc) {
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

function hideAlerta() {
    document.getElementById("alerta").hidden = true;
}
