package br.com.fiap.beans;

public class Funcionario {

    // Visibilidade + tipo de dado + nome da variável
	public String nome;
	public String cargo;
	public double salario;
	//Getters E setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
