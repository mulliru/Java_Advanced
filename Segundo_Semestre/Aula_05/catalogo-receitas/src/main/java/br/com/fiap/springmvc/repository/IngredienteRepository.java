package br.com.fiap.springmvc.repository;

import br.com.fiap.springmvc.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
