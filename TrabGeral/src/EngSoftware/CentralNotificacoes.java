
package EngSoftware;


import java.util.*;

public class CentralNotificacoes {
    private static CentralNotificacoes instancia;
    private Map<Tarefa, Set<String>> preferencias = new HashMap<>();

    private CentralNotificacoes() {}

    public static CentralNotificacoes getInstancia() {
        if (instancia == null) {
            instancia = new CentralNotificacoes();
        }
        return instancia;
    }

    public void configurarNotificacao(Tarefa tarefa, String... tipos) {
        preferencias.put(tarefa, new HashSet<>(Arrays.asList(tipos)));
    }

    public void desativarNotificacao(Tarefa tarefa) {
        preferencias.remove(tarefa);
    }

    public void notificar(Tarefa tarefa, String mensagem) {
        Set<String> tipos = preferencias.get(tarefa);
        if (tipos == null || tipos.isEmpty()) return;

        if (tipos.contains("email")) {
            new NotificacaoEmail().enviar(mensagem);
        }
        if (tipos.contains("popup")) {
            new NotificacaoPopup().enviar(mensagem);
        }
    }
}
