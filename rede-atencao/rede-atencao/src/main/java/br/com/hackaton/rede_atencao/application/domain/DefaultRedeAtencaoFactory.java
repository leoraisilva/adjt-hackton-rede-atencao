package br.com.hackaton.rede_atencao.application.domain;

public class DefaultRedeAtencaoFactory implements RedeAtencaoFactory{
    @Override
    public RedeAtencao novaRede(String idRede, String nome, String tipo, String descricao) {
        return new RedeAtencao.RedeAtencaoBuilder()
                .withIdRede(idRede)
                .withNome(nome)
                .withTipo(tipo)
                .withDescricao(descricao)
                .build();
    }
}
