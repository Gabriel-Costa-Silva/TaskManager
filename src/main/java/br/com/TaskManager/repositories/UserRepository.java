package br.com.TaskManager.repositories;

import br.com.TaskManager.controllers.dtos.UserDTO;

import br.com.TaskManager.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Query("SELECT * FROM user WHERE nome = nome and senha = senha")
    Optional<Users> getUser(@Param("nome") String nome,@Param("senha") String senha);
    //User save(User user);

}
