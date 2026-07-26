package br.com.hackaton.rede_atencao.application.usecase.inbound.definir;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;

public record DefinirInput (String nome, Address endereco) {
    public static Territorio to (DefinirInput input) {
        return new Territorio.TerritorioBuilder()
                .withNome(input.nome())
                .withEndereco(input.endereco())
                .build();
    }

    public static DefinirInput from (Territorio territorio) {
        return new DefinirInput(
                territorio.getNome(),
                territorio.getEndereco()
        );
    }

}
