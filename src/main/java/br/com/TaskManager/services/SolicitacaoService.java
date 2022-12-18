package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.PostagemRequest;
import br.com.TaskManager.controllers.request.SolicitacaoRequest;
import br.com.TaskManager.controllers.response.ComentarioSolicitacaoResponse;
import br.com.TaskManager.controllers.response.PostagemResponse;
import br.com.TaskManager.controllers.response.SolicitacaoResponse;
import br.com.TaskManager.entities.*;
import br.com.TaskManager.repositories.ComentarioSolicitacaoRepository;
import br.com.TaskManager.repositories.PostagemRepository;
import br.com.TaskManager.repositories.SolicitacaoRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    Logger logger = LoggerFactory.getLogger(SolicitacaoService.class);

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    UsuarioService usuarioService;

    DepartamentoService departamentoService;

    public List<SolicitacaoResponse> findAll(){
        List<SolicitacaoResponse> listaSolicitacaoResponse = new ArrayList<>();
        List<Solicitacao> listaSolicitacao;
        try{
            listaSolicitacao =  solicitacaoRepository.findAll();
            for(Solicitacao solicitacao : listaSolicitacao){
                listaSolicitacaoResponse.add (new SolicitacaoResponse(
                        solicitacao.getId_solicitacao(),
                        solicitacao.getId_tipo_solicitacao(),
                        solicitacao.getId_st_solicitacao(),
                        solicitacao.getDs_titulo_solicitacao(),
                        solicitacao.getTxt_solicitacao(),
                        solicitacao.getDepartamento().getId_departamento(),
                        solicitacao.getUsuario().getId_usuario(),
                        solicitacao.getId_responsavel_solicitacao(),
                        solicitacao.getId_prioridade(),
                        solicitacao.getDt_registro_solicitacao(),
                        solicitacao.getDt_ultima_atualizacao_solicitacao(),
                        solicitacao.getDt_fechamento_solicitacao()
                ));
            }


        }catch(Exception e) {
            return listaSolicitacaoResponse;
        }
        return listaSolicitacaoResponse;
    }

    public SolicitacaoResponse findSolicitacaoResponseById(Long idSolicitacao){
        Optional<Solicitacao> solicitacao = solicitacaoRepository.findById(idSolicitacao);
        if(solicitacao.isEmpty())
            return null;
        return new SolicitacaoResponse(
                solicitacao.get().getId_solicitacao(),
                solicitacao.get().getId_tipo_solicitacao(),
                solicitacao.get().getId_st_solicitacao(),
                solicitacao.get().getDs_titulo_solicitacao(),
                solicitacao.get().getTxt_solicitacao(),
                solicitacao.get().getDepartamento().getId_departamento(),
                solicitacao.get().getUsuario().getId_usuario(),
                solicitacao.get().getId_responsavel_solicitacao(),
                solicitacao.get().getId_prioridade(),
                solicitacao.get().getDt_registro_solicitacao(),
                solicitacao.get().getDt_ultima_atualizacao_solicitacao(),
                solicitacao.get().getDt_fechamento_solicitacao()
        );

    }
    public void save(SolicitacaoRequest request)throws Exception{
        Departamento departamento = departamentoService.findDepartamentoById(request.getId_departamento());
        Usuario usuario = usuarioService.findById(request.getId_solicitante_solicitacao());
        Solicitacao solicitacao = new Solicitacao(
solicitacaoRepository.count()+1,
                request.getTipo_solicitacao(),
                request.getId_st_solicitacao(),
                request.getDs_titulo_solicitacao(),
                request.getTxt_solicitacao(),
                departamento,
                usuario,
                request.getId_responsavel_solicitacao(),
                request.getId_prioridade(),
                request.getDt_registro_solicitacao(),
                request.getDt_ultima_atualizacao_solicitacao(),
                request.getDt_fechamento_solicitacao()
        );
        solicitacaoRepository.save(solicitacao);
    }

    public void delete(Long solicitacaoId)throws Exception{
        solicitacaoRepository.deleteById(solicitacaoId);
    }
    public List<SolicitacaoResponse> findByUsuarioId(Long idUsuario){
        List<Solicitacao> listaSolicitacao = new ArrayList<>();
        List<SolicitacaoResponse> listaSolicitacaoResponse =  new ArrayList<>();
        try {
             listaSolicitacao = solicitacaoRepository.findByUsuarioId(idUsuario);
            if (listaSolicitacao.isEmpty()) {
                return null;
            }
            for(Solicitacao solicitacao : listaSolicitacao){
                listaSolicitacaoResponse.add(new SolicitacaoResponse(
                        solicitacao.getId_solicitacao(),
                        solicitacao.getId_tipo_solicitacao(),
                        solicitacao.getId_st_solicitacao(),
                        solicitacao.getDs_titulo_solicitacao(),
                        solicitacao.getTxt_solicitacao(),
                        solicitacao.getDepartamento().getId_departamento(),
                        solicitacao.getUsuario().getId_usuario(),
                        solicitacao.getId_responsavel_solicitacao(),
                        solicitacao.getId_prioridade(),
                        solicitacao.getDt_registro_solicitacao(),
                        solicitacao.getDt_registro_solicitacao(),
                        solicitacao.getDt_fechamento_solicitacao()
                ));
            }
        }catch(Exception e){
            return listaSolicitacaoResponse;
        }
        return listaSolicitacaoResponse;

    }
    public List<SolicitacaoResponse> findByDepartamentoId(Long idDepartamento){
        List<Solicitacao> listaSolicitacao = new ArrayList<>();
        List<SolicitacaoResponse> listaSolicitacaoResponse =  new ArrayList<>();
        try {
            listaSolicitacao = solicitacaoRepository.findByDepartamentoId(idDepartamento);
            if (listaSolicitacao.isEmpty()) {
                return null;
            }
            for(Solicitacao solicitacao : listaSolicitacao){
                listaSolicitacaoResponse.add(new SolicitacaoResponse(
                        solicitacao.getId_solicitacao(),
                        solicitacao.getId_tipo_solicitacao(),
                        solicitacao.getId_st_solicitacao(),
                        solicitacao.getDs_titulo_solicitacao(),
                        solicitacao.getTxt_solicitacao(),
                        solicitacao.getDepartamento().getId_departamento(),
                        solicitacao.getUsuario().getId_usuario(),
                        solicitacao.getId_responsavel_solicitacao(),
                        solicitacao.getId_prioridade(),
                        solicitacao.getDt_registro_solicitacao(),
                        solicitacao.getDt_registro_solicitacao(),
                        solicitacao.getDt_fechamento_solicitacao()
                ));
            }
        }catch(Exception e){
            return listaSolicitacaoResponse;
        }
        return listaSolicitacaoResponse;    }


    public Solicitacao findById(long idSolicitacao)throws Exception {
        Optional<Solicitacao>solicitacao =  solicitacaoRepository.findById(idSolicitacao);
        if(solicitacao.isEmpty()){
            return null;
        }
        return solicitacao.get();
    }

    public void put(Long idSolicitacao,SolicitacaoRequest solicitacaoRequest) {
    }

    public boolean exists (Long id) {
        try {
            return solicitacaoRepository.existsById(id);
        }catch(Exception e){
            logger.error("Erro ao verificar solicitacao");
            return false;
        }
    }
}
