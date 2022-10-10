package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.UsuarioSignupRequest;
import br.com.TaskManager.entities.User;
import br.com.TaskManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void signup(UsuarioSignupRequest request ) {
        User user = new User(
                request.getSenha(),
                request.getLogin());

        userRepository.save(user);
    }
}
