package br.com.TaskManager.entities.enums;

import javax.persistence.*;


public enum TipoSolicitacao {
    INFRAESTRUTURA (1),
    INCIDENTE (2);

    public final int solicitacao;

    TipoSolicitacao(int solicitacao) {
        this.solicitacao = solicitacao;
    }

    public int getSolicitacao() {
        return solicitacao;
    }

}
