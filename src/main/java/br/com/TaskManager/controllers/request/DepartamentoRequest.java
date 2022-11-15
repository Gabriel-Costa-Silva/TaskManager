package br.com.TaskManager.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartamentoRequest {

    @JsonProperty
    private String departamento;

}
