package br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao;

public interface MacrorregiaoFactory {
    Macrorregiao novoMacro (String idMacro, String codigoMunicipio, String redeAtencao);
}
