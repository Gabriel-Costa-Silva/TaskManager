package br.com.TaskManager.controllers.request;

import br.com.TaskManager.entities.Postagem;
import br.com.TaskManager.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ComentarioPostagemRequest {

    @JsonProperty
    private long idPostagem;

    @JsonProperty
    private String txt_comentario_postagem;

    @JsonProperty
    private long idUsuario;

    @JsonProperty
    private Date dt_criacao_comentario_postagem;

    @JsonProperty
    private Date dt_ultima_atualizacao_comentario_postagem;
}
