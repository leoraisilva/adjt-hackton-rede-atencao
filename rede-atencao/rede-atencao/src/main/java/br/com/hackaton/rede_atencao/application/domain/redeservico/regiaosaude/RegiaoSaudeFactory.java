package br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;

public interface RegiaoSaudeFactory {
    RegiaoSaude novoRegiaoSaude (String idRedeSaude, Regiao regiao, Macrorregiao macrorregiao);
}
