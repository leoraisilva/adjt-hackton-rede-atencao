package br.com.hackaton.rede_atencao.application.domain.redeservico.unidade;

import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;

public class DefaultUnidadeFactory implements UnidadeFactory{
    @Override
    public Unidade novaUnidade(String idUnidade, String nome, String cep, String bairro, Status status, RegiaoSaude regiaoSaude) {
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(idUnidade)
                .withNome(nome)
                .withCep(cep)
                .withBairro(bairro)
                .withStatus(status)
                .withRegiaoSaude(regiaoSaude)
                .build();
    }
}
