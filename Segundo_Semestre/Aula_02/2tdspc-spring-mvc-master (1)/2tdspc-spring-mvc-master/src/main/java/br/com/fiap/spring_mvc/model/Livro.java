package br.com.fiap.spring_mvc.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_livro")
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Column(name = "preco")
    @Enumerated(EnumType.STRING)
    private Preco preco;
}
