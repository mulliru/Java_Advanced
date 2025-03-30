package br.com.fiap.springmvc.repository;

import br.com.fiap.springmvc.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
