package br.com.hackaton.rede_atencao.application.domain.territorio.territorio;

public class DefaultTerritorioFactory implements TerritorioFactory{
    @Override
    public Territorio novoTerritorio(String idTerritorio, String nome, Address endereco) {
        return new Territorio.TerritorioBuilder()
                .withIdTerritorio(idTerritorio)
                .withNome(nome)
                .withEndereco(endereco)
                .build();
    }
}
