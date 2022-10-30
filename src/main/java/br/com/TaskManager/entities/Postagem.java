package br.com.TaskManager.entities;

import br.com.TaskManager.entities.enums.TipoSolicitacao;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Postagem")
public class Postagem implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_postagem;

    @Column(nullable = false, unique = false)
    private int tipo_solicitacao;

    @Column(nullable = false, unique = false)
    private String ds_titulo_postagem;

    @Column(nullable = false, unique = false)
    private String txt_postagem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @Column(nullable = false, unique = false)
    private Date dt_criacao_postagem;

    @Column(nullable = false, unique = false)
    private Date dt_ultima_atualizacao_postagem;
}
