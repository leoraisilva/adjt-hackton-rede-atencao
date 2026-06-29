package br.com.hackaton.rede_atencao.application.usecase.inbound.alterarTerritorio;

import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;

public record AlterarOutput (String idTerritorio, String nome, Address endereco) {
    public static AlterarOutput from (Territorio territorio) {
        return new AlterarOutput(
                territorio.getIdTerritorio(),
                territorio.getNome(),
                territorio.getEndereco()
        );
    }
}
