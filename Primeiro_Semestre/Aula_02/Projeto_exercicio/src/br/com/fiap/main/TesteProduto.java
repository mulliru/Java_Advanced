package br.com.fiap.main;

import br.com.fiap.beans.Produto;

public class TesteProduto {

    public static void main(String[] args) {
        // Criando objetos da classe Produto
    	//Tipo de produto, Marca, Preço e Peso
        Produto produto1 = new Produto("Celular", "Samsung", 1999.99, 0.2);
        Produto produto2 = new Produto("Notebook", "Dell", 3999.99, 1.5);
        Produto produto3 = new Produto("TV", "LG", 2999.99, 5.0);

        // Alterando os valores dos objetos criados
        produto1.setPreco(1799.99); // Mudando o preço do produto1
        produto2.setPeso(2.0); // Mudando o peso do produto2
        produto3.setMarca("Sony"); // Mudando a marca do produto3

        // Imprimindo as informações dos objetos alterados
        System.out.println("Produto 1 - Nome: " + produto1.getNome() + ", Marca: " + produto1.getMarca() + ", Preço: "
                + produto1.getPreco() + ", Peso: " + produto1.getPeso() + " kg");

        System.out.println("Produto 2 - Nome: " + produto2.getNome() + ", Marca: " + produto2.getMarca() + ", Preço: "
                + produto2.getPreco() + ", Peso: " + produto2.getPeso() + " kg");

        System.out.println("Produto 3 - Nome: " + produto3.getNome() + ", Marca: " + produto3.getMarca() + ", Preço: "
                + produto3.getPreco() + ", Peso: " + produto3.getPeso() + " kg");
    }
}
