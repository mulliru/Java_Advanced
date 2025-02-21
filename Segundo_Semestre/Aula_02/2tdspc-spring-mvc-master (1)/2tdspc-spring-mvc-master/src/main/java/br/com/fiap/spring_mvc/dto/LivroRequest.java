package br.com.fiap.spring_mvc.dto;

import br.com.fiap.spring_mvc.model.Categoria;

import java.math.BigDecimal;


public record LivroRequest {
    @NotBlank(message = "O título é obrigatório")
     String titulo,
    @NotBlank(message = "O autor é obrigatório")
            @size(min = 4, message = "O autor deve ter no mínimo 4 caracteres")
     String autor,
    @NotNull(message = "A categoria é obrigatória")
     Categoria categoria,
    @DecimalMin(value = "0.99", message = "O preço deve ser no mínimo 0.99")
     BigDecimal preco,
    @pattern(regexp = "^970\\d{7}$|^970\\d{10}$", message = "O ISBN deve começar com 970 e ter 10 ou 13 dígitos")
     String isbn,
    ) {

}
