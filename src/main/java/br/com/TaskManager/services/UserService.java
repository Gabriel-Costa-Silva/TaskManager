package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.UsuarioSignupRequest;
import br.com.TaskManager.entities.User;
import br.com.TaskManager.repositories.UserRepository;
import org.springframework.stereotype.Service;

public class UserService {

    @Service
    public class UsuarioService {

        public void signup(UsuarioSignupRequest request, UsuarioRepository repository) {
            User usuario = new User(
                    request.getSenha(),
                    request.getLogin());

            repository.save(usuario);
        }
    }
}
