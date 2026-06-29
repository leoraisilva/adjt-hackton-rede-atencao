package br.com.hackaton.rede_atencao.application.usecase.inbound.definirTerritorio;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

public class Definir {
    private final RedeAtencaoPort redeAtencaoPort;

    public Definir(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public DefinirOutput definir (DefinirInput input) {
        return redeAtencaoPort.definir(input);
    }
}
