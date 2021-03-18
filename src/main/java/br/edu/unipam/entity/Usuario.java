package br.edu.unipam.entity;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = Usuario.GET_ALL_USERS, query = "select u from Usuario u order by u.nome")
public class Usuario extends AbstractEntity {
    
    public static final String GET_ALL_USERS = "Usuario.getAllUsers";

    private String nome;
    private String email;
    
    @OneToMany(mappedBy = "usuario")
    private Collection<Tarefa> tarefas;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
