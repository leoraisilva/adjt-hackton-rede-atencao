package br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.AddressFactory;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;
import br.com.hackaton.rede_atencao.application.domain.territorio.TerritorioFactory;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.AddressEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.TerritorioEntity;

public class TerritorioMapper implements ITerritorioMapper {
    private final TerritorioFactory territorioFactory;
    private final AddressFactory addressFactory;

    public TerritorioMapper(TerritorioFactory territorioFactory, AddressFactory addressFactory) {
        this.territorioFactory = territorioFactory;
        this.addressFactory = addressFactory;
    }

    public TerritorioEntity toTerritorioEntity (Territorio domain) {
        return new TerritorioEntity(
                domain.getIdTerritorio(),
                domain.getNome(),
                new AddressEntity(
                        domain.getEndereco().getCep(),
                        domain.getEndereco().getCodigoMunicipio(),
                        domain.getEndereco().getLogradouro(),
                        domain.getEndereco().getComplemento(),
                        domain.getEndereco().getBairro(),
                        domain.getEndereco().getLocalidade(),
                        domain.getEndereco().getEstado(),
                        domain.getEndereco().getUF()
                )
        );
    }

    public Address toAddressDomain (AddressEntity entity) {
        return addressFactory.novoAddress(
                entity.getCep(),
                entity.getCodigoMunicipio(),
                entity.getLogradouro(),
                entity.getComplemento(),
                entity.getBairro(),
                entity.getLocalidade(),
                entity.getEstado(),
                entity.getUf()
        );
    }

    public AddressEntity toAddressEntity (Address domain) {
        return new AddressEntity(
                domain.getCep(),
                domain.getCodigoMunicipio(),
                domain.getLogradouro(),
                domain.getComplemento(),
                domain.getBairro(),
                domain.getLocalidade(),
                domain.getEstado(),
                domain.getUF()
        );
    }

    public Territorio toTerritorioEntity (TerritorioEntity entity) {
        return territorioFactory.novoTerritorio(
                entity.getIdTerritorio(),
                entity.getNome(),
                addressFactory.novoAddress(
                        entity.getEndereco().getCep(),
                        entity.getEndereco().getCodigoMunicipio(),
                        entity.getEndereco().getLogradouro(),
                        entity.getEndereco().getComplemento(),
                        entity.getEndereco().getBairro(),
                        entity.getEndereco().getLocalidade(),
                        entity.getEndereco().getEstado(),
                        entity.getEndereco().getUf()
                )
        );
    }
}
