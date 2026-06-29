package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

public record AddressDTO (String ibge, String cep, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
}
