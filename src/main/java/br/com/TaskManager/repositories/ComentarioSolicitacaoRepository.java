package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.ComentarioPostagem;
import br.com.TaskManager.entities.ComentarioSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComentarioSolicitacaoRepository extends JpaRepository<ComentarioSolicitacao, Long> {
    @Query("select p from ComentarioSolicitacao p where p.id_solicitacao = :id_solicitacao")
    List<ComentarioPostagem> findAllBySolicitacaoId(@Param("id_solicitacao")Long id_solicitacao);
    @Query("select p from ComentarioSolicitacao p where p.id_usuario = :id_usuario")
    List<ComentarioPostagem> findAllbyUsuarioId(@Param("id_usuario")Long idUsuario);
}