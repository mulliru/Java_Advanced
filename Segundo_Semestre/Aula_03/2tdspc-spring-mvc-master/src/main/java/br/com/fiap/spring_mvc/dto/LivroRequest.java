package br.com.fiap.spring_mvc.dto;

import br.com.fiap.spring_mvc.model.Categoria;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class LivroRequest {
        @NotBlank(message = "O título é obrigatório")
        private String titulo;

        @NotBlank(message = "O autor é obrigatório")
        @Size(min = 4, max = 150, message = "O nome do autor deve ter entre 4 e 150 caracteres")
        private String autor;

        @NotNull(message = "A categoria é obrigatória")
        private Categoria categoria;

        @DecimalMin(value = "0.99", message = "O preço deve ser maior que R$ 0.99")
        private BigDecimal preco;

        @Pattern(regexp = "^970\\d{7}$|^970\\d{10}$", message = "O ISBN deve seguir o padrão internacional")
        private String isbn;

        // Construtor vazio
        public LivroRequest() {
        }

        // Construtor com parâmetros
        public LivroRequest(String titulo, String autor, Categoria categoria, BigDecimal preco, String isbn) {
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

        public BigDecimal getPreco() {
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

        public void setPreco(BigDecimal preco) {
                this.preco = preco;
        }

        public void setIsbn(String isbn) {
                this.isbn = isbn;
        }

        // Método toString() para facilitar a depuração
        @Override
        public String toString() {
                return "LivroRequest{" +
                        "titulo='" + titulo + '\'' +
                        ", autor='" + autor + '\'' +
                        ", categoria=" + categoria +
                        ", preco=" + preco +
                        ", isbn='" + isbn + '\'' +
                        '}';
        }
}
