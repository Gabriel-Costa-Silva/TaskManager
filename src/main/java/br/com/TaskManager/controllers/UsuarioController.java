package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.request.FuncaoRequest;
import br.com.TaskManager.controllers.request.UsuarioRequest;
import br.com.TaskManager.controllers.response.FuncaoResponse;
import br.com.TaskManager.controllers.response.UsuarioResponse;
import br.com.TaskManager.entities.Usuario;
import br.com.TaskManager.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    //get
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAllUsuario(){
        List<UsuarioResponse> listaUsuario = usuarioService.findAll();
        if(listaUsuario.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaUsuario,HttpStatus.ACCEPTED);
    }
    //findById
    @RequestMapping(value = "/{idUser}",method = RequestMethod.GET)
    ResponseEntity<UsuarioResponse> findFuncaoById(@RequestParam Long idUser){
        UsuarioResponse usuarioResponse  = usuarioService.findUsuarioRequestById(idUser);
        if(usuarioResponse==null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UsuarioResponse>(usuarioResponse,HttpStatus.ACCEPTED);
    }
    //save
    @PostMapping
    public ResponseEntity<String> postUsuario(@RequestBody UsuarioRequest request) {

        try{
            usuarioService.save(request);
            return new ResponseEntity<>("Comentario postado com sucesso", HttpStatus.ACCEPTED);

        }
        catch(Exception e){
            return new ResponseEntity<>("Comentario não salvo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //delete
    @RequestMapping(value = "/{idUsuario}",method = RequestMethod.DELETE)
    public ResponseEntity<String >deletePostagem(@RequestParam Long idUsuario){
        try{
            usuarioService.delete(idUsuario);
            return new ResponseEntity<>("Deletado com sucesso!",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Não foi possível deletar a postagem",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody UsuarioRequest userRequest) {
        Usuario updateUser = usuarioService.findById(id);
        if(updateUser==null){
            return new ResponseEntity<>( "User não encontrado!",HttpStatus.NOT_FOUND);
        }
        try{
            usuarioService.put(id,userRequest);
        }catch (Exception e ){
            return new ResponseEntity<>("Usuario não salvo corretamente",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( "usuario salvo!",HttpStatus.ACCEPTED);

    }
}
