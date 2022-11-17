package br.com.TaskManager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private Departamento departamento;


    public Funcao(String funcao, Long id_departamento) {
    }
}
