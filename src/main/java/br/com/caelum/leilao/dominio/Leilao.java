package br.com.caelum.leilao.dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {
	
	public String nome;
	public List<Lance> lances;
	public double valor_inicial;
	public Date data;
	public String dono;
	
	public Leilao(String nome){
		this.lances = new ArrayList<Lance>();
		this.nome = nome;
	}
	
	public List<Lance> getLances(){
		return Collections.unmodifiableList(lances);
	}
	
	public void propoe(Lance lance){
		if(lances.isEmpty() || podeDarLance(lance.getUsuario())){
			lances.add(lance);
		}
		
	}
	
	private Lance ultimoLanceDado(){
		return lances.get(lances.size() -1);
	}
	
	private int qtdDeLances(Usuario usuario){
		int total = 0;
		for (Lance lance : lances){
			if(lance.getUsuario().equals(usuario)) 
				total++;
		}
		return total;
	}
	
	private boolean podeDarLance(Usuario usuario){
		return !ultimoLanceDado().getUsuario().equals(usuario) && qtdDeLances(usuario) < 5;
	}

}
