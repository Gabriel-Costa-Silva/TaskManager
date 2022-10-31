package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}