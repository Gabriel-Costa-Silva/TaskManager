package br.com.TaskManager.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_departamento;

    @Column(nullable = false, unique = true)
    private String ds_departamento;

}
