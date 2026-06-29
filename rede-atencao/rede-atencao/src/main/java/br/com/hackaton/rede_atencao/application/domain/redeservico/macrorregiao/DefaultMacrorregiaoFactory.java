package br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao;

import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;

public class DefaultMacrorregiaoFactory implements MacrorregiaoFactory{
    @Override
    public Macrorregiao novoMacro(String idMacro, String codigoMunicipio, RedeAtencao redeAtencao) {
        return new Macrorregiao.MacrorregiaoBuilder()
                .withIdMacro(idMacro)
                .withCDMunicipio(codigoMunicipio)
                .withRedeAtencao(redeAtencao)
                .build();
    }
}
