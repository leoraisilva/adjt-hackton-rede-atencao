package br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.MacrorregiaoFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencaoFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.TipoServico;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.Regiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaudeFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.UnidadeFactory;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.MacrorregiaoEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RedeAtencaoEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RegiaoSaudeEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.UnidadeEntity;


public class RedeServicoMapper implements IRedeServicoMapper {
    private final RedeAtencaoFactory redeAtencaoFactory;
    private final MacrorregiaoFactory macrorregiaoFactory;
    private final RegiaoSaudeFactory regiaoSaudeFactory;
    private final UnidadeFactory unidadeFactory;

    public RedeServicoMapper(RedeAtencaoFactory redeAtencaoFactory, MacrorregiaoFactory macrorregiaoFactory, RegiaoSaudeFactory regiaoSaudeFactory, UnidadeFactory unidadeFactory) {
        this.redeAtencaoFactory = redeAtencaoFactory;
        this.macrorregiaoFactory = macrorregiaoFactory;
        this.regiaoSaudeFactory = regiaoSaudeFactory;
        this.unidadeFactory = unidadeFactory;
    }

    public RedeAtencao toRedeAtencaoDomain (RedeAtencaoEntity entity) {
        return redeAtencaoFactory.novaRede(
                entity.getIdRede(),
                entity.getResponsavel(),
                TipoServico.valueOf(entity.getTipo()),
                entity.getDescricao()
        );
    }

    public RedeAtencaoEntity toRedeAtencaoEntity (RedeAtencao domain) {
        return new RedeAtencaoEntity(
                domain.getIdRede(),
                domain.getResponsavel(),
                domain.getTipo().name(),
                domain.getDescricao()
        );
    }

    public Macrorregiao toMacroDomain (MacrorregiaoEntity entity, RedeAtencaoEntity entityRedeAtencao) {
        return macrorregiaoFactory.novoMacro(
                entity.getIdMacro(),
                entity.getCodigoMunicipio(),
                redeAtencaoFactory.novaRede(
                        entityRedeAtencao.getIdRede(),
                        entityRedeAtencao.getResponsavel(),
                        TipoServico.valueOf(entityRedeAtencao.getTipo()),
                        entityRedeAtencao.getDescricao()
                )
        );
    }

    public MacrorregiaoEntity toMacroEntity (Macrorregiao domain) {
        return new MacrorregiaoEntity(
                domain.getIdMacro(),
                domain.getCDMuncipio(),
                domain.getRedeAtencao().getIdRede()
        );
    }

    public RegiaoSaude toRegiaoSaudeDomain (RegiaoSaudeEntity entity, MacrorregiaoEntity entityMacro, RedeAtencaoEntity entityRedeAtencao) {
        return regiaoSaudeFactory.novoRegiaoSaude(
                entity.getIdRedeSaude(),
                Regiao.valueOf(entity.getRegiao()),
                macrorregiaoFactory.novoMacro(
                        entityMacro.getIdMacro(),
                        entityMacro.getCodigoMunicipio(),
                        redeAtencaoFactory.novaRede(
                                entityRedeAtencao.getIdRede(),
                                entityRedeAtencao.getResponsavel(),
                                TipoServico.valueOf(entityRedeAtencao.getTipo()),
                                entityRedeAtencao.getDescricao()
                        )
                )
        );
    }

    public RegiaoSaudeEntity toRegiaoSaudeEntity (RegiaoSaude domain) {
        return new RegiaoSaudeEntity(
                domain.getIdRedeSaude(),
                domain.getRegiao().name(),
                domain.getMacrorregiao().getIdMacro()
        );
    }

    public Unidade toUnidadeDomain (UnidadeEntity entity, RegiaoSaudeEntity entityRegiao, MacrorregiaoEntity entityMacro, RedeAtencaoEntity entityRedeAtencao) {
        return unidadeFactory.novaUnidade(
                entity.getIdUnidade(),
                entity.getNome(),
                entity.getCep(),
                entity.getBairro(),
                entity.getStatus(),
                regiaoSaudeFactory.novoRegiaoSaude(
                        entityRegiao.getIdRedeSaude(),
                        Regiao.valueOf(entityRegiao.getRegiao()),
                        macrorregiaoFactory.novoMacro(
                                entityMacro.getIdMacro(),
                                entityMacro.getCodigoMunicipio(),
                                redeAtencaoFactory.novaRede(
                                        entityRedeAtencao.getIdRede(),
                                        entityRedeAtencao.getResponsavel(),
                                        TipoServico.valueOf(entityRedeAtencao.getTipo()),
                                        entityRedeAtencao.getDescricao()
                                )
                        )
                )
        );
    }

    public UnidadeEntity toUnidadeEntity (Unidade domain) {
        return new UnidadeEntity(
                domain.getIdUnidade(),
                domain.getNome(),
                domain.getCep(),
                domain.getBairro(),
                domain.getStatus(),
                domain.getRegiaoSaude().getIdRedeSaude()
        );
    }

}
