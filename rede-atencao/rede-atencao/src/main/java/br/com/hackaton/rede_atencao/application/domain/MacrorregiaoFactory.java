package br.com.hackaton.rede_atencao.application.domain;

public interface MacrorregiaoFactory {
    Macrorregiao novoMacro (String idMacro, String nome, String redeAtencao);
}
