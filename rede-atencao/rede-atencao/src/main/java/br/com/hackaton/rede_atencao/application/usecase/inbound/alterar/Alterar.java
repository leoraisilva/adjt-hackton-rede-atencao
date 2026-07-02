package br.com.hackaton.rede_atencao.application.usecase.inbound.alterar;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

public class Alterar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Alterar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public AlterarOutput alterar (AlterarInput input) {
        return redeAtencaoPort.alterar(input);
    }
}
