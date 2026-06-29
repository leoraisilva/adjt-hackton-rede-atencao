package br.com.hackaton.rede_atencao.application.usecase.inbound.definirTerritorio;

import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;

public record DefinirInput (String idTerritorio, String nome, Address endereco) {
    public static Territorio to (DefinirInput input) {
        return new Territorio.TerritorioBuilder()
                .withIdTerritorio(input.idTerritorio())
                .withNome(input.nome())
                .withEndereco(input.endereco())
                .build();
    }
}
