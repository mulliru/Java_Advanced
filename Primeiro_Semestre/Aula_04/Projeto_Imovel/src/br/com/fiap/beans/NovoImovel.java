package br.com.fiap.beans;


public class NovoImovel extends Imovel{
	@Override

	public void calcPreco() {
		this.preco = 45000;
	}

	public void EnderecoImovel() {
		this.endereco = "Avenida Paulista 902";
	}
	
}
