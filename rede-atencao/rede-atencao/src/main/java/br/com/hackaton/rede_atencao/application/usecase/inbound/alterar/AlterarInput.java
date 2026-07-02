package br.com.hackaton.rede_atencao.application.usecase.inbound.alterar;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;

public record AlterarInput (String idTerritorio, String nome, Address endereco) {
    public static Territorio to (AlterarInput input) {
        return new Territorio.TerritorioBuilder()
                .withIdTerritorio(input.idTerritorio())
                .withNome(input.nome())
                .withEndereco(input.endereco())
                .build();
    }

    public static AlterarInput from (Territorio territorio) {
        return new AlterarInput(
                territorio.getIdTerritorio(),
                territorio.getNome(),
                territorio.getEndereco()
        );
    }
}
