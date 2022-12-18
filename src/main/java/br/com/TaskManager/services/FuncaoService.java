package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.FuncaoRequest;
import br.com.TaskManager.controllers.response.FuncaoResponse;
import br.com.TaskManager.entities.Funcao;
import br.com.TaskManager.repositories.FuncaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncaoService {

    Logger logger = LoggerFactory.getLogger(FuncaoService.class);

    @Autowired
    FuncaoRepository funcaoRepository;

    DepartamentoService departamentoService;


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
        } catch (Exception e) {
            return listaFuncaoResponse;
        }
        return listaFuncaoResponse;

    }

    public FuncaoResponse findFuncaoResponseById(Long idFuncao) {
        FuncaoResponse funcaoResponse = new FuncaoResponse();

        try {
            Funcao funcao = getFuncaoById( idFuncao);
                if (funcao != null) {
                    funcaoResponse = new FuncaoResponse(
                            funcao.getId_funcao(),
                            funcao.getDs_funcao(),
                            funcao.getDepartamento().getId_departamento());
                }

            } catch(Exception e){
            logger.error("ERRO AO PROCURAR A FUNÇÃO ESPERADA");
                return null;
            }
            return funcaoResponse;
        }


    public void save(FuncaoRequest request) throws Exception {
        funcaoRepository.save(new Funcao(request.getFuncao(), request.getId_departamento()));
    }

    public void delete(Long idFuncao) throws Exception {
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
        } catch (Exception e) {
            return listaFuncaoResponse;
        }
        return listaFuncaoResponse;

    }

    Funcao getFuncaoById(Long funcaoId) {
        try {
            Optional<Funcao> funcao = funcaoRepository.findById(funcaoId);
            if (funcao.isPresent()) {
                return funcao.get();
            }
            return null;
        }
        catch(Exception e){
            logger.error("erro ao buscar funcao");
            return null;

        }

    }

    public boolean exists(Long id) {
        try {
            return funcaoRepository.existsById(id);
        } catch (Exception e) {
            logger.error("Erro ao verificar se funcao existe ");
            return false;
        }


    }

    public void put(Long idFuncao, FuncaoRequest funcaoRequest) throws Exception {
        Funcao funcao = getFuncaoById(idFuncao);
        funcao.setDs_funcao(funcaoRequest.getFuncao());
        funcao.setDepartamento(departamentoService.findDepartamentoById(funcaoRequest.getId_departamento()));
        funcaoRepository.save(funcao);
    }
}
