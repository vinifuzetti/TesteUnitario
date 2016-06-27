package br.com.caelum.leilao.dominio;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiltroDeLancesTest {
	@Test
	public void lanceEntre1000E3000(){
		Usuario joao = new Usuario("Joao");
		
		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(Arrays.asList(
				new Lance(joao, 2000),
				new Lance(joao, 1000),
				new Lance(joao, 3000),
				new Lance(joao, 4000)));
		assertEquals(1, resultado.size());
		assertEquals(2000, resultado.get(0).getValor(), 0.0001);	
	}
	
	@Test
	public void lanceEntre500E700(){
		Usuario joao = new Usuario("Joao");
		
		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(Arrays.asList(
				new Lance(joao, 600),
				new Lance(joao, 500),
				new Lance(joao, 700),
				new Lance(joao, 800)));
		assertEquals(1, resultado.size());
		assertEquals(600, resultado.get(0).getValor(), 0.0001);	
	}
	
	@Test
	public void lanceMaior5000(){
		Usuario joao = new Usuario("Joao");
		
		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(Arrays.asList(
				new Lance(joao, 1000),
				new Lance(joao, 100),
				new Lance(joao, 5000),
				new Lance(joao, 6000)));
		assertEquals(1, resultado.size());
		assertEquals(6000, resultado.get(0).getValor(), 0.0001);	
	}

}
