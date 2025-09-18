package br.com.testeautomatizado.operacoes;

import static org.junit.Assert.*;
import org.junit.Test;

public class AnoBissextoTest {

    @Test
    public void deveRetornar1ParaAnoBissexto() {
        AnoBissexto anoBissexto = new AnoBissexto();
        assertEquals(1, anoBissexto.ehBissexto(2020));
    }

    @Test
    public void deveRetornar0ParaAnoNaoBissexto() {
        AnoBissexto anoBissexto = new AnoBissexto();
        assertEquals(0, anoBissexto.ehBissexto(2019));
    }
}
