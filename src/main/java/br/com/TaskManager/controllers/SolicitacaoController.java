package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.request.SolicitacaoRequest;
import br.com.TaskManager.controllers.response.SolicitacaoResponse;
import br.com.TaskManager.services.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SolicitacaoController {

    @Autowired
    SolicitacaoService solicitacaoService;

    //getAll
    @GetMapping
    public ResponseEntity<List<SolicitacaoResponse>> getAllSolicitacaoResponse(){
        List<SolicitacaoResponse> listaSolicitacao = solicitacaoService.findAll();
        if(listaSolicitacao.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaSolicitacao, HttpStatus.ACCEPTED);
    }


    //findById
    @RequestMapping(value = "/{idSolicitacao}",method = RequestMethod.GET)
    ResponseEntity<SolicitacaoResponse> findSolicitacaoById(@RequestParam Long idSolicitacao){
        SolicitacaoResponse solicitacaoResponse = solicitacaoService.findSolicitacaoResponseById(idSolicitacao);
        if(solicitacaoResponse==null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(solicitacaoResponse,HttpStatus.ACCEPTED);
    }


    //save
    @PostMapping
    public ResponseEntity<String> postSolicitacao(@RequestBody SolicitacaoRequest request) {

        try{
            solicitacaoService.save(request);
            return new ResponseEntity<>("Solicitacao salva com sucesso", HttpStatus.ACCEPTED);

        }
        catch(Exception e){
            return new ResponseEntity<>("Solicitacao não salva", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //delete
    @RequestMapping(value = "/{idSolicitacao}",method = RequestMethod.DELETE)
    public ResponseEntity<String>deleteSolicitacao(@RequestParam Long idSolicitacao){
        try{
            solicitacaoService.delete(idSolicitacao);
            return new ResponseEntity<>("Deletado com sucesso!",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Não foi possível deletar a Solicitacao",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //find by Usuario
    @RequestMapping(value="/Usuario/{idUsuario}",method = RequestMethod.GET)
    public ResponseEntity<List<SolicitacaoResponse>>findByUsuario(@RequestParam Long idUsuario){
        List<SolicitacaoResponse> listaSolicitacao = solicitacaoService.findByUsuarioId(idUsuario);
        if(listaSolicitacao.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaSolicitacao,HttpStatus.ACCEPTED);
    }

    //find by Departamento //IMPLEMENTAR
    @RequestMapping(value="/departamento/{id_departamento}",method = RequestMethod.GET)
    public ResponseEntity<List<SolicitacaoResponse>>findByDepartamento(@RequestParam Long id_departamento){
        List<SolicitacaoResponse> listaSolicitacao = solicitacaoService.findByDepartamentoId(id_departamento);
        if(listaSolicitacao.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaSolicitacao,HttpStatus.ACCEPTED);
    }

    @PutMapping(value="/{idSolicitacao}")
    public ResponseEntity<String>putSolicitacao(@PathVariable("idSolicitacao") Long idSolicitacao,@RequestBody SolicitacaoRequest solicitacaoRequest) {
        if (solicitacaoService.exists(idSolicitacao)) {
            try {
                solicitacaoService.put(idSolicitacao, solicitacaoRequest);
                return new ResponseEntity<>("Solicitacao salva com sucesso", HttpStatus.ACCEPTED);

            } catch (Exception e) {
                return new ResponseEntity<>("erro,solicitacao não salva", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>("Usuario não encontrado", HttpStatus.NOT_FOUND);

    }


}
