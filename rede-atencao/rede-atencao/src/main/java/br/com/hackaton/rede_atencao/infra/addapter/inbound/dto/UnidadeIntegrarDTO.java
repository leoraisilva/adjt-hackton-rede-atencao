package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

import java.util.UUID;

public record UnidadeIntegrarDTO (String nome, String logradouro, String complemento, int numero, String bairro, Status status, RegiaoSaudeIntegrarDTO regiaoSaude) {
    public static Unidade toDomain(UnidadeIntegrarDTO unidadeDTO) {
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(UUID.randomUUID().toString())
                .withNome(unidadeDTO.nome)
                .withLogradouro(unidadeDTO.logradouro)
                .withComplemento(unidadeDTO.complemento)
                .withNumero(unidadeDTO.numero)
                .withBairro(unidadeDTO.bairro)
                .withStatus(unidadeDTO.status)
                .withRegiaoSaude(RegiaoSaudeIntegrarDTO.toDomain(unidadeDTO.regiaoSaude))
                .build();
    }
}
