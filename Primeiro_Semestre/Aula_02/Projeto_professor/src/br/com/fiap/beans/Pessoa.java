package br.com.fiap.beans;

public class Pessoa {

    // Visibilidade + tipo de dado + nome da variável
    private String nome;
    private int idade;

    // Construtor vazio
    public Pessoa() {
        super();
    }

    // Construtor cheio
    public Pessoa(String nome, int idade) {
        super();
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método para simular a ação de andar
    public void andar() {
        System.out.println("A pessoa está andando.");
    }
}
