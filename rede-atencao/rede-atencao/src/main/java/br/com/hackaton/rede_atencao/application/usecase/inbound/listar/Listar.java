package br.com.hackaton.rede_atencao.application.usecase.inbound.listar;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;

import java.util.List;

public class Listar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Listar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public List<ListarOutput> listar () {
        return redeAtencaoPort.listar();
    }
}
