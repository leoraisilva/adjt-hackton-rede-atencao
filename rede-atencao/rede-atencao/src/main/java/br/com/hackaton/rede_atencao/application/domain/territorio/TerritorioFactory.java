package br.com.hackaton.rede_atencao.application.domain.territorio;

public interface TerritorioFactory {
    Territorio novoTerritorio (String idTerritorio, String nome, Address endereco);
}
