package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;

public record UnidadeDTO (String idUnidade, String nome, String cep, String bairro, Status status, RegiaoSaudeDTO regiaoSaude) {
}
