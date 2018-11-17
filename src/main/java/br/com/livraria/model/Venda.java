package br.com.livraria.model;

public class Venda {
	private Integer quantidade;
	private Livro livro;
	
	public Venda(Integer quantidade, Livro livro) {
		this.quantidade = quantidade;
		this.livro = livro;
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
