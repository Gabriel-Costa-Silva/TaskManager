package br.com.TaskManager.entities.enums;

import javax.persistence.*;

public enum Prioridade {
    URGENTE (1),
    NAO_URGENTE (2);

    public final int prioridade;

    Prioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }
}
