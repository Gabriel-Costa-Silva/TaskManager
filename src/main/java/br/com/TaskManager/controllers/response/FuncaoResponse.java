package br.com.TaskManager.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncaoResponse {

    @JsonProperty
    private Long id_funcao;

    @JsonProperty
    private String txt_departamento;

    @JsonProperty
    private Long id_departamento;


}

