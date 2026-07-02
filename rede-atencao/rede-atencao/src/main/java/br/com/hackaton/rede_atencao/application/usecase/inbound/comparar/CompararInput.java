package br.com.hackaton.rede_atencao.application.usecase.inbound.comparar;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;

public record CompararInput(String idTerritorio, String nome, Address endereco) {
    public static Territorio to (CompararInput input) {
        return new  Territorio.TerritorioBuilder()
                .withIdTerritorio(input.idTerritorio)
                .withNome(input.nome)
                .withEndereco(input.endereco)
                .build();
    }

    public static CompararInput from (Territorio territorio) {
        return new CompararInput(
                territorio.getIdTerritorio(),
                territorio.getNome(),
                territorio.getEndereco()
        );
    }
}
