package br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;

public class DefaultRegiaoSaudeFactory implements RegiaoSaudeFactory {

    @Override
    public RegiaoSaude novoRegiaoSaude(String idRegiaoSaude, Regiao regiao, Macrorregiao macrorregiao) {
        return new RegiaoSaude.RegiaoSaudeBuilder()
                .withIdRegiaoSaude(idRegiaoSaude)
                .withRegiao(regiao)
                .withMacrorregiao(macrorregiao)
                .build();
    }
}
