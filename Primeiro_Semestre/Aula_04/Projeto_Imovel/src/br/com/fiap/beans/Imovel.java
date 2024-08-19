package br.com.fiap.beans;

public class Imovel {

	// privacidade + tipo de dado + nome da variavel;
	// usamos o protected quando se é algo que vai ser herdado
	protected String endereco;
	protected double preco;

	// Getters e setters
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	// Construtores Vazios
	public Imovel() {
		super();
	}

	// Construtores cheios
	public Imovel(String endereco, double preco) {
		super();
		this.endereco = endereco;
		this.preco = preco;
	}

	// Realizandos os prints de preco,endereco;
	public void printPreco() {
		System.out.println("Preco: " +this.preco);
	}
	
	// Realizandos os prints de preco,endereco;
	public void printEndereco() {
		System.out.println("Endereco: " +this.endereco);
	}
	
	public void calcPreco() {
		// TODO Auto-generated method stub
		
	}
	
	public void EnderecoImovel() {
		// TODO Auto-generated method stub
		
	}
	
}
