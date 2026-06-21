package br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao;

public class DefaultRedeAtencaoFactory implements RedeAtencaoFactory{
    @Override
    public RedeAtencao novaRede(String idRede, String responsavel, TipoServico tipo, String descricao) {
        return new RedeAtencao.RedeAtencaoBuilder()
                .withIdRede(idRede)
                .withResponsavel(responsavel)
                .withTipo(tipo)
                .withDescricao(descricao)
                .build();
    }
}
