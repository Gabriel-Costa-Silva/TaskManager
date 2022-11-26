package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.ComentarioPostagem;
import br.com.TaskManager.entities.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
    @Query("select f from Funcao f where id_departamento = :id_departamento")
    List<Funcao> findByDepartamentoId(@Param("id_departamento")Long id_departamento);

}