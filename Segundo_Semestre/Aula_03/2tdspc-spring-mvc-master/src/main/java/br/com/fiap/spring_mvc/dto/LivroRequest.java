package br.com.fiap.spring_mvc.dto;

import br.com.fiap.spring_mvc.model.Categoria;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LivroRequest {
        @NotBlank(message = "{titulo.not.blank}")
        private String titulo;
        @NotBlank(message = "{autor.not.blank}")
        @Size(min = 4, max = 150, message = "{autor.size}")
        private String autor;
        @NotNull(message = "{categoria.not.null}")
        private Categoria categoria;
        @DecimalMin(value = "0.99", message = "{preco.min}")
        private BigDecimal preco;
        @Pattern(regexp = "^970\\d{7}$|^970\\d{10}$", message = "{isbn.pattern}")
        private String isbn;
}
