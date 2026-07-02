package br.com.hackaton.rede_atencao.application.usecase.inbound.definir;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;

public record DefinirOutput (String idTerritorio, String nome, Address endereco) {
    public static DefinirOutput from (Territorio territorio) {
        return new DefinirOutput(
                territorio.getIdTerritorio(),
                territorio.getNome(),
                territorio.getEndereco()
        );
    }
}
