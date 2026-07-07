package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.TipoServico;

import java.util.UUID;

public record RedeAtencaoIntegrarDTO (String responsavel, TipoServico tipo, String descricao, String estado, String uf){
    public static RedeAtencao toDomain(RedeAtencaoIntegrarDTO dto) {
        return new RedeAtencao.RedeAtencaoBuilder()
                .withIdRede(UUID.randomUUID().toString())
                .withResponsavel(dto.responsavel())
                .withTipo(dto.tipo())
                .withDescricao(dto.descricao())
                .withEstado(dto.estado())
                .withUf(dto.uf())
                .build();
    }
}
