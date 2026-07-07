package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;

import java.util.UUID;

public record MacrorregiaoIntegrarDTO (String codigoMunicipio, String localidade, RedeAtencaoIntegrarDTO redeAtencao) {
    public static Macrorregiao toDomain (MacrorregiaoIntegrarDTO dto) {
        return new Macrorregiao.MacrorregiaoBuilder()
                .withIdMacro(UUID.randomUUID().toString())
                .withCDMunicipio(dto.codigoMunicipio())
                .withLocalidade(dto.localidade())
                .withRedeAtencao(RedeAtencaoIntegrarDTO.toDomain(dto.redeAtencao))
                .build();
    }
}
