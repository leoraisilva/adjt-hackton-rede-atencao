package br.com.hackaton.rede_atencao.application.usecase.inbound.definirTerritorio;

import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;
import br.com.hackaton.rede_atencao.application.usecase.inbound.localizarTerritorio.LocalizarOutput;

public record DefinirOutput (String idTerritorio, String nome, Address endereco) {
    public static DefinirOutput from (Territorio territorio) {
        return new DefinirOutput(
                territorio.getIdTerritorio(),
                territorio.getNome(),
                territorio.getEndereco()
        );
    }
}
