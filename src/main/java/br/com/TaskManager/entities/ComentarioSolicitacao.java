package br.com.TaskManager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@Table(name = "Postagem")
@NoArgsConstructor
public class ComentarioSolicitacao implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_comentario_solicitacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_solicitacao", referencedColumnName = "id_solicitacao")
    private Solicitacao solicitacao;

    @Column(nullable = false, unique = false)
    private String txt_comentario_solicitacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @Column(nullable = false, unique = false)
    private Date dt_criacao_comentario_solicitacao;

    @Column(nullable = false, unique = false)
    private Date dt_ultima_atualizacao_comentario_solicitacao;


}
