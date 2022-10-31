package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
}