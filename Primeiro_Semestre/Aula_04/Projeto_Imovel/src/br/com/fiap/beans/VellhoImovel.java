package br.com.fiap.beans;


public class VellhoImovel extends Imovel{
	@Override

	public void calcPreco() {
		this.preco = 950.000;
	}

	public void EnderecoImovel() {
		this.endereco = "Avenida Paulista 902";
	}
	
}
