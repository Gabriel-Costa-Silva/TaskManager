package br.com.TaskManager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
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


    public Postagem(int tipo_solicitacao, String ds_titulo_postagem, String txt_postagem, Usuario usuario, Date dt_criacao_postagem, Date dt_ultima_atualizacao_postagem) {
        this.tipo_solicitacao = tipo_solicitacao;
        this.ds_titulo_postagem = ds_titulo_postagem;
        this.txt_postagem = txt_postagem;
        this.usuario = usuario;
        this.dt_criacao_postagem = dt_criacao_postagem;
        this.dt_ultima_atualizacao_postagem = dt_ultima_atualizacao_postagem;
    }
}
