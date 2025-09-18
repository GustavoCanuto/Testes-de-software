package br.com.testeautomatizado.operacoes;

public class AnoBissexto {
	public int ehBissexto(int ano) {
		if((ano % 400 == 0 || !(ano % 100 == 0)) && ano % 4 == 0){
			return 1;
		}
		return 0;
	}
}
