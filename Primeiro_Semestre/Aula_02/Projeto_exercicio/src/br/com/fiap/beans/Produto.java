package br.com.fiap.beans;

public class Produto {

    // Visibilidade + tipo de dado + nome da variável
	private String nome;
	private String marca;
	private double preco;
	private double peso;
	
    // Construtor vazio
	public Produto() {
		super();
	}	
	
    // Construtor cheio
	public Produto(String nome, String marca, double preco, double peso) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.peso = peso;
	}

    // Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
