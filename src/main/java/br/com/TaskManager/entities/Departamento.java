package br.com.TaskManager.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_departamento;

    @Column(nullable = false, unique = true)
    private String ds_departamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Departamento that = (Departamento) o;
        return id_departamento != null && Objects.equals(id_departamento, that.id_departamento);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
