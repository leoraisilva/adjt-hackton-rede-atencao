package br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude;

public class DefaultRedeSaudeFactory implements RedeSaudeFactory{


    @Override
    public RegiaoSaude novoRedeSaude(String idRedeSaude, Regiao regiao, String macrorregiao) {
        return new RegiaoSaude.RedeSaudeBuilder()
                .withIdRedeSaude(idRedeSaude)
                .withRegiao(regiao)
                .withMacrorregiao(macrorregiao)
                .build();
    }
}
