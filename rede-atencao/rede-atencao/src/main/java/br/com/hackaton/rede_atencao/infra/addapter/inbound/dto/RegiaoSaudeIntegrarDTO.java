package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.Regiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;

import java.util.UUID;

public record RegiaoSaudeIntegrarDTO (Regiao regiao, MacrorregiaoIntegrarDTO macrorregiao)  {
    public static RegiaoSaude toDomain (RegiaoSaudeIntegrarDTO regiaoSaudeDTO) {
        return new RegiaoSaude.RegiaoSaudeBuilder()
                .withIdRegiaoSaude(UUID.randomUUID().toString())
                .withRegiao(regiaoSaudeDTO.regiao)
                .withMacrorregiao(MacrorregiaoIntegrarDTO.toDomain(regiaoSaudeDTO.macrorregiao))
                .build();
    }
}
