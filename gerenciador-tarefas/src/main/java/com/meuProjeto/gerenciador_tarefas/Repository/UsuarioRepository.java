package com.meuProjeto.gerenciador_tarefas.Repository;

import com.meuProjeto.gerenciador_tarefas.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
