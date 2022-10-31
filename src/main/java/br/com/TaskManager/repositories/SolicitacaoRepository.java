package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}