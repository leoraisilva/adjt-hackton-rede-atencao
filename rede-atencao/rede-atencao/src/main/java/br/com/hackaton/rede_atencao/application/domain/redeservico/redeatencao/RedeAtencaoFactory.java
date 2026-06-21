package br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao;

public interface RedeAtencaoFactory {
    RedeAtencao novaRede(String idRede, String responsavel, TipoServico tipo, String descricao);
}
