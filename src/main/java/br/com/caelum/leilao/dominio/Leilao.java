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
		lances.add(lance);
	}

}
