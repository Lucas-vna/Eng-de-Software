package br.edu.sistema.factory;

import br.edu.sistema.model.AreaMateria;

public class AreaMateriaFactoryImpl implements AreaMateriaFactory {

    @Override
    public AreaMateria criarArea(String nome, String descricao) {
        return new AreaMateria(nome, descricao);
    }
}
