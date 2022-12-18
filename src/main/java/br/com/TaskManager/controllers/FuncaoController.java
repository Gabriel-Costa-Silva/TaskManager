package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.request.ComentarioSolicitacaoRequest;
import br.com.TaskManager.controllers.request.FuncaoRequest;
import br.com.TaskManager.controllers.request.PostagemRequest;
import br.com.TaskManager.controllers.response.ComentarioSolicitacaoResponse;
import br.com.TaskManager.controllers.response.FuncaoResponse;
import br.com.TaskManager.services.ComentarioSolicitacaoService;
import br.com.TaskManager.services.FuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/funcao")
public class FuncaoController {

    @Autowired
    FuncaoService funcaoService;

    //getAll
    @GetMapping
    public ResponseEntity<List<FuncaoResponse>> getAllComentarioSolicitacaoResponse(){
        List<FuncaoResponse> listaFuncoes = funcaoService.findAll();
        if(listaFuncoes.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaFuncoes,HttpStatus.ACCEPTED);
    }


    //findById
    @RequestMapping(value = "/{idFuncao}",method = RequestMethod.GET)
    ResponseEntity<FuncaoResponse> findFuncaoById(@RequestParam Long idFuncao){
        FuncaoResponse funcaoResponse = funcaoService.findFuncaoResponseById(idFuncao);
        if(funcaoResponse==null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FuncaoResponse>(funcaoResponse,HttpStatus.ACCEPTED);
    }


    //save
    @PostMapping
    public ResponseEntity<String> postFuncao(@RequestBody FuncaoRequest request) {

        try{
            funcaoService.save(request);
            return new ResponseEntity<>("Funcao postado com sucesso", HttpStatus.ACCEPTED);

        }
        catch(Exception e){
            return new ResponseEntity<>("Funcao não salva", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //delete
    @RequestMapping(value = "/{idFuncao}",method = RequestMethod.DELETE)
    public ResponseEntity<String >deleteFuncao(@RequestParam Long idFuncao){
        try{
            funcaoService.delete(idFuncao);
            return new ResponseEntity<>("Deletado com sucesso!",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Não foi possível deletar a postagem",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //find by departamento
    @RequestMapping(value="/departamento/{idDepartamento}",method = RequestMethod.GET)
    public ResponseEntity<List<FuncaoResponse>>findByDepartamentoId(@RequestParam Long idDepartamento){
        List<FuncaoResponse> listaFuncoes = funcaoService.findByDepartamentoId( idDepartamento);
        if(listaFuncoes.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaFuncoes,HttpStatus.ACCEPTED);
    }

    @PutMapping(value="/{idFuncao}")
    public ResponseEntity<String>putFuncao(@PathVariable("idFuncao") Long idFuncao,@RequestBody FuncaoRequest funcaoRequest) {
        if (funcaoService.exists(idFuncao)) {
            try {
                funcaoService.put(idFuncao, funcaoRequest);
                return new ResponseEntity<>("Funcao salva com sucesso", HttpStatus.ACCEPTED);

            } catch (Exception e) {
                return new ResponseEntity<>("erro,funcao não salva", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>("Funcao não encontrada", HttpStatus.NOT_FOUND);

    }


}
