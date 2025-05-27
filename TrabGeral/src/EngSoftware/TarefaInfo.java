package EngSoftware;

import java.util.Map;

public interface TarefaInfo {
    
    void exibirDetalhes();
    void adicionarAluno(Aluno aluno, String responsabilidade);
    Map<Aluno, String> getAlunosResponsabilidades();
    
}
