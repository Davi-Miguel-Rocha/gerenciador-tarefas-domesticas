package com.meuProjeto.gerenciador_tarefas.Service;


import com.meuProjeto.gerenciador_tarefas.Entity.NivelAcesso;
import com.meuProjeto.gerenciador_tarefas.Entity.Status;
import com.meuProjeto.gerenciador_tarefas.Entity.Tarefa;
import com.meuProjeto.gerenciador_tarefas.Entity.Usuario;
import com.meuProjeto.gerenciador_tarefas.Repository.TarefaRepository;
import com.meuProjeto.gerenciador_tarefas.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTarefa {

    private final TarefaRepository tarefaRepository;

    private final UsuarioRepository usuarioRepository;

    public ServiceTarefa(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Tarefa> listarTarefas() {

        return tarefaRepository.findAll();
    }


    public Tarefa buscarTarefa(Long id) {

        return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Falha ao buscar, tarefa não encontrada."));
    }


    public Tarefa criarTarefa(String titulo,
                              String descricao,
                              Status statusTarefa,
                              String emailCriador,
                              String emailResponsavel){

        Usuario criador = usuarioRepository.findByEmail(emailCriador)
                .orElseThrow(() -> new RuntimeException("Usuário criador da tarefa não foi encontrado."));

        if(criador.getNivelAcesso() != NivelAcesso.RESPONSAVEL){

            throw new RuntimeException("Apenas usuários de nível Responsável podem criar tarefas.");
        }

        Usuario responsavel = usuarioRepository.findByEmail(emailResponsavel)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado, ímpossivel atribuir a tarefa."));

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setStatus(statusTarefa);
        tarefa.setResponsavel(responsavel);

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