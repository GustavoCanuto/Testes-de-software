package br.com.testeautomatizado.operacoes;

public class MatematicaMaluca {

    public double contaMaluca(double numero) {
        if (numero > 50)
            return numero * 50;
        else if (numero > 25)
            return numero * 30;
        else
            return numero * 20;
    }
}