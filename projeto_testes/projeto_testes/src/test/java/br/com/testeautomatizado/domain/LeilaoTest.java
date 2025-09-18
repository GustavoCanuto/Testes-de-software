package br.com.testeautomatizado.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LeilaoTest {

    private Usuario joao;
    private Usuario maria;
    private Leilao leilao;

    @Before
    public void setup() {
        joao = new Usuario("João");
        maria = new Usuario("Maria");
        leilao = new Leilao("Produto de teste");
    }

    @Test
    public void naoDeveAceitarLancesSeguidosDoMesmoUsuario() {
        leilao.propoe(new Lance(joao, 1000));
        leilao.propoe(new Lance(joao, 2000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(1000, leilao.getLances().get(0).getValor(), 0.0001);
    }

    @Test
    public void naoDeveAceitarMaisDeSeteLancesDeUmMesmoUsuario() {
        for (int i = 1; i <= 9; i++) {
            leilao.propoe(new Lance(joao, i * 100));
            leilao.propoe(new Lance(maria, i * 200));
        }

        long lancesJoao = leilao.getLances().stream()
                .filter(lance -> lance.getUsuario().equals(joao))
                .count();

        assertEquals(7, lancesJoao);
    }

    @Test
    public void deveAdicionarLanceComNomeEValorCorretos() {
        leilao.propoe(new Lance(joao, 5000));

        Lance lance = leilao.getLances().get(0);
        assertEquals(joao.getNome(), lance.getUsuario().getNome());
        assertEquals(5000, lance.getValor(), 0.0);
    }

    @Test
    public void deveDobrarUltimoLanceDoUsuario() {
        leilao.propoe(new Lance(joao, 1000));
        leilao.propoe(new Lance(maria, 2000));
        leilao.propoe(new Lance(joao, 1500));
        leilao.propoe(new Lance(maria, 2500));

        leilao.dobraLance(joao);

        Lance ultimoLance = leilao.getLances().get(leilao.getLances().size() - 1);
        assertEquals(3000, ultimoLance.getValor(), 0.0);
        assertEquals(joao, ultimoLance.getUsuario());
    }

    @Test
    public void dobraLanceNaoDeveAdicionarSeUsuarioNaoDeuLanceAnterior() {
        leilao.propoe(new Lance(maria, 1000));

        leilao.dobraLance(joao);

        long lancesJoao = leilao.getLances().stream()
                .filter(l -> l.getUsuario().equals(joao))
                .count();

        assertEquals(0, lancesJoao);
    }

    @Test
    public void deveCalcularValorMedioDosLances() {
        leilao.propoe(new Lance(joao, 1000));
        leilao.propoe(new Lance(maria, 3000));

        double mediaEsperada = (1000 + 3000) / 2.0;
        assertEquals(mediaEsperada, leilao.valorMedio(), 0.0);
    }
}
