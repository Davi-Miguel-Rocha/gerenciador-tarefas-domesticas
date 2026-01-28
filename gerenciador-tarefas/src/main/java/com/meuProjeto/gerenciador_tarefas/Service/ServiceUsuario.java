package com.meuProjeto.gerenciador_tarefas.Service;


import com.meuProjeto.gerenciador_tarefas.Entity.NivelAcesso;
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


    public Usuario criarUsuario(String nome, String email, String senha, NivelAcesso nivelAcesso){

        Usuario novoUsuario = new Usuario();

        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        novoUsuario.setNivelAcesso(nivelAcesso);

        return usuarioRepository.save(novoUsuario);


    }

    public Usuario login(String email, String senha){

        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        Usuario usuario = usuarioOpt.orElseThrow(() -> new RuntimeException("Email inválido ou não existente"));

        if(usuario.getSenha().equals(senha)){

            throw new RuntimeException("Sua senha está incorreta.");
        }

        return usuario;
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
