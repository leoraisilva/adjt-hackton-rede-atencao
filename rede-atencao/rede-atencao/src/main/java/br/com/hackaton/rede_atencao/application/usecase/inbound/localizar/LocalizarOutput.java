package br.com.hackaton.rede_atencao.application.usecase.inbound.localizar;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;

public record LocalizarOutput (String idTerritorio, String nome, Address endereco) {
    public static LocalizarOutput from (Territorio territorio) {
        return new LocalizarOutput(
                territorio.getIdTerritorio(),
                territorio.getNome(),
                territorio.getEndereco()
        );
    }
}
