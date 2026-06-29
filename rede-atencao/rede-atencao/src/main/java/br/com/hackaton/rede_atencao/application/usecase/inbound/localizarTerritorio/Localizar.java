package br.com.hackaton.rede_atencao.application.usecase.inbound.localizarTerritorio;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

public class Localizar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Localizar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public LocalizarOutput localizar (String idTerritorio) {
        return redeAtencaoPort.localizar(idTerritorio);
    }
}
