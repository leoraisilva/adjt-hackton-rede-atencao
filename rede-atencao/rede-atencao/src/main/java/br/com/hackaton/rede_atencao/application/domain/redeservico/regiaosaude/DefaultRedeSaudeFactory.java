package br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;

public class DefaultRedeSaudeFactory implements RegiaoSaudeFactory {

    @Override
    public RegiaoSaude novoRegiaoSaude(String idRedeSaude, Regiao regiao, Macrorregiao macrorregiao) {
        return new RegiaoSaude.RegiaoSaudeBuilder()
                .withIdRedeSaude(idRedeSaude)
                .withRegiao(regiao)
                .withMacrorregiao(macrorregiao)
                .build();
    }
}
