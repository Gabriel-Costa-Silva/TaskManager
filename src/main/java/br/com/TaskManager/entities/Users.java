package br.com.TaskManager.entities;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false, unique = true)
    private String senha;

    public Users()
    {

    }
    public Users(String nome, String senha){
        this.nome = nome;
        this.senha =senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String user) {
        this.nome = user;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
