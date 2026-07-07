package br.com.hackaton.rede_atencao.application.domain.redeservico.unidade;

import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;

public class DefaultUnidadeFactory implements UnidadeFactory{
    @Override
    public Unidade novaUnidade(String idUnidade, String nome, String logradouro, String complemento, int numero, String bairro, Status status, RegiaoSaude regiaoSaude) {
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(idUnidade)
                .withNome(nome)
                .withLogradouro(logradouro)
                .withComplemento(complemento)
                .withNumero(numero)
                .withBairro(bairro)
                .withStatus(status)
                .withRegiaoSaude(regiaoSaude)
                .build();
    }
}
