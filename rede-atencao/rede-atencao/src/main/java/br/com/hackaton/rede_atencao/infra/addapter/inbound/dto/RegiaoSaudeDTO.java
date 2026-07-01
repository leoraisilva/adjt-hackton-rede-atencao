package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.Regiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;

public record RegiaoSaudeDTO (String idRedeSaude, Regiao regiao, MacrorregiaoDTO macrorregiao) {
    public static RegiaoSaude toDomain (RegiaoSaudeDTO regiaoSaudeDTO) {
        return new RegiaoSaude.RegiaoSaudeBuilder()
                .withIdRedeSaude(regiaoSaudeDTO.idRedeSaude)
                .withRegiao(regiaoSaudeDTO.regiao)
                .withMacrorregiao(MacrorregiaoDTO.toDomain(regiaoSaudeDTO.macrorregiao))
                .build();
    }
}
