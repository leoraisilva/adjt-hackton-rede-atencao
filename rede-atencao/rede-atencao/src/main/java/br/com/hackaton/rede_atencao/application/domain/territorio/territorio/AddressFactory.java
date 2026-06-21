package br.com.hackaton.rede_atencao.application.domain.territorio.territorio;

public interface AddressFactory {
    Address novoAddress (String ibge, String cep, String logradouro, String complemento, String bairro, String localidade, String estado, String uf);
}
