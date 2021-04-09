package br.edu.unipam.resource;

import br.edu.unipam.entity.Usuario;
import br.edu.unipam.service.UsuarioService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usuario") //dominio/contextPath/api/v1/Usuario
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject 
    private UsuarioService usuarioService;
    
    @GET
    @Path("list") //dominio/contextPath/api/v1/usuario/list
    public Response listarTodos(){
       List<Usuario> userList = usuarioService.listarTodos();
       return Response.ok(userList).build(); 
    }
    
    @POST
    @Path("new") //localhost/appTodo/api/v1/usuario/new
    public Response salvarUsuario(Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return Response.ok(usuarioSalvo).build();
    }
    
    
}
