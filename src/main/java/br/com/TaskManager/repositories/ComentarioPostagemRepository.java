package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.ComentarioPostagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComentarioPostagemRepository extends JpaRepository<ComentarioPostagem, Long> {
    @Query("select p from ComentarioPostagem p where p.id_postagem = :id_postagem")
    List<ComentarioPostagem> findAllByPostagemId(@Param("id_postagem")Long idPostagem);
    @Query("select p from ComentarioPostagem p where p.id_Usuario = :id_Usuario")
    List<ComentarioPostagem> findAllbyUsuarioId(@Param("id_usuario")Long idUsuario);
}