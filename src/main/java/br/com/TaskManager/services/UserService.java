package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.UsuarioSignupRequest;
import br.com.TaskManager.controllers.response.UserLogged;
import br.com.TaskManager.entities.Users;
import br.com.TaskManager.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    public UserLogged getUser(UsuarioSignupRequest request ) {
        Optional<Users> user = userRepository.findUsersByNomeAndSenha(request.getLogin(), request.getSenha());

        if(user.isPresent())
            return new UserLogged(user.get().getId(), user.get().getNome(), user.get().getSenha());
        return null;
    }

    @Transactional
    public Users save(UsuarioSignupRequest request) {
        return userRepository.save(new Users(request.getLogin(),request.getSenha()));
    }

    public boolean exists (Long id) {
        try {
            return userRepository.existsById(id);
        }catch(Exception e){
            logger.error("Erro ao verificar usuário");
            return false;
        }
    }


}
