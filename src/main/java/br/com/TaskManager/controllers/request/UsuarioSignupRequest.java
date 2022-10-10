package br.com.TaskManager.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioSignupRequest {

    @JsonProperty
    private String login;
    @JsonProperty
    private String senha;

    public UsuarioSignupRequest(){}

    public UsuarioSignupRequest(String login, String senha) {
        this.login = login ;
        this.senha = senha;

    }
    public String getLogin()
    {
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
