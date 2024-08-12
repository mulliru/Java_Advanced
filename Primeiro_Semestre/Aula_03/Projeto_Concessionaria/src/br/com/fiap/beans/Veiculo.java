package br.com.fiap.beans;

public class Veiculo {

	// privacidade + tipo de dado + nome da variavel;
	// usamos o protected quando se é algo que vai ser herdado
	protected String marca;
	protected String modelo;
	protected String cor;
	protected double preco;

	// Getters e Setters
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	// Realizandos os prints de marca,modelo,cor,preco;

	// Prints de Marca
	public void printMarca() {
		System.out.println("Marca: " + this.marca);
	}

	// Print de modelo
	public void printModelo() {
		System.out.println("Modelo: " + this.marca);
	}

	// print de cor
	public void printCor() {
		System.out.println("Cor: " + this.cor);
	}

	// print de Preco
	public void printPreco() {
		System.out.println("Preco: " + this.preco);
	}

	public void calcPreco() {
		// TODO Auto-generated method stub
		
	}

}