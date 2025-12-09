package com.meuProjeto.gerenciador_tarefas.Repository;


import com.meuProjeto.gerenciador_tarefas.Entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
