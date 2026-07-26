package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

public record UnidadeDTO (String idUnidade, String nome, String logradouro, String complemento, int numero, String bairro, Status status, RegiaoSaudeDTO regiaoSaude) {
    public static Unidade toDomain(UnidadeDTO unidadeDTO) {
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(unidadeDTO.idUnidade)
                .withNome(unidadeDTO.nome)
                .withLogradouro(unidadeDTO.logradouro)
                .withComplemento(unidadeDTO.complemento)
                .withNumero(unidadeDTO.numero)
                .withBairro(unidadeDTO.bairro)
                .withStatus(unidadeDTO.status)
                .withRegiaoSaude(RegiaoSaudeDTO.toDomain(unidadeDTO.regiaoSaude))
                .build();
    }
}
