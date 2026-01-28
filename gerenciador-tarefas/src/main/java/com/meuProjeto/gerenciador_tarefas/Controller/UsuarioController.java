package com.meuProjeto.gerenciador_tarefas.Controller;


import com.meuProjeto.gerenciador_tarefas.Entity.NivelAcesso;
import com.meuProjeto.gerenciador_tarefas.Entity.Usuario;
import com.meuProjeto.gerenciador_tarefas.Service.ServiceUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ServiceUsuario serviceUsuario;

    public UsuarioController(ServiceUsuario serviceUsuario) {

        this.serviceUsuario = serviceUsuario;
    }

    @PostMapping("/criar")
    public Usuario criarUsuario(

            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha,
            @RequestParam NivelAcesso nivelAcesso

    ) {

        return serviceUsuario.criarUsuario(nome,email,senha,nivelAcesso);


    }

    @PostMapping("/login")

    public ResponseEntity<Usuario> login(@RequestParam String email, @RequestParam String senha){

        Usuario usuario = serviceUsuario.login(email,senha);

        return ResponseEntity.ok(usuario);

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
