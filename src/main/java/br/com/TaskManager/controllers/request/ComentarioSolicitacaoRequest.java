package br.com.TaskManager.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ComentarioSolicitacaoRequest {

    @JsonProperty
    private long idSolicitacao;

    @JsonProperty
    private String txt_comentario_solicitacao;

    @JsonProperty
    private long idUsuario;

    @JsonProperty
    private Date dt_criacao_comentario_solicitacao;

    @JsonProperty
    private Date dt_ultima_atualizacao_comentario_solicitacao;
}
