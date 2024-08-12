package br.com.fiap.main;

import br.com.fiap.beans.Carro;
import br.com.fiap.beans.Moto;
import br.com.fiap.beans.Caminhao;

public class Heranca {

	public static void main(String[] args) {
		// Dados do carro
		Carro c = new Carro();
		c.setMarca("Volvo");
		c.setModelo("X6");
		c.setCor("preto");
		c.calcPreco();
		c.printMarca();
		c.printModelo();
		c.printCor();
		c.printPreco();

		// Dados da moto
		Moto m = new Moto();
		m.setMarca("Honda");
		m.setModelo("CB500");
		m.setCor("vermelho");
		m.calcPreco();
		m.printMarca();
		m.printModelo();
		m.printCor();
		m.printPreco();

		// Dados do caminhão
		Caminhao cam = new Caminhao();
		cam.setMarca("Scania");
		cam.setModelo("R440");
		cam.setCor("azul");
		cam.calcPreco();
		cam.printMarca();
		cam.printModelo();
		cam.printCor();
		cam.printPreco();
	}
}
