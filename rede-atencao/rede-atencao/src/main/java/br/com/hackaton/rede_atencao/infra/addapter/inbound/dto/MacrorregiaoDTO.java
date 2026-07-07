package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;

public record MacrorregiaoDTO (String idMacro, String codigoMunicipio, String localidade, RedeAtencaoDTO redeAtencao) {
    public static Macrorregiao toDomain (MacrorregiaoDTO dto) {
        return new Macrorregiao.MacrorregiaoBuilder()
                .withIdMacro(dto.idMacro())
                .withCDMunicipio(dto.codigoMunicipio())
                .withLocalidade(dto.localidade())
                .withRedeAtencao(RedeAtencaoDTO.toDomain(dto.redeAtencao))
                .build();
    }
}
