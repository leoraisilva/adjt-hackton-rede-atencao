package br.com.hackaton.rede_atencao.application.domain.redeservico.unidade;

import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;

public interface UnidadeFactory {
    Unidade novaUnidade (String idUnidade, String nome, String cep, String bairro, Status status, RegiaoSaude regiaoSaude);
}
