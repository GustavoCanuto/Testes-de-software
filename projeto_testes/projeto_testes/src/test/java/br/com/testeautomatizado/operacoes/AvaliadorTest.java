package br.com.testeautomatizado.operacoes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import br.com.testeautomatizado.domain.*;

import java.util.ArrayList;
import java.util.List;

public class AvaliadorTest {

    private Usuario joao;
    private Usuario maria;
    private Usuario jose;
    private Usuario gustavo;

    private List<Lance> lances;
    private Avaliador avaliador;

    @Before
    public void setup() {
        joao = new Usuario("João");
        maria = new Usuario("Maria");
        jose = new Usuario("José");
        gustavo = new Usuario("Gustavo");

        lances = new ArrayList<>(List.of(
        	    new Lance(joao, 1000),
        	    new Lance(maria, 2000),
        	    new Lance(jose, 3000),
        	    new Lance(gustavo, 55)
        	));

        avaliador = new Avaliador();
    }

    @Test
    public void deveRetornarTresMaioresLances() {
        Leilao leilao = new Leilao("Play 5");
        lances.forEach(leilao::propoe);

        avaliador.avalia(leilao);

        List<Lance> maiores = avaliador.getTresMaiores();

        assertEquals(3, maiores.size());

        assertEquals(3000, maiores.get(0).getValor(), 0.0);
        assertEquals(2000, maiores.get(1).getValor(), 0.0);
        assertEquals(1000, maiores.get(2).getValor(), 0.0);

        for (Lance lance : maiores) {
            assertNotEquals(55, lance.getValor(), 0.0);
        }
    }

    @Test
    public void deveRetornarMaiorLance() {
        Leilao leilao = new Leilao("TV");
        lances.forEach(leilao::propoe);

        avaliador.avalia(leilao);

        assertEquals(3000, avaliador.getMaiorLance(), 0.0);
    }

    @Test
    public void deveRetornarMenorLance() {
        Leilao leilao = new Leilao("Carro");
        lances.forEach(leilao::propoe);

        avaliador.avalia(leilao);

        assertEquals(55, avaliador.getMenorLance(),  0.0);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveAvaliarLeilaoSemLances() {
        Leilao leilao = new Leilao("Casa");
        avaliador.avalia(leilao);
    }
}
