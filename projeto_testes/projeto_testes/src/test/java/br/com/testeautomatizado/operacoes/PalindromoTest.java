package br.com.testeautomatizado.operacoes;

import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromoTest {

    @Test
    public void deveReconhecerFrasePalindromo() {
        Palindromo palindromo = new Palindromo();
        assertEquals(1, palindromo.ehPalindromo("Ame o poema"));
    }

    @Test
    public void deveReconhecerFraseNaoPalindromo() {
        Palindromo palindromo = new Palindromo();
        assertEquals(0, palindromo.ehPalindromo("Frase Não Palindromo"));
    }
}
