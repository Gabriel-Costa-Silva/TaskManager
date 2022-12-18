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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    Logger logger = LoggerFactory.getLogger(PostagemService.class);

    @Autowired
    PostagemRepository postagemRepository;

    UsuarioService usuarioService;

    public List<PostagemResponse> findAll() {
        List<PostagemResponse> listaPostagemResponse = new ArrayList<>();
        List<Postagem> listaPostagem = new ArrayList<>();
        try {
            listaPostagem = postagemRepository.findAll();
        } catch (Exception e) {
            return listaPostagemResponse;
        }
        for (Postagem postagem : listaPostagem) {
            listaPostagemResponse.add(new PostagemResponse(
                    postagem.getId_postagem(),
                    postagem.getTipo_solicitacao(),
                    postagem.getDs_titulo_postagem(),
                    postagem.getTxt_postagem(),
                    postagem.getUsuario().getId_usuario(),
                    postagem.getDt_criacao_postagem(),
                    postagem.getDt_ultima_atualizacao_postagem()
            ));
        }

        return listaPostagemResponse;
    }

    public Postagem findPostagemById(Long idPostagem) {
        Optional<Postagem> postagem = postagemRepository.findById(idPostagem);
        if (postagem.isEmpty()) {
            return null;
        }
        return postagem.get();
    }

    public PostagemResponse findPostagemResponseById(Long idPostagem) {
        Optional<Postagem> postagem = postagemRepository.findById(idPostagem);
        if (postagem.isEmpty()) {
            return null;
        }
        return new PostagemResponse(
                postagem.get().getId_postagem(),
                postagem.get().getTipo_solicitacao(),
                postagem.get().getDs_titulo_postagem(),
                postagem.get().getTxt_postagem(),
                postagem.get().getUsuario().getId_usuario(),
                postagem.get().getDt_criacao_postagem(),
                postagem.get().getDt_ultima_atualizacao_postagem());
    }

    public void save(PostagemRequest request) throws Exception {
        Usuario usuario = usuarioService.findById(request.getId_usuario());
        postagemRepository.save(new Postagem(
                request.getTipo_solicitacao(),
                request.getDs_titulo_postagem(),
                request.getTxt_postagem(),
                usuario,
                request.getDt_criacao_postagem(),
                request.getDt_ultima_atualizacao_postagem()
        ));
    }

    public void delete(Long idPostagem) throws Exception {
        postagemRepository.deleteById(idPostagem);
    }

    public List<PostagemResponse> findByUsuarioId(Long idUsuario) {
        List<PostagemResponse> listaPostagemResponse = new ArrayList<>();
        List<Postagem> listaPostagem;
        try {
            listaPostagem = postagemRepository.findAllByUsuarioId(idUsuario);
        } catch (Exception e) {
            return listaPostagemResponse;
        }
        for (Postagem postagem : listaPostagem) {

            listaPostagemResponse.add(new PostagemResponse(
                    postagem.getId_postagem(),
                    postagem.getTipo_solicitacao(),
                    postagem.getDs_titulo_postagem(),
                    postagem.getTxt_postagem(),
                    postagem.getUsuario().getId_usuario(),
                    postagem.getDt_criacao_postagem(),
                    postagem.getDt_ultima_atualizacao_postagem()
            ));
        }

        return listaPostagemResponse;

    }


    public List<PostagemResponse> findByTipoSolicitacao(Long id_tipo_solicitacao) {
        List<PostagemResponse> listaPostagemResponse = new ArrayList<>();
        List<Postagem> listaPostagem;
        try {
            listaPostagem = postagemRepository.findByTipoSolicitacao(id_tipo_solicitacao);
        } catch (Exception e) {
            return listaPostagemResponse;
        }
        for (Postagem postagem : listaPostagem) {

            listaPostagemResponse.add(new PostagemResponse(
                    postagem.getId_postagem(),
                    postagem.getTipo_solicitacao(),
                    postagem.getDs_titulo_postagem(),
                    postagem.getTxt_postagem(),
                    postagem.getUsuario().getId_usuario(),
                    postagem.getDt_criacao_postagem(),
                    postagem.getDt_ultima_atualizacao_postagem()
            ));
        }

        return listaPostagemResponse;

    }

    public boolean exists(Long id) {
        try {
            return postagemRepository.existsById(id);
        } catch (Exception e) {
            logger.error("Erro ao verificar postagem");
            return false;
        }


    }

    public void put(Long idPostagem, PostagemRequest postagemRequest)throws Exception  {
        Postagem postagem = findPostagemById(idPostagem);
        postagem.setDs_titulo_postagem(postagemRequest.getDs_titulo_postagem());
        postagem.setDt_criacao_postagem(postagemRequest.getDt_criacao_postagem());
        postagem.setTxt_postagem(postagemRequest.getTxt_postagem());
        postagem.setDt_ultima_atualizacao_postagem(postagemRequest.getDt_ultima_atualizacao_postagem());
        postagem.setTipo_solicitacao(postagemRequest.getTipo_solicitacao());
        postagem.setUsuario(usuarioService.findById(postagemRequest.getId_usuario()));
        postagemRepository.save(postagem);

    }
}
