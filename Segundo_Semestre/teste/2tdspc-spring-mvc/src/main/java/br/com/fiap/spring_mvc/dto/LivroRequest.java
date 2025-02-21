package br.com.fiap.spring_mvc.dto;

import br.com.fiap.spring_mvc.model.Categoria;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
public class LivroRequest{
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
}
