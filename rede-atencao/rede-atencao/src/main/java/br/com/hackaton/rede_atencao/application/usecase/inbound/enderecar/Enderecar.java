package br.com.hackaton.rede_atencao.application.usecase.inbound.enderecar;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

public class Enderecar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Enderecar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public EnderecarOutput enderecar (EnderecarInput input) {
        return redeAtencaoPort.enderecar(input);
    }
}
