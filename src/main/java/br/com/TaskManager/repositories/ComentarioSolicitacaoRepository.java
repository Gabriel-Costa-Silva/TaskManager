package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.ComentarioSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioSolicitacaoRepository extends JpaRepository<ComentarioSolicitacao, Long> {
}