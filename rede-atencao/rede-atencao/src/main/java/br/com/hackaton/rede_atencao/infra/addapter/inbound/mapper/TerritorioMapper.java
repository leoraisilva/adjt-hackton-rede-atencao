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
                        domain.getEndereco().getIbge(),
                        domain.getEndereco().getCep(),
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

    public Territorio toTerritorioEntity (TerritorioEntity entity) {
        return territorioFactory.novoTerritorio(
                entity.getIdTerritorio(),
                entity.getNome(),
                addressFactory.novoAddress(
                        entity.getEndereco().getIbge(),
                        entity.getEndereco().getCep(),
                        entity.getEndereco().getLogradouro(),
                        entity.getEndereco().getComplemento(),
                        entity.getEndereco().getBairro(),
                        entity.getEndereco().getLocalidade(),
                        entity.getEndereco().getEstado(),
                        entity.getEndereco().getComplemento()
                )
        );
    }
}
