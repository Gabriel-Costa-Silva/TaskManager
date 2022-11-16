package br.com.TaskManager.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FuncaoRequest {

    @JsonProperty
    private String funcao;

    @JsonProperty
    private Long id_departamento;

}
