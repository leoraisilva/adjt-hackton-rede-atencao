package br.com.hackaton.rede_atencao.application.domain;

public interface RedeAtencaoFactory {
    RedeAtencao novaRede(String idRede, String nome, String regiao, String descricao);
}
