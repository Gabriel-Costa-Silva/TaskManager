package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.ComentarioPostagem;
import br.com.TaskManager.entities.ComentarioSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComentarioSolicitacaoRepository extends JpaRepository<ComentarioSolicitacao, Long> {

    @Query("select p from ComentarioSolicitacao p where id_solicitacao = :id_solicitacao")
    List<ComentarioSolicitacao> findAllBySolicitacaoId(@Param("id_solicitacao")Long id_solicitacao);
    @Query("select p from ComentarioSolicitacao p where id_usuario = :id_usuario")
    List<ComentarioSolicitacao> findAllByUsuarioId(@Param("id_usuario")Long id_usuario);
}