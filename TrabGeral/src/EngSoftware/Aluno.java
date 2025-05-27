package EngSoftware;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Tarefa criarTarefa(FactoryM factory, String titulo, String descricao, String minhaResponsabilidade) {
        Tarefa tarefa = factory.criarTarefa(titulo, descricao);
        tarefa.adicionarAluno(this, minhaResponsabilidade);
        return tarefa;
    }

    public void adicionarAlunoNaTarefa(Tarefa tarefa, Aluno outroAluno, String responsabilidade) {
        tarefa.adicionarAluno(outroAluno, responsabilidade);
    }
    
    public void escolherNotificacao(Tarefa tarefa, boolean email, boolean popup) {
        List<String> tipos = new ArrayList<>();
        if (email) tipos.add("email");
        if (popup) tipos.add("popup");

        if (tipos.isEmpty()) {
            CentralNotificacoes.getInstancia().desativarNotificacao(tarefa);
        } else {
            CentralNotificacoes.getInstancia().configurarNotificacao(tarefa, tipos.toArray(new String[0]));
        }
    }
    
}
