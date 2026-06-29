package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.Regiao;

public record RegiaoSaudeDTO (String idRedeSaude, Regiao regiao, MacrorregiaoDTO macrorregiao) {
}
