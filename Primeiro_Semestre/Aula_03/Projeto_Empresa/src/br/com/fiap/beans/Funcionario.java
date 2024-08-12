package br.com.fiap.beans;

public class Funcionario {

	// privacidade + tipo de dado + nome da variavel;
	// usamos o protected quando se é algo que vai ser herdado
	protected String nome;
	protected double salario;

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	// Prints

	// Prints de nome
	public void pritNome() {
		System.out.println("Nome: " + this.nome);
	}

	// Prints de Salario
	public void printSalario() {
		System.out.println("Salario: " + this.salario);
	}

	// Prints de calcSalario
	public void calcSalario() {
		this.salario = 1000;
	}

}
