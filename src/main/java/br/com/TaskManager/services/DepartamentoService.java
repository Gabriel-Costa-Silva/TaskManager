package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.DepartamentoRequest;
import br.com.TaskManager.controllers.request.UsuarioSignupRequest;
import br.com.TaskManager.controllers.response.UserLogged;
import br.com.TaskManager.entities.Departamento;
import br.com.TaskManager.entities.Users;
import br.com.TaskManager.repositories.DepartamentoRepository;
import br.com.TaskManager.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    Logger logger = LoggerFactory.getLogger(DepartamentoService.class);


    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<Departamento> findDepartamentos(){
        return departamentoRepository.findAll();
    }
    public Departamento findDepartamentoById(Long id){
         Optional<Departamento> optional = departamentoRepository.findById(id);
         if(optional.isPresent()){
             return optional.get();
         }
         return null;
    }

    public void saveDepartamento(DepartamentoRequest departamentoRequest)throws  Exception{

        departamentoRepository.save(new Departamento(null,departamentoRequest.getDepartamento()));
    }
    public void deleteDepartamento(Long id) throws Exception{
        departamentoRepository.deleteById(id);
    }
    public boolean exists (Long id) {
        try {
            return departamentoRepository.existsById(id);
        } catch (Exception e) {
            logger.error("Erro ao verificar se departamento existe");
            return false;
        }


    }

}
