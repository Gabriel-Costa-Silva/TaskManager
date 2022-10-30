package br.com.TaskManager.entities.enums;

public enum StatusSolicitacao {

    CRIADO (1),
    ATENDIDO (2),
    FECHADO (3);

    public final int status;

    StatusSolicitacao(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
