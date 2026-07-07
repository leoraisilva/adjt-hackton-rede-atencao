package br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.BuscarOutput;

public record AtualizarOutput(Unidade unidade) {
    public static AtualizarOutput from (Unidade unidade) {
        return new AtualizarOutput(unidade);
    }
}
