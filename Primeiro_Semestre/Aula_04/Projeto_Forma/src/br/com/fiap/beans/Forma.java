package br.com.fiap.beans;

public abstract class Forma {

	// Atributos protegidos para permitir herança
	protected String cor;
	protected String metodo;
	protected int area;

	// Construtor vazio
	public Forma() {
		super();
	}

	// Construtor cheio
	public Forma(String cor, String metodo, int area) {
		super();
		this.cor = cor;
		this.metodo = metodo;
		this.area = area;
	}

	// Getters e setters
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	// Realizando o print de cor, metodo e area

	// Print de cor
	public void printCor() {
		System.out.println("Cor: " + this.cor);
	}

	// Print de Metodo
	public void printMetodo() {
		System.out.println("Metodo: " + this.metodo);
	}

	// Print de area
	public void printArea() {
		System.out.println("Área: " + this.area);
	}

}
