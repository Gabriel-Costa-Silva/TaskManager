package br.com.TaskManager.controllers.dtos;

import javax.validation.constraints.NotBlank;


public class UserDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String senha;


}
