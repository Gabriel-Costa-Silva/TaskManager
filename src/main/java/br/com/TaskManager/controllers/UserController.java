package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.response.UserLogged;
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

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signin") //se cadastrar
    public ResponseEntity<String> signin(@RequestBody UsuarioSignupRequest request) {

        UserLogged usuario = userService.getUser(request);
        if (usuario.equals(null)) {
            userService.save(request);
            return new ResponseEntity<>("Cadastro realizado com scesso", HttpStatus.ACCEPTED);

        }
        return new ResponseEntity<>("Usuario não encontrado", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/signup") //se logar
    public ResponseEntity<UserLogged> signup(@RequestBody UsuarioSignupRequest request) {
        UserLogged userLogged = userService.getUser(request);
        if(!userLogged.equals(null)) {
            return new ResponseEntity<UserLogged>(userLogged,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<UserLogged>(new UserLogged(Long.parseLong("0"), request.getLogin(), request.getSenha()), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signout") //se deslogar
    public ResponseEntity<String> signout(@RequestBody UserLogged userLogged){

        return new ResponseEntity<String>("Usuario deslogado",HttpStatus.ACCEPTED);
    }


}

//    TODO - implemenetar endpoints de usuário

//    @PutMapping("/esqueci-senha")

//    @DeleteMapping()

    //POST	/api/auth/signup	signup new account
    //POST	/api/auth/signin	login an account
    //POST	/api/auth/signout	logout the account

