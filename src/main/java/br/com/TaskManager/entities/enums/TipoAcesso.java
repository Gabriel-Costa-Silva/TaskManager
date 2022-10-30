package br.com.TaskManager.entities.enums;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public enum TipoAcesso
{
    PUBLICO (1),
    RESTRITO (2);

    public final int acesso;

    TipoAcesso(int acesso) {
        this.acesso = acesso;
    }

    public int getAcesso() {
        return acesso;
    }
}
