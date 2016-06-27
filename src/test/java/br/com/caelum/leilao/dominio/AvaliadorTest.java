package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AvaliadorTest {
	
	//metodo para criar avaliador
	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	
	@Before
	public void criaAvaliador(){
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("Joao");
		this.jose = new Usuario("Jose");
		this.maria = new Usuario("Maria");
	}
	
	@Test
	public void ordemCrescente() {

		Leilao leilao = new Leilao("Ps4 novo");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));

		//Avaliador leiloeiro = new Avaliador();
		criaAvaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void semLance() {
		try {
			Leilao leilao = new Leilao("Ps4 novo");
			criaAvaliador();
			leiloeiro.avalia(leilao);
			Assert.fail();
		}
		catch(RuntimeException e){
			//deu certo
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void umLance() {		
		Leilao leilao = new Leilao("Ps4 novo");
		leilao.propoe(new Lance(joao, 300.0));

		//Avaliador leiloeiro = new Avaliador();
		criaAvaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 300.0;
		double menorEsperado = 300.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void cincoLances() {		
		Leilao leilao = new Leilao("Ps4 novo");
		leilao.propoe(new Lance(joao, 500.0));
		leilao.propoe(new Lance(jose, 700.0));
		leilao.propoe(new Lance(maria, 900.0));
		leilao.propoe(new Lance(joao, 1100.0));
		leilao.propoe(new Lance(jose, 1200.0));
		//Avaliador leiloeiro = new Avaliador();
		criaAvaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 1200.0;
		double menorEsperado = 500.0;

		assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void encontraTresMaiores() {
		
		Leilao leilao = new CriadorDeLeiloes().para("Ps4 Novo")
				.lance(joao, 100.0)
				.lance(jose, 200.0)
				.lance(joao, 300.0)
				.lance(jose, 400.0)
				.constroi();

		//Avaliador leiloeiro = new Avaliador();
		criaAvaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.0001);
		assertEquals(300, maiores.get(1).getValor(), 0.0001);
		assertEquals(200, maiores.get(2).getValor(), 0.0001);
	}
	
	@After
	public void finaliza(){
		System.out.println("Finaliza Teste");
	}
}
