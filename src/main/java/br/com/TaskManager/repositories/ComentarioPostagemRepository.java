package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.ComentarioPostagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioPostagemRepository extends JpaRepository<ComentarioPostagem, Long> {
}