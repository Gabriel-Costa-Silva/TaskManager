package br.com.TaskManager.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoResponse {

    @JsonProperty
    private Long id_solicitacao;

    @JsonProperty
    private Long  tipo_solicitacao;

    @JsonProperty
    private Long id_st_solicitacao;

    @JsonProperty
    private String ds_titulo_solicitacao;

    @JsonProperty
    private String txt_solicitacao;

    @JsonProperty
    private Long id_departamento;

    @JsonProperty
    private Long id_solicitante_solicitacao;

    @JsonProperty
    private Long id_responsavel_solicitacao;

    @JsonProperty
    private Long id_prioridade;

    @JsonProperty
    private Date dt_registro_solicitacao;

    @JsonProperty
    private Date dt_ultima_atualizacao_solicitacao;

    @JsonProperty
    private Date dt_fechamento_solicitacao;



}

