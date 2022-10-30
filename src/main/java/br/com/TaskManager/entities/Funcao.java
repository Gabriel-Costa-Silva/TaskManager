package br.com.TaskManager.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Funcao")
public class Funcao implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_funcao;

    @Column(nullable = false, unique = false)
    private String ds_funcao;

    @Column(nullable = false,unique = false)
    private Long id_departamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private Departamento departamento;

}
