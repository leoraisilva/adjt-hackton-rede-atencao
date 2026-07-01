package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

public record UnidadeDTO (String idUnidade, String nome, String cep, String bairro, Status status, RegiaoSaudeDTO regiaoSaude) {
    public static Unidade toDomain(UnidadeDTO unidadeDTO) {
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(unidadeDTO.idUnidade)
                .withNome(unidadeDTO.nome)
                .withCep(unidadeDTO.cep)
                .withBairro(unidadeDTO.bairro)
                .withStatus(unidadeDTO.status)
                .withRegiaoSaude(RegiaoSaudeDTO.toDomain(unidadeDTO.regiaoSaude))
                .build();
    }
}
