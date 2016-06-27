package br.com.caelum.leilao.dominio;

public class Usuario {
	public String nome;
	public Integer id;
	
	public Usuario(String nome, Integer id){
		super();
		this.nome = nome;
		this.id = id;
	}
	
	public Usuario(String nome){
		this(nome, 0);
	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}	

}
