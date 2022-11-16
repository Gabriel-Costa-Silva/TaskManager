package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.request.ComentarioPostagemRequest;
import br.com.TaskManager.controllers.request.ComentarioSolicitacaoRequest;
import br.com.TaskManager.controllers.response.ComentarioPostagemResponse;
import br.com.TaskManager.controllers.response.ComentarioSolicitacaoResponse;
import br.com.TaskManager.services.ComentarioPostagemService;
import br.com.TaskManager.services.ComentarioSolicitacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/comentariosolicitacao")
public class ComentarioSolicitacaoController {

    ComentarioSolicitacaoService comentarioSolicitacaoService;

    //getAll
    @GetMapping
    public ResponseEntity<List<ComentarioSolicitacaoResponse>> getAllComentarioSolicitacaoResponse(){
        List<ComentarioSolicitacaoResponse> listaComentarios = comentarioSolicitacaoService.findAll();
        if(listaComentarios.isEmpty())
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaComentarios,HttpStatus.ACCEPTED);
    }


    //findById
    @RequestMapping(value = "/{idComentarioPostagem}",method = RequestMethod.GET)
    ResponseEntity<ComentarioSolicitacaoResponse> findComentrariopostagemById(@RequestParam Long  idComentarioPostagem){
        ComentarioSolicitacaoResponse comentarioSolicitacaoResponse = comentarioSolicitacaoService.findComentrariopostagemById(idComentarioPostagem);
        if(comentarioSolicitacaoResponse==null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ComentarioSolicitacaoResponse>(comentarioSolicitacaoResponse,HttpStatus.ACCEPTED);
    }


    //save
    @PostMapping
    public ResponseEntity<String> postComentarioPostagem(@RequestBody ComentarioSolicitacaoRequest request) {

        try{
            comentarioSolicitacaoService.save(request);
            return new ResponseEntity<>("Comentario postado com sucesso", HttpStatus.ACCEPTED);

        }
        catch(Exception e){
            return new ResponseEntity<>("Comentario não salvo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //delete
    @RequestMapping(value = "/{idComentarioSolicitacao}",method = RequestMethod.DELETE)
    public ResponseEntity<String >deleteComentarioPostagem(@RequestParam Long idComentarioSolicitacao){
        try{
            comentarioSolicitacaoService.delete(idComentarioSolicitacao);
            return new ResponseEntity<>("Deletado com sucesso!",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Não foi possível deletar a postagem",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //find by postagem
    @RequestMapping(value="/solicitacao/{idPostagem}",method = RequestMethod.GET)
    public ResponseEntity<List<ComentarioSolicitacaoResponse>>findBySolicitacao(@RequestParam Long idPostagem){
        List<ComentarioSolicitacaoResponse> listaComentarios = comentarioSolicitacaoService.findBySolicitacaoId( idPostagem);
        if(listaComentarios.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaComentarios,HttpStatus.ACCEPTED);
    }

    //find by user
    @RequestMapping(value="/usuario/{idUsuario}",method = RequestMethod.GET)
    public ResponseEntity<List<ComentarioSolicitacaoResponse>>findByUser(@RequestParam Long idUsuario){
        List<ComentarioSolicitacaoResponse> listaComentarios = comentarioSolicitacaoService.findByUsuarioId( idUsuario);
        if(listaComentarios.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaComentarios,HttpStatus.ACCEPTED);
    }

}
