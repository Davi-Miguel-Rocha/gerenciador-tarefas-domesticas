package com.meuProjeto.gerenciador_tarefas.Controller;


import com.meuProjeto.gerenciador_tarefas.Entity.Usuario;
import com.meuProjeto.gerenciador_tarefas.Service.ServiceUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ServiceUsuario serviceUsuario;

    public UsuarioController(ServiceUsuario serviceUsuario) {

        this.serviceUsuario = serviceUsuario;
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){

        return serviceUsuario.criarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorID(@PathVariable Long id){

        return serviceUsuario.buscarUsuario(id);
    }

    @GetMapping()
    public List<Usuario> buscarTodosUsuarios(){

        return serviceUsuario.buscarTodosUsuarios();
    }


    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){

        return serviceUsuario.atualizarUsuario(id, usuarioAtualizado);
    }


    @DeleteMapping("/{id}")
    public void deletarUsuarioPorID(@PathVariable Long id){

        serviceUsuario.deletarUsuario(id);
    }
}
