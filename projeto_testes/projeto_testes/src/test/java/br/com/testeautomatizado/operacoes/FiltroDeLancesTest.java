package br.com.testeautomatizado.operacoes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import br.com.testeautomatizado.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FiltroDeLancesTest {

    private Usuario joao;
    private Usuario maria;
    private Usuario jose;
    private FiltroDeLances filtro;
    private static final double VALOR_FORA_FILTRO = 3000;

    @Before
    public void setup() {
        joao = new Usuario("João");
        maria = new Usuario("Maria");
        jose = new Usuario("José");
        filtro = new FiltroDeLances();
    }

    @Test
    public void deveSelecionarLancesEntre1500e2500() {
        double valorPrimeiroFiltro = 2000;

        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, valorPrimeiroFiltro),
                new Lance(joao, VALOR_FORA_FILTRO)
        ));

        assertEquals(1, resultado.size());
        assertEquals(valorPrimeiroFiltro, resultado.get(0).getValor(), 0.0);
    }

    @Test
    public void deveSelecionarLancesEntre800e1200() {
        double valorSegundoFiltro = 1000;

        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(maria, valorSegundoFiltro),
                new Lance(maria, VALOR_FORA_FILTRO)
        ));

        assertEquals(1, resultado.size());
        assertEquals(valorSegundoFiltro, resultado.get(0).getValor(), 0.0);
    }

    @Test
    public void deveSelecionarLancesMaioresQue3500() {
        double valorTerceiroFiltro = 4000;

        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(jose, valorTerceiroFiltro),
                new Lance(jose, VALOR_FORA_FILTRO)
        ));

        assertEquals(1, resultado.size());
        assertEquals(valorTerceiroFiltro, resultado.get(0).getValor(), 0.0);
    }

    @Test
    public void naoDeveSelecionarLancesQueNaoSeEncaixamEmNenhumFiltro() {
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, new Random().nextInt(800)), 
                new Lance(maria, VALOR_FORA_FILTRO)
        ));

        assertTrue(resultado.isEmpty());
    }
}
