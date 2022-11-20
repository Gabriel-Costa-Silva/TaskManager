package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.FuncaoRequest;
import br.com.TaskManager.controllers.response.FuncaoResponse;
import br.com.TaskManager.entities.Funcao;
import br.com.TaskManager.repositories.FuncaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncaoService {

    @Autowired
    FuncaoRepository funcaoRepository;
    public List<FuncaoResponse> findAll() {
        List<Funcao> listaFuncao = funcaoRepository.findAll();
        List<FuncaoResponse> listaFuncaoResponse = new ArrayList<>();
        try {
            for (Funcao funcao : listaFuncao) {
                listaFuncaoResponse.add(new FuncaoResponse(
                   funcao.getId_funcao(),
                    funcao.getDs_funcao(),
                    funcao.getDepartamento().getId_departamento()
                ));
            }
        }catch(Exception e){
            return listaFuncaoResponse;
        }
        return listaFuncaoResponse;

    }

    public FuncaoResponse findFuncaoById(Long idFuncao) {
        FuncaoResponse funcaoResponse = new FuncaoResponse();

        try{
            Optional<Funcao> funcao = funcaoRepository.findById(idFuncao);
            if(funcao.isPresent()) {
                 funcaoResponse = new FuncaoResponse(funcao.get().getId_funcao(),
                        funcao.get().getDs_funcao(),
                        funcao.get().getDepartamento().getId_departamento());
            }

        }catch(Exception e)
        {
            return null;
        }
        return funcaoResponse;
    }

    public void save(FuncaoRequest request) throws Exception{
        funcaoRepository.save(new Funcao(request.getFuncao(),request.getId_departamento()));
    }

    public void delete(Long idFuncao) throws Exception{
        funcaoRepository.deleteById(idFuncao);
    }

    public List<FuncaoResponse> findByDepartamentoId(Long idDepartamento) {
        List<Funcao> listaFuncao = funcaoRepository.findByDepartamentoId(idDepartamento);
        List<FuncaoResponse> listaFuncaoResponse = new ArrayList<>();
        try {
            for (Funcao funcao : listaFuncao) {
                listaFuncaoResponse.add(new FuncaoResponse(
                        funcao.getId_funcao(),
                        funcao.getDs_funcao(),
                        funcao.getDepartamento().getId_departamento()
                ));
            }
        }catch(Exception e){
            return listaFuncaoResponse;
        }
        return listaFuncaoResponse;

    }


}
