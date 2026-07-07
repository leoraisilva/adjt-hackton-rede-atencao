package br.com.hackaton.rede_atencao.application.usecase.inbound.listar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

public record ListarOutput (Unidade unidade) {
    public static ListarOutput from (Unidade unidade) {
        return new ListarOutput(unidade);
    }
}
