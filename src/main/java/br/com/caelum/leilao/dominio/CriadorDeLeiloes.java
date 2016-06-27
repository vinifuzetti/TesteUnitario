package br.com.caelum.leilao.dominio;

public class CriadorDeLeiloes {
	private Leilao leilao;
	public CriadorDeLeiloes() {}
	
	public CriadorDeLeiloes para(String descricao){
		this.leilao = new Leilao(descricao);
		return this;
	}
	
	public CriadorDeLeiloes lance(Usuario usuario, double valor){
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}
	
	public Leilao constroi(){
		return leilao;
	}
}
