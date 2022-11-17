package br.com.TaskManager.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostagemResponse {

    @JsonProperty
    private Long id_postagem;

    @JsonProperty
    private int tipo_solicitacao;

    @JsonProperty
    private String ds_titulo_postagem;

    @JsonProperty
    private String txt_postagem;

    @JsonProperty
    private Long id_usuario;

    @JsonProperty
    private Date dt_criacao_postagem;

    @JsonProperty
    private Date dt_ultima_atualizacao_postagem;



}
