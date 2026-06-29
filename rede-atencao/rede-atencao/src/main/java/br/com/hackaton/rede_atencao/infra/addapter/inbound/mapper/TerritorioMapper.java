package br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper;

import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.AddressFactory;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.TerritorioFactory;
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
                domain.getEndereco().getCep()
        );
    }

    public Address toAddressDomain (AddressEntity entity) {
        return addressFactory.novoAddress(
                entity.getIbge(),
                entity.getCep(),
                entity.getLogradouro(),
                entity.getComplemento(),
                entity.getBairro(),
                entity.getLocalidade(),
                entity.getEstado(),
                entity.getComplemento()
        );
    }

    public AddressEntity toAddressEntity (Address domain) {
        return new AddressEntity(
                domain.getIbge(),
                domain.getCep(),
                domain.getLogradouro(),
                domain.getComplemento(),
                domain.getBairro(),
                domain.getLocalidade(),
                domain.getEstado(),
                domain.getComplemento()
        );
    }

    public Territorio toTerritorioEntity (TerritorioEntity entity, AddressEntity entityAddress) {
        return territorioFactory.novoTerritorio(
                entity.getIdTerritorio(),
                entity.getNome(),
                addressFactory.novoAddress(
                        entityAddress.getIbge(),
                        entity.getEndereco(),
                        entityAddress.getLogradouro(),
                        entityAddress.getComplemento(),
                        entityAddress.getBairro(),
                        entityAddress.getLocalidade(),
                        entityAddress.getEstado(),
                        entityAddress.getComplemento()
                )
        );
    }
}
