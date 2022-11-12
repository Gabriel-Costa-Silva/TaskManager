package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.request.UsuarioSignupRequest;
import br.com.TaskManager.controllers.response.UserLogged;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/comentariopostagem")
public class ComentarioPostagemController {

    ComentarioPostagemService comentarioPostagemService;

    //get

    //findById

    //save
    @PostMapping
    public ResponseEntity<String> postComentarioPostagem(@RequestBody ComentarioPostagemRequest request) {

        try(
                comentarioPostagemService.save(request)) {
            return new ResponseEntity<>("Comentario postado com sucesso", HttpStatus.ACCEPTED);

        }
        catch(Exception e){
            return new ResponseEntity<>("Comentario não salvo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //delete

}
