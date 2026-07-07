package br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao;

import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;

public interface MacrorregiaoFactory {
    Macrorregiao novoMacro (String idMacro, String codigoMunicipio, RedeAtencao redeAtencao, String localidade);
}
