package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {
    @Query("select u from Users u where u.nome = :nome and u.senha = :senha")
    Users findUsersByNomeAndSenha (@Param("nome") String nome, @Param("senha") String senha);
    //User save(User user);

}
