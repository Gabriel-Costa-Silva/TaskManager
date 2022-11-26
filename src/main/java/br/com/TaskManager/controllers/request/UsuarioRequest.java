package br.com.TaskManager.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRequest {
    @JsonProperty
    private String nm_usuario ;

    @JsonProperty
    private Long funcao_id;

    @JsonProperty
    private Long departamento_id;

    @JsonProperty
    private int tipo_usuario;
}
