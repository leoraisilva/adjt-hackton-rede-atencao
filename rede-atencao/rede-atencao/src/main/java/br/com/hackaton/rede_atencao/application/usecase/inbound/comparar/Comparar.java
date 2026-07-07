package br.com.hackaton.rede_atencao.application.usecase.inbound.comparar;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.TerritorioEntity;

import java.util.List;

public class Comparar {
    private final RedeAtencaoPort redeAtencaoPort;

    public Comparar(RedeAtencaoPort redeAtencaoPort) {
        this.redeAtencaoPort = redeAtencaoPort;
    }

    public CompararOutput comparar(CompararInput input) {
        return redeAtencaoPort.comparar(input);
    }
}
