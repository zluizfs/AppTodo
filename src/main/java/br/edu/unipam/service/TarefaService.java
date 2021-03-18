package br.edu.unipam.service;

import br.edu.unipam.entity.Tarefa;
import br.edu.unipam.entity.Usuario;
import java.util.List;
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
        Usuario user = usuarioService.localizarPorId(id);
        
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
           
        return null;
    }
    
    // Editar 
    public Tarefa localizarPorId(Tarefa tarefa, Long id) {
       Tarefa tarefaBd = localizarPorId(tarefa.getId());
       
       if(tarefa == null) {
           return null;
       }
       
       Usuario userBd = usuarioService.localizarPorId(id);
       
       if(userBd == null) {
           return null;
       }
       
       tarefa.setUsuario(userBd);
       entityManager.merge(tarefa);
       return tarefa;
    }
    
    // Remover 
    public void remover(Long id) {
        Tarefa tarefa = localizarPorId(id);
        if(tarefa != null) {
            entityManager.remove(tarefa);
        }
    }
    
    // Localizar tarefas
    public List<Tarefa> listar(){
        return entityManager.createQuery("select t from Tarefa t order by t.Descricao", Tarefa.class).getResultList();
    }
    
    // Localizar tarefas por usuário
    public List<Tarefa> listarPorUsuario(Long id){
        Usuario user = usuarioService.localizarPorId(id);
        return entityManager.createQuery("select t from Tarefa t where t.usuario = :user", Tarefa.class)
            .setParameter("user", user)
            .getResultList();
    }
}
