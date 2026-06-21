package br.com.hackaton.rede_atencao.application.domain.territorio.territorio;

public interface TerritorioFactory {
    Territorio novoTerritorio (String idTerritorio, String nome, Address endereco);
}
