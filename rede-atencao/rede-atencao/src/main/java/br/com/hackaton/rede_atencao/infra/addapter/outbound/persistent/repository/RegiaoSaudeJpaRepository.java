package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository;

import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RegiaoSaudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegiaoSaudeJpaRepository extends JpaRepository<RegiaoSaudeEntity, String> {
    Optional<RegiaoSaudeEntity> findByRegiao(String regiao);
}
