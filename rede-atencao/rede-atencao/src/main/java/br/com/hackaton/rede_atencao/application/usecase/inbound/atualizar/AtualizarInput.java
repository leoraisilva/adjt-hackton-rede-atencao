package br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarInput;

public record AtualizarInput (RedeAtencao redeAtencao, Macrorregiao macrorregiao, RegiaoSaude regiaoSaude, Unidade unidade) {
    public static Unidade to (AtualizarInput input){
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(input.unidade.getIdUnidade())
                .withNome(input.unidade.getNome())
                .withCep(input.unidade.getCep())
                .withBairro(input.unidade.getBairro())
                .withStatus(input.unidade.getStatus())
                .withRegiaoSaude(new RegiaoSaude.RegiaoSaudeBuilder()
                        .withIdRegiaoSaude(input.regiaoSaude.getIdRegiaoSaude())
                        .withRegiao(input.regiaoSaude.getRegiao())
                        .withMacrorregiao(new Macrorregiao.MacrorregiaoBuilder()
                                .withIdMacro(input.macrorregiao.getIdMacro())
                                .withCDMunicipio(input.macrorregiao.getCDMuncipio())
                                .withRedeAtencao(new RedeAtencao.RedeAtencaoBuilder()
                                        .withIdRede(input.redeAtencao.getIdRede())
                                        .withResponsavel(input.redeAtencao.getResponsavel())
                                        .withDescricao(input.redeAtencao.getDescricao())
                                        .withTipo(input.redeAtencao.getTipo())
                                        .build())
                                .build())
                        .build())
                .build();
    }
    public static AtualizarInput from (Unidade domain){
        return new AtualizarInput(
                domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao(),
                domain.getRegiaoSaude().getMacrorregiao(),
                domain.getRegiaoSaude(),
                domain
        );
    }
}
