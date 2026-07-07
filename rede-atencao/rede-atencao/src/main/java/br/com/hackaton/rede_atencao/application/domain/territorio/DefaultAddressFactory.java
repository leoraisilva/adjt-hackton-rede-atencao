package br.com.hackaton.rede_atencao.application.domain.territorio;

public class DefaultAddressFactory implements AddressFactory{
    @Override
    public Address novoAddress(String cep, String codigoMunicipio, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
        return new Address.AddressBuilder()
                .withCodigoMunicipao(codigoMunicipio)
                .withCEP(cep)
                .withLogradouro(logradouro)
                .withComplemento(complemento)
                .withBairro(bairro)
                .withLocalidade(localidade)
                .withEstado(estado)
                .withUF(uf)
                .build();
    }
}
