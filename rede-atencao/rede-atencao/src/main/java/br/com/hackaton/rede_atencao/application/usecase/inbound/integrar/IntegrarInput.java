package br.com.hackaton.rede_atencao.application.usecase.inbound.integrar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

public record IntegrarInput (Unidade unidade) {
    public static Unidade to (IntegrarInput input){
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(input.unidade.getIdUnidade())
                .withNome(input.unidade.getNome())
                .withLogradouro(input.unidade.getLogradouro())
                .withComplemento(input.unidade.getComplemento())
                .withNumero(input.unidade.getNumero())
                .withBairro(input.unidade.getBairro())
                .withStatus(input.unidade.getStatus())
                .withRegiaoSaude(new RegiaoSaude.RegiaoSaudeBuilder()
                        .withIdRegiaoSaude(input.unidade().getRegiaoSaude().getIdRegiaoSaude())
                        .withRegiao(input.unidade().getRegiaoSaude().getRegiao())
                        .withMacrorregiao(new Macrorregiao.MacrorregiaoBuilder()
                                .withIdMacro(input.unidade().getRegiaoSaude().getMacrorregiao().getIdMacro())
                                .withCDMunicipio(input.unidade().getRegiaoSaude().getMacrorregiao().getCDMuncipio())
                                .withLocalidade(input.unidade().getRegiaoSaude().getMacrorregiao().getLocalidade())
                                .withRedeAtencao(new RedeAtencao.RedeAtencaoBuilder()
                                        .withIdRede(input.unidade().getRegiaoSaude().getMacrorregiao().getRedeAtencao().getIdRede())
                                        .withResponsavel(input.unidade().getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel())
                                        .withDescricao(input.unidade().getRegiaoSaude().getMacrorregiao().getRedeAtencao().getDescricao())
                                        .withEstado(input.unidade().getRegiaoSaude().getMacrorregiao().getRedeAtencao().getEstado())
                                        .withUf(input.unidade().getRegiaoSaude().getMacrorregiao().getRedeAtencao().getUf())
                                        .withTipo(input.unidade().getRegiaoSaude().getMacrorregiao().getRedeAtencao().getTipo())
                                        .build())
                                .build())
                        .build())
                .build();
    }

    public static IntegrarInput from (Unidade domain) {
        return new IntegrarInput(domain);
    }
}
