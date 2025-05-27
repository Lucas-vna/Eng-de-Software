
package EngSoftware;

import java.time.LocalDate;
import br.edu.sistema.factory.AreaMateriaFactory;
import br.edu.sistema.factory.AreaMateriaFactoryImpl;
import br.edu.sistema.model.AreaMateria;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // Alunos
        Aluno alunoJoao = new Aluno("Joao");
        Aluno alunoMaria = new Aluno("Maria");
        Aluno alunoCarlos = new Aluno("Carlos");
        
        Scanner scanner = new Scanner(System.in);
        AreaMateriaFactory areaFactory = new AreaMateriaFactoryImpl();

        System.out.println("Cadastro de Area de Materia");
        System.out.print("Digite o nome da materia: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a descricao da materia: ");
        String descricao = scanner.nextLine();

        AreaMateria area = areaFactory.criarArea(nome, descricao);

        System.out.print("Deseja adicionar link ou arquivos a materia? (S/N): ");
        String resposta = scanner.nextLine();

        while (resposta.equalsIgnoreCase("S")) {
            System.out.print("Digite o link ou descricao do arquivo: ");
            String link = scanner.nextLine();
            area.adicionarLink(link);

            System.out.print("Deseja adicionar mais? (S/N): ");
            resposta = scanner.nextLine();
        }

        System.out.println("\nInformacoes da Area de Materia:");
        System.out.println(area);

        scanner.close();
        
        // Fábrica de Tarefas
        FactoryM factory = new TarefaComFactoryM(LocalDate.of(2025, 6, 15));

        // Criação de tarefa
        Tarefa tarefa = alunoJoao.criarTarefa(factory, "Trabalho de Matematica", "Resolver equacoes", "Resolver parte 1");
        alunoJoao.adicionarAlunoNaTarefa(tarefa, alunoMaria, "Resolver parte 2");
        alunoJoao.adicionarAlunoNaTarefa(tarefa, alunoCarlos, "Montar apresentacao");

        tarefa.exibirDetalhes();
        
        alunoJoao.escolherNotificacao(tarefa, true, true); // apenas email
        tarefa.notificar("Sua tarefa esta praxima do prazo!");
        
    }
    
}
