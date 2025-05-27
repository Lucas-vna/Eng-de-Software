package EngSoftware;

import java.time.LocalDate;

public class TarefaComFactoryM implements FactoryM{
    
    private LocalDate dataEntrega;

    public TarefaComFactoryM(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public Tarefa criarTarefa(String titulo, String descricao) {
        return new Tarefa(titulo, descricao, dataEntrega);
    }
    
}
