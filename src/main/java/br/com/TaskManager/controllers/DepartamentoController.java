package br.com.TaskManager.controllers;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {
    DepartamentoService departamentoService;
    //get
    @GetMapping
    List<Departamento> getDepartamentos(){
        departamentoService.getDepartamentos();
    }

    //findById
    @GetMapping()
    Departamento getDepartamentoById(){

    }s

    //save

    //delete
}
