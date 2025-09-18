package br.com.testeautomatizado.operacoes;

public class Palindromo {

    public int ehPalindromo(String frase) {

        String fraseFiltrada = frase
                .toUpperCase().replace(" ", "").replace("-", "");

        for(int i = 0; i < fraseFiltrada.length(); i++) {
            if(fraseFiltrada.charAt(i) != fraseFiltrada.charAt(fraseFiltrada.length() - (i+1))) {
                return 0;
            }
        }

        return 1;
    }
}