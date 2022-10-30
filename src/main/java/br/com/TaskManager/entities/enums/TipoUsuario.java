package br.com.TaskManager.entities.enums;

public enum TipoUsuario {
    ADMIN (1),
    USUARIO (2);

    public final int usuario;

    TipoUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getUsuario() {
        return usuario;
    }
}
