package br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

public class Atualizar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Atualizar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public AtualizarOutput atualizar(AtualizarInput input) {
        return redeAtencaoPort.atualizar(input);
    }
}
