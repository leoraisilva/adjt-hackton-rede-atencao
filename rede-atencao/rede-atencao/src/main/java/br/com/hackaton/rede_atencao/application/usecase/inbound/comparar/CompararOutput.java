package br.com.hackaton.rede_atencao.application.usecase.inbound.comparar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.application.usecase.inbound.desativar.DesativarOutput;

public record CompararOutput(Unidade unidade) {
    public static CompararOutput from (Unidade unidade) {
        return new CompararOutput(unidade);
    }
}
