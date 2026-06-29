package br.com.hackaton.rede_atencao.application.usecase.inbound.desativar;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

public class Desativar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Desativar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public DesativarOutput desativar (String idUnidade) {
        return redeAtencaoPort.desativar(idUnidade);
    }
}
