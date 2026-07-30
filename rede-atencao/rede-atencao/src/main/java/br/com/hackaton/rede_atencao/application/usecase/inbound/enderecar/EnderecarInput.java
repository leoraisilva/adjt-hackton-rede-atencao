package br.com.hackaton.rede_atencao.application.usecase.inbound.enderecar;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;

public record EnderecarInput(Unidade unidade) {
    public static EnderecarInput from (Unidade unidade) {
        return new EnderecarInput(unidade);
    }

    public static Unidade to (EnderecarInput input) {
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(input.unidade().getIdUnidade())
                .withLogradouro(input.unidade().getLogradouro())
                .withNumero(input.unidade().getNumero())
                .withRegiaoSaude(input.unidade().getRegiaoSaude())
                .withStatus(input.unidade().getStatus())
                .withBairro(input.unidade().getBairro())
                .build();
    }
}
