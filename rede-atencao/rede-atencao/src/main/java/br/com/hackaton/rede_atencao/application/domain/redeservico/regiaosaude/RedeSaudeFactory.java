package br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude;

public interface RedeSaudeFactory {
    RegiaoSaude novoRedeSaude (String idRedeSaude, Regiao regiao, String macrorregiao);
}
