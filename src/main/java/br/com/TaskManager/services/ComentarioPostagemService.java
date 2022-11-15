package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.ComentarioPostagemRequest;
import br.com.TaskManager.controllers.response.ComentarioPostagemResponse;
import br.com.TaskManager.entities.ComentarioPostagem;
import br.com.TaskManager.entities.Postagem;
import br.com.TaskManager.entities.Usuario;
import br.com.TaskManager.repositories.ComentarioPostagemRepository;
import br.com.TaskManager.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ComentarioPostagemService {

    @Autowired
    ComentarioPostagemRepository comentarioPostagemRepository;

    PostagemService postagemService;

    UsuarioService usuarioService;

    public List<ComentarioPostagemResponse> findAll() {
        List<ComentarioPostagemResponse>  listaComentarioResponse = new ArrayList<>();
        List<ComentarioPostagem> listaComentario = new ArrayList<>();
        try {
            listaComentario = comentarioPostagemRepository.findAll();
        }catch(Exception e){
            return listaComentarioResponse;
        }
        for(ComentarioPostagem comentarioPostagem : listaComentario){
            listaComentarioResponse.add(new ComentarioPostagemResponse(
                    comentarioPostagem.getId_comentario_postagem() ,
                    comentarioPostagem.getPostagem().getId_postagem(),
                    comentarioPostagem.getTxt_comentario_postagem(),
                    comentarioPostagem.getUsuario().getId_usuario(),
                    comentarioPostagem.getDt_criacao_comentario_postagem(),
                    comentarioPostagem.getDt_ultima_atualizacao_comentario_postagem()
                    ));
        }

        return listaComentarioResponse;
    }

    public ComentarioPostagemResponse findComentrariopostagemById(Long idComentarioPostagem) {
        try{
            Optional<ComentarioPostagem> comentarioPostagem = comentarioPostagemRepository.findById(idComentarioPostagem);
            if(comentarioPostagem.isPresent()){
                return  new ComentarioPostagemResponse(
                        comentarioPostagem.get().getId_comentario_postagem() ,
                        comentarioPostagem.get().getPostagem().getId_postagem(),
                        comentarioPostagem.get().getTxt_comentario_postagem(),
                        comentarioPostagem.get().getUsuario().getId_usuario(),
                        comentarioPostagem.get().getDt_criacao_comentario_postagem(),
                        comentarioPostagem.get().getDt_ultima_atualizacao_comentario_postagem()
                );
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    public void save(ComentarioPostagemRequest request) throws Exception {

        Usuario usuario = usuarioService.findById(request.getIdUsuario());
        Postagem postagem = postagemService.findById(request.getIdPostagem());

        comentarioPostagemRepository.save(new ComentarioPostagem(
                request.getIdPostagem(),
                postagem,
                request.getTxt_comentario_postagem(),
                usuario,
                request.getDt_criacao_comentario_postagem(),
                request.getDt_ultima_atualizacao_comentario_postagem()));

    }

    public void delete(Long idComentarioPostagem) throws Exception{
        comentarioPostagemRepository.deleteById(idComentarioPostagem);
    }

    public List<ComentarioPostagemResponse> findByPostagemId(Long idPostagem) {
        List<ComentarioPostagemResponse>  listaComentarioResponse = new ArrayList<>();
        List<ComentarioPostagem> listaComentario = new ArrayList<>();
        try {
            listaComentario = comentarioPostagemRepository.findAllByPostagemId(idPostagem);
        }catch(Exception e){
            return listaComentarioResponse;
        }
        for(ComentarioPostagem comentarioPostagem : listaComentario){
            listaComentarioResponse.add(new ComentarioPostagemResponse(
                    comentarioPostagem.getId_comentario_postagem() ,
                    comentarioPostagem.getPostagem().getId_postagem(),
                    comentarioPostagem.getTxt_comentario_postagem(),
                    comentarioPostagem.getUsuario().getId_usuario(),
                    comentarioPostagem.getDt_criacao_comentario_postagem(),
                    comentarioPostagem.getDt_ultima_atualizacao_comentario_postagem()
            ));
        }

        return listaComentarioResponse;

    }

    public List<ComentarioPostagemResponse> findByUsuarioId(Long idUsuario) {
        List<ComentarioPostagemResponse>  listaComentarioResponse = new ArrayList<>();
        List<ComentarioPostagem> listaComentario;
        try {
            listaComentario = comentarioPostagemRepository.findAllbyUsuarioId(idUsuario);
        }catch(Exception e){
            return listaComentarioResponse;
        }
        for(ComentarioPostagem comentarioPostagem : listaComentario){
            listaComentarioResponse.add(new ComentarioPostagemResponse(
                    comentarioPostagem.getId_comentario_postagem() ,
                    comentarioPostagem.getPostagem().getId_postagem(),
                    comentarioPostagem.getTxt_comentario_postagem(),
                    comentarioPostagem.getUsuario().getId_usuario(),
                    comentarioPostagem.getDt_criacao_comentario_postagem(),
                    comentarioPostagem.getDt_ultima_atualizacao_comentario_postagem()
            ));
        }

        return listaComentarioResponse;
    }
}
