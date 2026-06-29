package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;


import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.TipoServico;

public record RedeAtencaoDTO(String idRede, String responsavel, TipoServico tipo, String descricao) {
}
