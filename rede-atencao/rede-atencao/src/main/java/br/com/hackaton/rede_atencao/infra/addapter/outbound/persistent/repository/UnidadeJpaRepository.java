package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository;

import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.UnidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeJpaRepository extends JpaRepository<UnidadeEntity, String> {
}
