package br.com.hackaton.rede_atencao.application.usecase.inbound.buscar;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

public class Buscar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Buscar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public BuscarOutput buscar (String idRede) {
        return redeAtencaoPort.buscar(idRede);
    }
}
