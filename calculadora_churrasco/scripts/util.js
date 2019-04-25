const G_AD_CARNE = 600;
const G_CR_CARNE = 200;

var qtdAdultos;
var qtdCriancas;
var qtdTotal;
var kgPorCarne;

var qtdCarnes;

function printQtd() {
    let elemAdultos = document.getElementById("qtdAdultos");
    let elemCriancas = document.getElementById("qtdCriancas")

    qtdAdultos = elemAdultos.value;
    qtdCriancas = elemCriancas.value;

    if (qtdAdultos < 0) {
        qtdAdultos = 0;
        elemAdultos.value = 0;
    }

    if (qtdCriancas < 0) {
        qtdCriancas = 0;
        elemCriancas.value = 0.
    }

    qtdTotal = qtdAdultos * G_AD_CARNE + qtdCriancas * G_CR_CARNE;

    let opcoes = document.getElementsByClassName("form-check-input");

    qtdCarnes = 0;
    for (check of opcoes) {
        if (check.checked === true) {
            qtdCarnes++;
        }
    }

    kgPorCarne = (qtdTotal / qtdCarnes) / 1000;
    corpoTabela = document.getElementById("tabelacorpo");
    html = "";

    for (check of opcoes) {
        if (check.checked === true) {
            html = html + `<tr>\n<td>${procuraLabel(check.id)}</td>\n<td>${kgPorCarne}</td>\n</tr>\n`;
        }
    }
    corpoTabela.innerHTML = html;
}

function procuraLabel(id) {
    let labels = document.getElementsByClassName("checklabel");

    for (let label of labels) {
        if (label.htmlFor == id) {
            return (label.innerText || label.textContent);
        }
    }

    return null;
}