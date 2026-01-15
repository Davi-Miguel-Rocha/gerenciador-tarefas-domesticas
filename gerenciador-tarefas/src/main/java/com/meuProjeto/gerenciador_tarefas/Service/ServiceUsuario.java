package com.meuProjeto.gerenciador_tarefas.Service;


import com.meuProjeto.gerenciador_tarefas.Entity.Usuario;
import com.meuProjeto.gerenciador_tarefas.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsuario {

    private final UsuarioRepository usuarioRepository;

    public ServiceUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario criarUsuario(Usuario usuario){

        return usuarioRepository.save(usuario);
    }


    public Usuario buscarUsuario(Long id){

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não foi encontrado."));
    }

    public List<Usuario> buscarTodosUsuarios(){

        return usuarioRepository.findAll();
    }


    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado){

         Usuario usuario = usuarioRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

      usuario.setNome(usuarioAtualizado.getNome());

      usuario.setEmail(usuarioAtualizado.getEmail());

      return usuarioRepository.save(usuario);
    }



    public void deletarUsuario(Long id){

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


        usuarioRepository.deleteById(id);

    }

}
