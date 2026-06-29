package br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.MacrorregiaoEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RedeAtencaoEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RegiaoSaudeEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.UnidadeEntity;

public interface IRedeServicoMapper {
    RedeAtencao toRedeAtencaoDomain (RedeAtencaoEntity entity);
    RedeAtencaoEntity toRedeAtencaoEntity (RedeAtencao domain);
    Macrorregiao toMacroDomain (MacrorregiaoEntity entity, RedeAtencaoEntity entityRedeAtencao);
    MacrorregiaoEntity toMacroEntity (Macrorregiao domain);
    RegiaoSaude toRegiaoSaudeDomain (RegiaoSaudeEntity entity, MacrorregiaoEntity entityMacro, RedeAtencaoEntity entityRedeAtencao);
    RegiaoSaudeEntity toRegiaoSaudeEntity (RegiaoSaude domain);
    Unidade toUnidadeDomain (UnidadeEntity entity, RegiaoSaudeEntity entityRegiao, MacrorregiaoEntity entityMacro, RedeAtencaoEntity entityRedeAtencao);
    UnidadeEntity toUnidadeEntity (Unidade domain);
}
