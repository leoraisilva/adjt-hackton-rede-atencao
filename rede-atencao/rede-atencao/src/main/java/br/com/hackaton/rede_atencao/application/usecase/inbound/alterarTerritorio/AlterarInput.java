package br.com.hackaton.rede_atencao.application.usecase.inbound.alterarTerritorio;

import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;
import br.com.hackaton.rede_atencao.application.usecase.inbound.definirTerritorio.DefinirInput;

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
