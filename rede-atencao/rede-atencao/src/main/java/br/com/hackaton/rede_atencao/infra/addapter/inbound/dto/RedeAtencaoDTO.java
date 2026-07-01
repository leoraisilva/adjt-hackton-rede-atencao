package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;


import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.TipoServico;

public record RedeAtencaoDTO(String idRede, String responsavel, TipoServico tipo, String descricao) {
    public static RedeAtencao toDomain(RedeAtencaoDTO dto) {
        return new RedeAtencao.RedeAtencaoBuilder()
                .withIdRede(dto.idRede())
                .withResponsavel(dto.responsavel())
                .withTipo(dto.tipo())
                .withDescricao(dto.descricao())
                .build();
    }
}
