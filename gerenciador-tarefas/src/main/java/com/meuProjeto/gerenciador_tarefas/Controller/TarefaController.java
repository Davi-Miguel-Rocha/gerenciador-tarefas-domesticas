package com.meuProjeto.gerenciador_tarefas.Controller;


import com.meuProjeto.gerenciador_tarefas.Entity.Tarefa;
import com.meuProjeto.gerenciador_tarefas.Service.ServiceTarefa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final ServiceTarefa serviceTarefa;

    public TarefaController(ServiceTarefa serviceTarefa) {
        this.serviceTarefa = serviceTarefa;
    }


    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa){

        return serviceTarefa.criarTarefa(tarefa);
    }

    @GetMapping
    public List<Tarefa> listarTodasTarefas(){

        return serviceTarefa.listarTarefas();
    }


    @GetMapping("/{id}")
    public Tarefa buscarTarefaPorID(@PathVariable Long id){

        return serviceTarefa.buscarTarefa(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada){

        return serviceTarefa.atualizarTarefa(id, tarefaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){

        serviceTarefa.deletarTarefa(id);
    }
}
