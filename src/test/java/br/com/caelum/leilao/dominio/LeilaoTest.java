package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeilaoTest {
	@Test
	public void recebeUmLance(){
		Leilao leilao = new Leilao("MacBook Pro 15");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Vinicius"), 2000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.0001);
	}
	
	@Test
	public void recebeVariosLances(){
		Leilao leilao = new Leilao("MacBook Pro 15");
		
		//assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Vinicius"), 2000));
		leilao.propoe(new Lance(new Usuario("CLeber"), 3000));
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.0001);
		assertEquals(3000, leilao.getLances().get(1).getValor(), 0.0001);
	}
	
	@Test
	public void negaDoisLancesDoMesmoUser(){
		Leilao leilao = new Leilao("MacBook Pro 15");
		
		//assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Vinicius"), 2000));
		leilao.propoe(new Lance(new Usuario("Vinicius"), 3000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.0001);
	}
	
	@Test
	public void nega5LancesPorUser(){
		Leilao leilao = new Leilao("MacBook Pro 15");
		
		//assertEquals(0, leilao.getLances().size());
		Usuario vini = new Usuario("Vinicius");
		Usuario mique = new Usuario("Miqueias");
		
		leilao.propoe(new Lance(vini, 2000));
		leilao.propoe(new Lance(mique, 3000));
		leilao.propoe(new Lance(vini, 4000));
		leilao.propoe(new Lance(mique, 5000));
		leilao.propoe(new Lance(vini, 6000));
		leilao.propoe(new Lance(mique, 7000));
		leilao.propoe(new Lance(vini, 8000));
		leilao.propoe(new Lance(mique, 9000));
		leilao.propoe(new Lance(vini, 10000));
		leilao.propoe(new Lance(mique, 11000));
		
		leilao.propoe(new Lance(vini, 12000));
		
		assertEquals(10, leilao.getLances().size());
		int ultimo = leilao.getLances().size()-1;
		Lance ultimoLance = leilao.getLances().get(ultimo);
		assertEquals(11000.0, ultimoLance.getValor(), 0.0001);
	}
}
