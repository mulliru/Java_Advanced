package br.com.fiap.main;

import br.com.fiap.beans.Imovel;
import br.com.fiap.beans.NovoImovel;
import br.com.fiap.beans.VellhoImovel;

public class Teste {

    public static void main(String[] args) {
        // Criando uma instância de Imovel (classe base)
        Imovel imovel = new Imovel("Rua do Exemplo 123", 500000.00);
        System.out.println("Imovel:");
        imovel.printEndereco();
        imovel.printPreco();

        // Criando uma instância de NovoImovel e testando seus métodos
        NovoImovel novoImovel = new NovoImovel();
        novoImovel.calcPreco();
        novoImovel.EnderecoImovel(); // Chame o método com o nome original
        System.out.println("\nNovo Imovel:");
        novoImovel.printEndereco();
        novoImovel.printPreco();

        // Criando uma instância de VellhoImovel e testando seus métodos
        VellhoImovel vellhoImovel = new VellhoImovel();
        vellhoImovel.calcPreco();
        vellhoImovel.EnderecoImovel(); // Chame o método com o nome original
        System.out.println("\nVelho Imovel:");
        vellhoImovel.printEndereco();
        vellhoImovel.printPreco();
    }
}
