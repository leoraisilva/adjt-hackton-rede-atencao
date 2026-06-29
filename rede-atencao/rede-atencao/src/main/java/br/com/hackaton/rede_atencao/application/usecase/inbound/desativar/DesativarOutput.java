package br.com.hackaton.rede_atencao.application.usecase.inbound.desativar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

public record DesativarOutput (RedeAtencao redeAtencao, Macrorregiao macrorregiao, RegiaoSaude regiaoSaude, Unidade unidade) {
    public static DesativarOutput from (Unidade unidade) {
        return new DesativarOutput(
                unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao(),
                unidade.getRegiaoSaude().getMacrorregiao(),
                unidade.getRegiaoSaude(),
                unidade
        );
    }
}
