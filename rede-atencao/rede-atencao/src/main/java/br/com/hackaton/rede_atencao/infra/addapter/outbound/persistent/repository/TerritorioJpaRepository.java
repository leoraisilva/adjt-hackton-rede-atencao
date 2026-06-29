package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository;

import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.TerritorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritorioJpaRepository extends JpaRepository<TerritorioEntity, String> {
}
