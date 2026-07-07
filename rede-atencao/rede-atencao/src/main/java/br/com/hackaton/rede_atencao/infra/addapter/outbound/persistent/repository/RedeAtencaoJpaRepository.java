package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository;

import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RedeAtencaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedeAtencaoJpaRepository extends JpaRepository<RedeAtencaoEntity, String> {
    List<RedeAtencaoEntity> findByEstado(String estado);
    List<RedeAtencaoEntity> findByResponsavel(String responsavel);
}
