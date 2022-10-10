package br.com.TaskManager.repositories;

import br.com.TaskManager.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<String, String> {
    Optional<User> findByUser(User user);
    void save(User user);

}
