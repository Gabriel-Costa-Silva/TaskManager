package br.com.TaskManager.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLogged {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String login;
    @JsonProperty
    private String senha;

    public UserLogged(Long id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
