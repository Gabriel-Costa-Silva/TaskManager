package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.request.ComentarioPostagemRequest;
import br.com.TaskManager.controllers.response.ComentarioPostagemResponse;
import br.com.TaskManager.services.ComentarioPostagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/comentariopostagem")
public class ComentarioPostagemController {

    ComentarioPostagemService comentarioPostagemService;

    //getAll
    @GetMapping
    public ResponseEntity<List<ComentarioPostagemResponse>> getAllComentarioPostagemResponse(){
        List<ComentarioPostagemResponse> listaComentarios = comentarioPostagemService.findAll();
        if(listaComentarios.isEmpty())
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaComentarios,HttpStatus.ACCEPTED);
    }


    //findById
    @RequestMapping(value = "/{idComentarioPostagem}",method = RequestMethod.GET)
    ResponseEntity<ComentarioPostagemResponse> findComentrariopostagemById(@RequestParam Long  idComentarioPostagem){
        ComentarioPostagemResponse comentarioPostagemResponse = comentarioPostagemService.findComentrariopostagemById(idComentarioPostagem);
        if(comentarioPostagemResponse==null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ComentarioPostagemResponse>(comentarioPostagemResponse,HttpStatus.ACCEPTED);
    }


    //save
    @PostMapping
    public ResponseEntity<String> postComentarioPostagem(@RequestBody ComentarioPostagemRequest request) {

        try{
            comentarioPostagemService.save(request);
            return new ResponseEntity<>("Comentario postado com sucesso", HttpStatus.ACCEPTED);

        }
        catch(Exception e){
            return new ResponseEntity<>("Comentario não salvo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //delete
    @RequestMapping(value = "/{idComentarioPostagem}",method = RequestMethod.DELETE)
    public ResponseEntity<String >deleteComentarioPostagem(@RequestParam Long idComentarioPostagem){
        try{
            comentarioPostagemService.delete(idComentarioPostagem);
            return new ResponseEntity<>("Deletado com sucesso!",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Não foi possível deletar a postagem",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //find by postagem
    @RequestMapping(value="/postagem/{idPostagem}",method = RequestMethod.GET)
    public ResponseEntity<List<ComentarioPostagemResponse>>findByPostagem(@RequestParam Long idPostagem){
        List<ComentarioPostagemResponse> listaComentarios = comentarioPostagemService.findByPostagemId( idPostagem);
        if(listaComentarios.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaComentarios,HttpStatus.ACCEPTED);
    }

    //find by user
    @RequestMapping(value="/postagem/{idUsuario}",method = RequestMethod.GET)
    public ResponseEntity<List<ComentarioPostagemResponse>>findByUser(@RequestParam Long idUsuario){
        List<ComentarioPostagemResponse> listaComentarios = comentarioPostagemService.findByUsuarioId( idUsuario);
        if(listaComentarios.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaComentarios,HttpStatus.ACCEPTED);
    }

}
