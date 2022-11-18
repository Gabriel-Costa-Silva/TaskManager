package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.PostagemRequest;
import br.com.TaskManager.controllers.response.ComentarioSolicitacaoResponse;
import br.com.TaskManager.controllers.response.PostagemResponse;
import br.com.TaskManager.entities.ComentarioSolicitacao;
import br.com.TaskManager.entities.Postagem;
import br.com.TaskManager.entities.Usuario;
import br.com.TaskManager.repositories.ComentarioSolicitacaoRepository;
import br.com.TaskManager.repositories.PostagemRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SolicitacaoService {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    public ResponseEntity<List<SolicitacaoResponse>> findAll(){
        return null;
    }

    public SolicitacaoResponse findSolicitacaoResponseById(Long idSolicitacao){
        return null;
    }
    public void save(SolicitacaoRequest request){
        return;
    }
    public void delete(Long solicitacaoId){
        return;
    }
    public List<SolicitacaoResponse> findByUsuarioId(Long idUsuario){
        return null;
    }
    public List<SolicitacaoResponse> findByDepartamentoId(Long idDepartamento){
        return null;
    }


}
