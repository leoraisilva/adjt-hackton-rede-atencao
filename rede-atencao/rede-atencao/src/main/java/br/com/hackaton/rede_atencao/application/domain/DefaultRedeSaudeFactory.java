package br.com.hackaton.rede_atencao.application.domain;

public class DefaultRedeSaudeFactory implements RedeSaudeFactory{


    @Override
    public RegiaoSaude novoRedeSaude(String idRedeSaude, String nome, String macrorregiao) {
        return new RegiaoSaude.RedeSaudeBuilder()
                .withIdRedeSaude(idRedeSaude)
                .withNome(nome)
                .withMacrorregiao(macrorregiao)
                .build();
    }
}
