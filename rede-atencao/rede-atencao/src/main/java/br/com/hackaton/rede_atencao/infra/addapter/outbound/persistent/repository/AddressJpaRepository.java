package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository;

import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, String> {
    List<AddressEntity> findByCodigoMunicipio(String codigoMunicipio);
    Optional<AddressEntity> findByCep(String cep);
}
