package br.com.TaskManager.controllers;

public class SolicitacaoController {


    SolicitacaoService solicitacaoService;

    //getAll
    @GetMapping
    public ResponseEntity<List<SolicitacaoResponse>> getAllSolicitacaoResponse(){
        List<SolicitacaoResponse> listaSolicitacao = solicitacaoService.findAll();
        if(listaSolicitacao.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaSolicitacao,HttpStatus.ACCEPTED);
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
    public ResponseEntity<List<SolicitacaoResponse>>findByDepartamento(@RequestParam int id_departamento){
        List<SolicitacaoResponse> listaSolicitacao = solicitacaoService.findByTipoSolicitacao(id_departamento);
        if(listaSolicitacao.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaSolicitacao,HttpStatus.ACCEPTED);
    }

}
