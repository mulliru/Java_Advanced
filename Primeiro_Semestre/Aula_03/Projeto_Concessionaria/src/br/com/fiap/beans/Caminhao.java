package br.com.fiap.beans;

public class Caminhao extends Veiculo {

    @Override
    public void calcPreco() {
        // Definindo um preço fixo para a moto
        this.preco = 100000;
    }

}
