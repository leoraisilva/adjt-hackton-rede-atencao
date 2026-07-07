package br.com.hackaton.rede_atencao.application.usecase.inbound.buscar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

public record BuscarOutput(Unidade unidade) {
    public static BuscarOutput from (Unidade unidade) {
        return new BuscarOutput(unidade);
    }
}
