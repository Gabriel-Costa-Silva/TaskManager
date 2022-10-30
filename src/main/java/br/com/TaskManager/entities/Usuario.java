package br.com.TaskManager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Funcao")
public class Usuario implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_usuario;

    @Column(nullable = false,unique = false)
    private String nm_usuario ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcao", referencedColumnName = "id_funcao")
    private Funcao funcao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private Departamento departamento;

    @Column(nullable = false, unique = false)
    private int tipo_usuario;

}
