package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;

public record AddressDTO (String ibge, String cep, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
    public static Address toDomain (AddressDTO addressDTO) {
        return new Address.AddressBuilder()
                .withIBGE(addressDTO.ibge())
                .withCEP(addressDTO.cep())
                .withLogradouro(addressDTO.logradouro())
                .withComplemento(addressDTO.complemento())
                .withBairro(addressDTO.bairro())
                .withLocalidade(addressDTO.localidade())
                .withEstado(addressDTO.estado())
                .withUF(addressDTO.uf())
                .build();
    }
}
