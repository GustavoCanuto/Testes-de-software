package br.com.testeautomatizado.operacoes;

import java.util.ArrayList;
import java.util.List;

import br.com.testeautomatizado.domain.Lance;

public class FiltroDeLances {

    public List<Lance> filtra(List<Lance> lances) {
        ArrayList<Lance> resultado = new ArrayList<Lance>();

        for(Lance lance : lances) {
            if(lance.getValor() > 1500 && lance.getValor() < 2500) 
                    resultado.add(lance);
            else if(lance.getValor() > 800 && lance.getValor() < 1200) 
                    resultado.add(lance);
            else if(lance.getValor() > 3500) 
                    resultado.add(lance);
        }

        return resultado;
    }
}