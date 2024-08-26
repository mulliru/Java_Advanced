package br.com.fiap.model;

import br.com.fiap.anotation.Coluna;
import br.com.fiap.anotation.Tabela;

@Tabela(nome = "TAB_PESSOA")
public class Pessoa {

	@Coluna(nome = "nm_pessoa", obrigatorio = true, tamanho = 100)
	private String nome;
	
	@Coluna(nome = "nr_idade", obrigatorio = true)
	private String idade;

	@Coluna(nome = "vl_altura")
	private float altura;
	
	public void andar() {
		System.out.println("Pessoa andando");
	}

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	
}