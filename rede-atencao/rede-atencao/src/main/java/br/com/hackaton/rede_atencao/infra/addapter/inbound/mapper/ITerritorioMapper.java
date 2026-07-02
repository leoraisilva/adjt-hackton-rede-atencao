package br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper;

import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.AddressEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.TerritorioEntity;

public interface ITerritorioMapper {
    TerritorioEntity toTerritorioEntity (Territorio domain);
    Address toAddressDomain (AddressEntity entity);
    AddressEntity toAddressEntity (Address domain);
    Territorio toTerritorioEntity (TerritorioEntity entity);
}
