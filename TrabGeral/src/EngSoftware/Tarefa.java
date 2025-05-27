package EngSoftware;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tarefa implements TarefaInfo{
    
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private Map<Aluno, String> alunosResponsabilidades;

    public Tarefa(String titulo, String descricao, LocalDate dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.alunosResponsabilidades = new HashMap<>();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\nTarefa: " + titulo);
        System.out.println("Descricao: " + descricao);
        System.out.println("Data de Entrega: " + dataEntrega);
        System.out.println("\nAlunos e Responsabilidades:");
        alunosResponsabilidades.forEach((prof, resp) -> {
            System.out.println("- " + prof.getNome() + ": " + resp);
        });
    }

    
    public void adicionarAluno(Aluno aluno, String responsabilidade) {
        alunosResponsabilidades.put(aluno, responsabilidade);
    }

    @Override
    public Map<Aluno, String> getAlunosResponsabilidades() {
        return alunosResponsabilidades;
    }
    
    public void notificar(String mensagem) {
        CentralNotificacoes.getInstancia().notificar(this, mensagem);
    }
    
    public LocalDate getData(){
        return this.dataEntrega;
    }

}
