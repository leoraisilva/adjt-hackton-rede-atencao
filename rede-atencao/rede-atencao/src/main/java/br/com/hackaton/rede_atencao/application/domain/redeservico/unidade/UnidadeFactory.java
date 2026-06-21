package br.com.hackaton.rede_atencao.application.domain.redeservico.unidade;

public interface UnidadeFactory {
    Unidade novaUnidade (String idUnidade, String nome, String cep, String bairro, Status status, String regiaoSaude);
}
