package br.com.fiap.spring_mvc.model;

import java.math.BigDecimal;

public class Livro {
    private String titulo;
    private String autor;
    private Categoria categoria;
    private BigDecimal preco; // Alterado de double para BigDecimal
    private String isbn;

    // Construtor vazio
    public Livro() {
    }

    // Construtor com parâmetros
    public Livro(String titulo, String autor, Categoria categoria, BigDecimal preco, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.preco = preco;
        this.isbn = isbn;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() { // Alterado para BigDecimal
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPreco(BigDecimal preco) { // Alterado para BigDecimal
        this.preco = preco;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Método toString() para facilitar a depuração
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria=" + categoria +
                ", preco=" + preco +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
