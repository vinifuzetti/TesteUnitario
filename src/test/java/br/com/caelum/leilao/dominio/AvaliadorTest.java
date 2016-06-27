package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AvaliadorTest {
	
	@Test
	public void ordemCrescente() {

		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Ps4 novo");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void semLance() {

		Leilao leilao = new Leilao("Ps4 novo");

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 0.0;
		double menorEsperado = 0.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void umLance() {
		
		Usuario joao = new Usuario("Joao");
		
		Leilao leilao = new Leilao("Ps4 novo");
		leilao.propoe(new Lance(joao, 300.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 300.0;
		double menorEsperado = 300.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void cincoLances() {
		
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		Usuario vini = new Usuario("Vini");
		Usuario mique = new Usuario("Mique");
		
		Leilao leilao = new Leilao("Ps4 novo");
		leilao.propoe(new Lance(joao, 500.0));
		leilao.propoe(new Lance(jose, 700.0));
		leilao.propoe(new Lance(maria, 900.0));
		leilao.propoe(new Lance(vini, 1000.0));
		leilao.propoe(new Lance(mique, 1200.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 1200.0;
		double menorEsperado = 500.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void encontraTresMaiores() {

		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		
		Leilao leilao = new Leilao("Ps4 novo");
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(jose, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.0001);
		assertEquals(300, maiores.get(1).getValor(), 0.0001);
		assertEquals(200, maiores.get(2).getValor(), 0.0001);
	}
}
