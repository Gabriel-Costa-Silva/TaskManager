package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.ComentarioSolicitacaoRequest;
import br.com.TaskManager.controllers.response.ComentarioPostagemResponse;
import br.com.TaskManager.controllers.response.ComentarioSolicitacaoResponse;
import br.com.TaskManager.entities.*;
import br.com.TaskManager.repositories.ComentarioSolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComentarioSolicitacaoService {

    SolicitacaoService solicitacaoService;

    UsuarioService usuarioService;

    @Autowired
    ComentarioSolicitacaoRepository comentarioSolicitacaoRepository;

    public List<ComentarioSolicitacaoResponse> findAll() {
        List<ComentarioSolicitacaoResponse>  listaComentarioResponse = new ArrayList<>();
        List<ComentarioSolicitacao> listaComentario ;
        try {
            listaComentario = comentarioSolicitacaoRepository.findAll();
        }catch(Exception e){
            return listaComentarioResponse;
        }
        for(ComentarioSolicitacao comentarioPostagem : listaComentario){
            listaComentarioResponse.add(new ComentarioSolicitacaoResponse(
                    comentarioPostagem.getId_comentario_solicitacao() ,
                    comentarioPostagem.getSolicitacao().getId_solicitacao(),
                    comentarioPostagem.getTxt_comentario_solicitacao(),
                    comentarioPostagem.getUsuario().getId_usuario(),
                    comentarioPostagem.getDt_criacao_comentario_solicitacao(),
                    comentarioPostagem.getDt_ultima_atualizacao_comentario_solicitacao()
            ));
        }

        return listaComentarioResponse;
    }



    public ComentarioSolicitacaoResponse findComentrariopostagemById(Long idComentarioPostagem) {
        try{
            Optional<ComentarioSolicitacao> comentarioPostagem = comentarioSolicitacaoRepository.findById(idComentarioPostagem);
            if(comentarioPostagem.isPresent()){
                return  new ComentarioSolicitacaoResponse(
                        comentarioPostagem.get().getId_comentario_solicitacao(),
                        comentarioPostagem.get().getSolicitacao().getId_solicitacao(),
                        comentarioPostagem.get().getTxt_comentario_solicitacao(),
                        comentarioPostagem.get().getUsuario().getId_usuario(),
                        comentarioPostagem.get().getDt_criacao_comentario_solicitacao(),
                        comentarioPostagem.get().getDt_ultima_atualizacao_comentario_solicitacao()
                );
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    public void save(ComentarioSolicitacaoRequest request)throws Exception {
        Usuario usuario = usuarioService.findById(request.getIdUsuario());
        Solicitacao solicitacao = solicitacaoService.findById(request.getIdSolicitacao());

        comentarioSolicitacaoRepository.save(new ComentarioSolicitacao(
                request.getIdSolicitacao(),
                solicitacao,
                request.getTxt_comentario_solicitacao(),
                usuario,
                request.getDt_criacao_comentario_solicitacao(),
                request.getDt_ultima_atualizacao_comentario_solicitacao()));
    }

    public void delete(Long idComentarioSolicitacao) {
        comentarioSolicitacaoRepository.deleteById(idComentarioSolicitacao);
    }

    public List<ComentarioSolicitacaoResponse> findBySolicitacaoId(Long idSolicitacao) {
        List<ComentarioSolicitacaoResponse>  listaSolicitacaoResponse = new ArrayList<>();
        List<ComentarioSolicitacao> listaComentarioSolicitacao;
        try {
            listaComentarioSolicitacao = comentarioSolicitacaoRepository.findAllBySolicitacaoId(idSolicitacao);
        }catch(Exception e){
            return listaSolicitacaoResponse;
        }
        for(ComentarioSolicitacao comentarioSolicitacao : listaComentarioSolicitacao){

            listaSolicitacaoResponse.add(new ComentarioSolicitacaoResponse(
                    comentarioSolicitacao.getId_comentario_solicitacao() ,
                    comentarioSolicitacao.getSolicitacao().getId_solicitacao(),
                    comentarioSolicitacao.getTxt_comentario_solicitacao(),
                    comentarioSolicitacao.getUsuario().getId_usuario(),
                    comentarioSolicitacao.getDt_criacao_comentario_solicitacao(),
                    comentarioSolicitacao.getDt_ultima_atualizacao_comentario_solicitacao()
            ));
        }

        return listaSolicitacaoResponse;

    }

    public List<ComentarioSolicitacaoResponse> findByUsuarioId(Long idUsuario) {
        List<ComentarioSolicitacaoResponse>  listaSolicitacaoResponse = new ArrayList<>();
        List<ComentarioSolicitacao> listaComentarioSolicitacao;
        try {
            listaComentarioSolicitacao = comentarioSolicitacaoRepository.findAllByUsuarioId(idUsuario);
        }catch(Exception e){
            return listaSolicitacaoResponse;
        }
        for(ComentarioSolicitacao comentarioSolicitacao : listaComentarioSolicitacao){

            listaSolicitacaoResponse.add(new ComentarioSolicitacaoResponse(
                    comentarioSolicitacao.getId_comentario_solicitacao() ,
                    comentarioSolicitacao.getSolicitacao().getId_solicitacao(),
                    comentarioSolicitacao.getTxt_comentario_solicitacao(),
                    comentarioSolicitacao.getUsuario().getId_usuario(),
                    comentarioSolicitacao.getDt_criacao_comentario_solicitacao(),
                    comentarioSolicitacao.getDt_ultima_atualizacao_comentario_solicitacao()
            ));
        }

        return listaSolicitacaoResponse;
    }
}
