package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
	private double maiorDeTodos;
	private double menorDeTodos;
	public List<Lance> maiores;
	
	public void avalia(Leilao leilao){
		menorDeTodos = leilao.getLances().isEmpty() ? 0:leilao.getLances().get(0).valor;
		maiorDeTodos = 0;
		for (Lance lance : leilao.getLances()){
			if (lance.getValor() > maiorDeTodos){
				maiorDeTodos = lance.getValor();
			}
			else if(lance.getValor() < menorDeTodos){
				menorDeTodos = lance.getValor();
			}
		}
		
		pegaOsMaioresNo(leilao);
	}
	
	private void pegaOsMaioresNo(Leilao leilao){
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>(){
			public int compare(Lance o1, Lance o2){
				if(o1.getValor() < o2.getValor()){
					return 1;
				}
				if(o1.getValor() > o2.getValor()){
					return -1;
				}
				return 0;
			}
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}
	
	public List<Lance> getTresMaiores(){
		return this.maiores;
	}

	public double getMaiorDeTodos() {
		return maiorDeTodos;
	}

	public double getMenorDeTodos() {
		return menorDeTodos;
	}

}
