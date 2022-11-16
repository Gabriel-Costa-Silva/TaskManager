package br.com.TaskManager.controllers;

import br.com.TaskManager.controllers.request.DepartamentoRequest;
import br.com.TaskManager.entities.Departamento;
import br.com.TaskManager.services.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/departamento ")
public class DepartamentoController {
    DepartamentoService departamentoService;

    //get
    @GetMapping
    ResponseEntity<List<Departamento>> getDepartamentos() {
        List<Departamento> departamentos = departamentoService.findDepartamentos();
        if(departamentos.isEmpty())
        {
            return new ResponseEntity<>(null,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<List<Departamento>>(departamentos,HttpStatus.ACCEPTED);
    }

    //findById
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
        Departamento departamento = departamentoService.findDepartamentoById(id);
        if (departamento.equals(null)) {
            return null;
        }
        return new ResponseEntity<>(departamento,HttpStatus.ACCEPTED);
    }
    //save
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createDepartamento(@RequestBody DepartamentoRequest departamentoRequest) {
        try {
            departamentoService.saveDepartamento(departamentoRequest);
            return  new ResponseEntity<>("Salvo com sucesso",HttpStatus.ACCEPTED);
        }catch(Exception e ) {
            return new ResponseEntity<>("Não salvo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDepartamento(@PathVariable Long id){
        try{
            departamentoService.deleteDepartamento(id);
            return new ResponseEntity<>("Apagado com sucesso",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Houve um erro", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
