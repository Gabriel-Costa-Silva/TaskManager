package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    @Query("select s from Solicitacao s where s.id_departamento = :id_departamento")
    List<Solicitacao> findByDepartamentoId(@Param("id_departamento")Long id_departamento);
    @Query("select s from Solicitacao s where p.id_usuario = :id_usuario")
    List<Solicitacao> findByUsuarioId(@Param("id_usuario")Long id_usuario);
}