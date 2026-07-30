package br.com.hackaton.rede_atencao.application.usecase.inbound.comparar;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;

public record CompararInput(Address endereco) {
    public static Address to (CompararInput input) {
        return new  Address.AddressBuilder()
                .withCEP(input.endereco().getCep())
                .withCodigoMunicipao(input.endereco().getCodigoMunicipio())
                .withBairro(input.endereco().getBairro())
                .withComplemento(input.endereco().getComplemento())
                .withEstado(input.endereco().getEstado())
                .withLocalidade(input.endereco().getLocalidade())
                .withLogradouro(input.endereco().getLogradouro())
                .withUF(input.endereco().getUF())
                .build();
    }

    public static CompararInput from (Address territorio) {
        return new CompararInput(territorio);
    }
}
