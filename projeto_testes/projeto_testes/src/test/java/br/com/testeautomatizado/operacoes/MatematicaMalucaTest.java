package br.com.testeautomatizado.operacoes;

import static org.junit.Assert.*;
import org.junit.Test;

public class MatematicaMalucaTest {

    @Test
    public void deveMultiplicarPor50QuandoMaiorQue50() {
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        int valorParaCalcular = 100;
        assertEquals(valorParaCalcular * 50, matematicaMaluca.contaMaluca(valorParaCalcular), 0.0);
    }

    @Test
    public void deveMultiplicarPor30QuandoMaiorQue25() {
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        int valorParaCalcular = 30;
        assertEquals(valorParaCalcular * 30, matematicaMaluca.contaMaluca(valorParaCalcular), 0.0);
    }

    @Test
    public void deveMultiplicarPor20QuandoMenorOuIgualA25() {
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        int valorParaCalcular = 10;
        assertEquals(valorParaCalcular * 20, matematicaMaluca.contaMaluca(valorParaCalcular), 0.0);
    }
}
