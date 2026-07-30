package br.com.hackaton.rede_atencao.application.usecase.inbound.enderecar;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;

public record EnderecarOutput(Address address) {
    public static Address to (EnderecarOutput output) {
        return new Address.AddressBuilder()
                .withCEP(output.address().getCep())
                .withCodigoMunicipao(output.address().getCodigoMunicipio())
                .withLogradouro(output.address().getLogradouro())
                .withLocalidade(output.address().getLocalidade())
                .withEstado(output.address().getEstado())
                .withComplemento(output.address().getComplemento())
                .withBairro(output.address().getBairro())
                .withUF(output.address().getUF())
                .withEstado(output.address().getEstado())
                .build();
    }

    public static EnderecarOutput from ( Address address ) {
        return new EnderecarOutput(address);
    }
}
