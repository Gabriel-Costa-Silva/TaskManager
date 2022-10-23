package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Query(value = "SELECT * FROM user WHERE nome = nome and senha = senha")
    default Optional<Users> getUser(@Param("nome") String nome, @Param("senha") String senha) {
        return null;
    }
    //User save(User user);

}
