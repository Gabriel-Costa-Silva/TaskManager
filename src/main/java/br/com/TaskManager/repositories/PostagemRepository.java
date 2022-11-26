package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.Funcao;
import br.com.TaskManager.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    @Query("select p from Postagem p where id_usuario = :id_usuario")
    List<Postagem> findAllByUsuarioId(@Param("id_usuario")Long id_usuario);

    @Query("select p from Postagem p where tipo_solicitacao = :tipo_solicitacao")
    List<Postagem> findByTipoSolicitacao(@Param("tipo_solicitacao")Long tipo_solicitacao);

}