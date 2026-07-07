package br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao;

public class DefaultRedeAtencaoFactory implements RedeAtencaoFactory{
    @Override
    public RedeAtencao novaRede(String idRede, String responsavel, TipoServico tipo, String descricao, String estado, String uf) {
        return new RedeAtencao.RedeAtencaoBuilder()
                .withIdRede(idRede)
                .withResponsavel(responsavel)
                .withTipo(tipo)
                .withDescricao(descricao)
                .withEstado(estado)
                .withUf(uf)
                .build();
    }
}
