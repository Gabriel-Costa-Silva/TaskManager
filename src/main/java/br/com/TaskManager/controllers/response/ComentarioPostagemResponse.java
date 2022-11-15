package br.com.TaskManager.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
@Data
public class ComentarioPostagemResponse {

    @JsonProperty
    private Long id_comentario_postagem;

    @JsonProperty
    private Long id_postagem;

    @JsonProperty
    private String txt_comentario_postagem;

    @JsonProperty
    private Long id_usuario;

    @JsonProperty
    private Date dt_criacao_comentario_postagem;

    @JsonProperty
    private Date dt_ultima_atualizacao_comentario_postagem;

}
