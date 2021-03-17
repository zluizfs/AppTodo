package br.edu.unipam.service;

import br.edu.unipam.entity.Tarefa;
import br.edu.unipam.entity.Usuario;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TarefaService {
    @PersistenceContext(name = "pu_todo")
    private EntityManager entityManager;
    
    @Inject // Injeção de dependência
    private UsuarioService usuarioService;
    
    // Inserir
    public Tarefa salvar(Tarefa tarefa, Long id) {
        Usuario user = usuarioService.localizaPorId(id);
        if(user != null)
        {
            tarefa.setUsuario(user);
            entityManager.persist(tarefa);
        }
        return tarefa;
    }
    
    // Encontrar por ID
    public Tarefa localizarPorId(Long id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);
        if(tarefa != null) {
            entityManager.remove(tarefa);
        }
    }
    
    // Editar 
    public Tarefa localizarPorId(Long id) {
       Tarefa tarefaBd = localizarPorId(usuario.getId());
       if(tarefa == null) {
           return null;
       }
       
       Usuario userBd = UsuarioService.localizaPorId(id);
       
       if(userBd = null) {
           return null;
       }
       
       tarefa.setUsuario(userBd);
       entityManager.merge(tarefa);
       return tarefa;
    
    }
}
