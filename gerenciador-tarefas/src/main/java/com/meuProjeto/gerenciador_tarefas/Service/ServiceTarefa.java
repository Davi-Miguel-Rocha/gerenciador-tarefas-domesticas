package com.meuProjeto.gerenciador_tarefas.Service;


import com.meuProjeto.gerenciador_tarefas.Entity.Tarefa;
import com.meuProjeto.gerenciador_tarefas.Repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTarefa {

    private final TarefaRepository tarefaRepository;

    public ServiceTarefa(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }


    public List<Tarefa> listarTarefas() {

        return tarefaRepository.findAll();
    }


    public Tarefa buscarTarefa(Long id) {

        return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Falha ao buscar, tarefa não encontrada."));
    }


    public Tarefa criarTarefa(Tarefa tarefa) {

        return tarefaRepository.save(tarefa);
    }


    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel atualizar, tarefa não encontrada."));

        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
        tarefa.setStatus(tarefaAtualizada.getStatus());

        return tarefaRepository.save(tarefa);
    }


    public void deletarTarefa(Long id){

        tarefaRepository.deleteById(id);
    }


}