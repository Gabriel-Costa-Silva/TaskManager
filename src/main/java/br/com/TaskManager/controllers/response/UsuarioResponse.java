package br.com.TaskManager.controllers.response;

import br.com.TaskManager.entities.Departamento;
import br.com.TaskManager.entities.Funcao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioResponse {

    @JsonProperty
    private Long id_usuario;

    @JsonProperty
    private String nm_usuario ;

    @JsonProperty
    private Long funcao_id;

    @JsonProperty
    private Long departamento_id;

    @JsonProperty
    private int tipo_usuario;


}
