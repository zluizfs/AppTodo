package br.edu.unipam.service;

import br.edu.unipam.entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioService {
    
    @PersistenceContext(name = "pu_todo")
    private EntityManager entityManager;
    
    public Usuario salvarUsuario(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }
    
    
}
