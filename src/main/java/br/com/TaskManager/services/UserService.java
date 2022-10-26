package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.UsuarioSignupRequest;
import br.com.TaskManager.entities.Users;
import br.com.TaskManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public Users getUser(UsuarioSignupRequest request ) {
       Users user = userRepository.findUsersByNomeAndSenha(request.getLogin(), request.getSenha());
       //Users user = users[0];
        if(user!=null)
            return user;
        return null;
    }
    /*
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

     */
}
