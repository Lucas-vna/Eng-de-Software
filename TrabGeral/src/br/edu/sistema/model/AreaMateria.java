
package br.edu.sistema.model;

import java.util.ArrayList;
import java.util.List;

public class AreaMateria {
    private String nome;
    private String descricao;
    private List<String> links;

    public AreaMateria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.links = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getLinks() {
        return links;
    }

    public void adicionarLink(String link) {
        links.add(link);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        if (!links.isEmpty()) {
            sb.append("Links/Arquivos: \n");
            for (String link : links) {
                sb.append(" - ").append(link).append("\n");
            }
        } else {
            sb.append("Nenhum link ou arquivo associado.\n");
        }
        return sb.toString();
    }
}
