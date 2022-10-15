package br.com.TaskManager.controllers;

import br.com.TaskManager.repositories.UserRepository;
import br.com.TaskManager.services.UserService;
import br.com.TaskManager.entities.Users;
import br.com.TaskManager.controllers.request.UsuarioSignupRequest;


import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }



    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UsuarioSignupRequest request){
        //Optional<User> usuario = repository.findById(Long.parseLong(request.getLogin()));
       Optional<Users> usuario = userService.getUser(request);
        if(usuario.isPresent()){
            return new ResponseEntity<>("Usuario jÃ¡ possui cadastro",HttpStatus.BAD_REQUEST);
        }
        /*
        service.save(request);
        */

        return new ResponseEntity<>("Cadastro realizado com scesso", HttpStatus.CREATED);

    }
//    TODO - implemenetar endpoints de usuário
//    @GetMapping("/login")
//    @PutMapping("/esqueci-senha")
//    @DeleteMapping()
}