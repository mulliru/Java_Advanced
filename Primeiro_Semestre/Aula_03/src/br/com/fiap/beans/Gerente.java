package br.com.fiap.beans;

public class Gerente extends Funcionario{
	@Override
	public void calcSalario() {
		this.salario = 5000;
	}
}
