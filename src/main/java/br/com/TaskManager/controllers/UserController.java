package br.com.TaskManager.controllers;

import br.com.TaskManager.entities.User;
import br.com.TaskManager.controllers.request.UsuarioSignupRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UsuarioSignupRequest request){
        Optional<User> usuario = repository.findByUser(new User(request.getLogin(),request.getSenha()));
        if(usuario.isPresent()){
            return new ResponseEntity<>("Usuario jÃ¡ possui cadastro",HttpStatus.BAD_REQUEST);
        }
        service.signup(request.getLogin(), request.getSenha());
        return new ResponseEntity<>("Cadastro realizado com scesso", HttpStatus.CREATED);
    }

//    @GetMapping("/login")
//    @PutMapping("/esqueci-senha")
//    @DeleteMapping()
}