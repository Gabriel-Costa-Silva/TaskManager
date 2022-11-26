package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {

    //get
    @Query("select u from Users u where nome = :nome and senha = :senha")
    Optional<Users> findUsersByNomeAndSenha (@Param("nome") String nome, @Param("senha") String senha);
    @Query("select u from Users u where id = :id")
    Optional<Users> findUsersById(@Param("id") Long id);

    //post
    Users save(Users user);


    //put

    //delete

}
