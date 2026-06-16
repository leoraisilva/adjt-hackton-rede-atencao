package br.com.hackaton.rede_atencao.application.domain;

public interface RedeSaudeFactory {
    RegiaoSaude novoRedeSaude (String idRedeSaude, String nome, String macrorregiao);
}
