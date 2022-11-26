package br.com.TaskManager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Solicitacao")
public class Solicitacao implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_solicitacao;

    @Column(nullable = false, unique = false)
    private Long id_tipo_solicitacao;

    @Column(nullable = false, unique = false)
    private Long id_st_solicitacao;

    @Column(nullable = false, unique = false)
    private String ds_titulo_solicitacao;

    @Column(nullable = false, unique = false)
    private String txt_solicitacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private Departamento departamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario; //id_solicitante_solicitacao

    @Column(nullable = false, unique = false)
    private Long id_responsavel_solicitacao;

    @Column(nullable = false, unique = false)
    private Long id_prioridade;

    @Column(nullable = false, unique = false)
    private Date dt_registro_solicitacao;

    @Column(nullable = false, unique = false)
    private Date dt_ultima_atualizacao_solicitacao;

    @Column(nullable = false, unique = false)
    private Date dt_fechamento_solicitacao;


}
