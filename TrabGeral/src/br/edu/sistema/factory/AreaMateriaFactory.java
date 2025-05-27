package br.edu.sistema.factory;

import br.edu.sistema.model.AreaMateria;

public interface AreaMateriaFactory {
    AreaMateria criarArea(String nome, String descricao);
}