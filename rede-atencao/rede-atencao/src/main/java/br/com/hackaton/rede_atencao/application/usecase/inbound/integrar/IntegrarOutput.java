package br.com.hackaton.rede_atencao.application.usecase.inbound.integrar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

public record IntegrarOutput (RedeAtencao redeAtencao, Macrorregiao macrorregiao, RegiaoSaude regiaoSaude, Unidade unidade) {
    public static IntegrarOutput from (Unidade unidade) {
        return new IntegrarOutput(
                unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao(),
                unidade.getRegiaoSaude().getMacrorregiao(),
                unidade.getRegiaoSaude(),
                unidade
        );
    }
}
