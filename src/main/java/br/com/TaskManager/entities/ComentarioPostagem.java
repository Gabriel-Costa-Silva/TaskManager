package br.com.TaskManager.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Postagem")
public class ComentarioPostagem implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_comentario_postagem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_postagem", referencedColumnName = "id_postagem")
    private Postagem postagem;

    @Column(nullable = false, unique = false)
    private String txt_comentario_postagem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @Column(nullable = false, unique = false)
    private Date dt_criacao_comentario_postagem;

    @Column(nullable = false, unique = false)
    private Date dt_ultima_atualizacao_comentario_postagem;
}
