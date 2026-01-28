package com.meuProjeto.gerenciador_tarefas.Controller;


import com.meuProjeto.gerenciador_tarefas.Entity.Status;
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


    @PostMapping("/criarTarefas")
    public Tarefa criarTarefa(@RequestParam String titulo,
                              @RequestParam String descricao,
                              @RequestParam Status statusTarefa,
                              @RequestParam String emailCriador,
                              @RequestParam String emailResponsavel){

        return serviceTarefa.criarTarefa(titulo, descricao, statusTarefa, emailCriador, emailResponsavel);
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
