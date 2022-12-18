package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.request.FuncaoRequest;
import br.com.TaskManager.controllers.request.PostagemRequest;
import br.com.TaskManager.controllers.request.SolicitacaoRequest;
import br.com.TaskManager.controllers.response.FuncaoResponse;
import br.com.TaskManager.controllers.response.PostagemResponse;
import br.com.TaskManager.services.FuncaoService;
import br.com.TaskManager.services.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PostagemController {
    @Autowired
    PostagemService postagemService;

    //getAll
    @GetMapping
    public ResponseEntity<List<PostagemResponse>> getAllComentarioSolicitacaoResponse(){
        List<PostagemResponse> listaPostagens = postagemService.findAll();
        if(listaPostagens.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaPostagens,HttpStatus.ACCEPTED);
    }


    //findById
    @RequestMapping(value = "/{idPostagem}",method = RequestMethod.GET)
    ResponseEntity<PostagemResponse> findPostagemById(@RequestParam Long idPostagem){
        PostagemResponse postagemResponse = postagemService.findPostagemResponseById(idPostagem);
        if(postagemResponse==null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(postagemResponse,HttpStatus.ACCEPTED);
    }


    //save
    @PostMapping
    public ResponseEntity<String> postPostagem(@RequestBody PostagemRequest request) {

        try{
            postagemService.save(request);
            return new ResponseEntity<>("Postagem salva com sucesso", HttpStatus.ACCEPTED);

        }
        catch(Exception e){
            return new ResponseEntity<>("Postagem não salva", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //delete
    @RequestMapping(value = "/{idPostagem}",method = RequestMethod.DELETE)
    public ResponseEntity<String >deletePostagem(@RequestParam Long idPostagem){
        try{
            postagemService.delete(idPostagem);
            return new ResponseEntity<>("Deletado com sucesso!",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Não foi possível deletar a postagem",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //find by Usuario
    @RequestMapping(value="/Usuario/{idUsuario}",method = RequestMethod.GET)
    public ResponseEntity<List<PostagemResponse>>findByUsuario(@RequestParam Long idUsuario){
        List<PostagemResponse> listaPostagem = postagemService.findByUsuarioId(idUsuario);
        if(listaPostagem.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaPostagem,HttpStatus.ACCEPTED);
    }

    //find by tipoSolicitacao
    @RequestMapping(value="/tiposolicitacao/{tipo_solicitacao}",method = RequestMethod.GET)
    public ResponseEntity<List<PostagemResponse>>findByTipoSolicitacao(@RequestParam Long tipo_solicitacao){
        List<PostagemResponse> listaPostagem = postagemService.findByTipoSolicitacao(tipo_solicitacao);
        if(listaPostagem.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaPostagem,HttpStatus.ACCEPTED);
    }

    @PutMapping(value="/{idPostagem}")
    public ResponseEntity<String>putPostagem(@PathVariable("idPostagem") Long idPostagem,@RequestBody PostagemRequest postagemRequest) {
        if (postagemService.exists(idPostagem)) {
            try {
                postagemService.put(idPostagem, postagemRequest);
                return new ResponseEntity<>("Postagem salva com sucesso", HttpStatus.ACCEPTED);

            } catch (Exception e) {
                return new ResponseEntity<>("erro,postagem não salva", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>("Postagem não encontrada", HttpStatus.NOT_FOUND);

    }

}
