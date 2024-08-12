package br.com.fiap.main;

import br.com.fiap.beans.Analista;
import br.com.fiap.beans.Engenheiro;
import br.com.fiap.beans.Estagiario;
import br.com.fiap.beans.Gerente;

public class Heranca {

	public static void main(String[] args) {
		//Dados do Gerente
		Gerente g = new Gerente();
		g.setNome("Muillo");
		g.pritNome();
		g.calcSalario();
		g.printSalario();

		//Dados do Engenheiro
		Engenheiro e = new Engenheiro();
		e.setNome("pedro");
		e.pritNome();
		e.calcSalario();
		e.printSalario();

		//Dados do Analista
		Analista a = new Analista();
		a.setNome("Larissa");
		a.pritNome();
		a.calcSalario();
		a.printSalario();

		//Dados do Estagiario
		Estagiario estag = new Estagiario();
		estag.setNome("Lucas");
		estag.pritNome();
		estag.calcSalario();
		estag.printSalario();

	}

}
