package br.com.fiap.main;

import br.com.fiap.beans.Pessoa;

public class TestePessoa {

	public static void main(String[] args) {
		// Método exemplo1 que cria objetos da classe Pessoa e interage com eles
		exemplo1();
	}

	// Método exemplo1 que cria objetos da classe Pessoa e interage com eles
	public static void exemplo1() {
		// Cria um objeto Pessoa chamado pedro com nome "Pedro" e idade 24
		Pessoa pedro = new Pessoa("Pedro", 24);

		// Cria um objeto Pessoa chamado sofia com nome "Sofia" e idade 32
		Pessoa sofia = new Pessoa("Sofia", 32);

		// Imprime as informações de nome e idade da pessoa pedro
		System.out.println("A pessoa se chama " + pedro.getNome() + " e ela tem " + pedro.getIdade() + " anos.");

		// Atualiza a idade de pedro para 25
		pedro.setIdade(25);

		// Imprime novamente as informações de nome e idade da pessoa pedro após a
		// atualização da idade
		System.out.println("A pessoa se chama " + pedro.getNome() + " e ela tem " + pedro.getIdade() + " anos.");

		// Chama o método andar do objeto pedro
		pedro.andar();
	}
}
