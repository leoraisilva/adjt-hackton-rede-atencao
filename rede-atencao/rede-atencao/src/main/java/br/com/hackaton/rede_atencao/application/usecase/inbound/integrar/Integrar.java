package br.com.hackaton.rede_atencao.application.usecase.inbound.integrar;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

public class Integrar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Integrar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public IntegrarOutput integrar (IntegrarInput input) {
        return redeAtencaoPort.integrar(input);
    }
}
