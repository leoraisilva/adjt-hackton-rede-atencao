package br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.MacrorregiaoFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencaoFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.TipoServico;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.Regiao;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaudeFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;
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

    public Macrorregiao toMacroDomain (MacrorregiaoEntity entity) {
        return macrorregiaoFactory.novoMacro(
                entity.getIdMacro(),
                entity.getCodigoMunicipio(),
                redeAtencaoFactory.novaRede(
                        entity.getRedeAtencao().getIdRede(),
                        entity.getRedeAtencao().getResponsavel(),
                        TipoServico.valueOf(entity.getRedeAtencao().getTipo()),
                        entity.getRedeAtencao().getDescricao()
                )
        );
    }

    public MacrorregiaoEntity toMacroEntity (Macrorregiao domain) {
        return new MacrorregiaoEntity(
                domain.getIdMacro(),
                domain.getCDMuncipio(),
                new RedeAtencaoEntity(
                        domain.getRedeAtencao().getIdRede(),
                        domain.getRedeAtencao().getResponsavel(),
                        domain.getRedeAtencao().getTipo().name(),
                        domain.getRedeAtencao().getDescricao()
                )
        );
    }

    public RegiaoSaude toRegiaoSaudeDomain (RegiaoSaudeEntity entity) {
        return regiaoSaudeFactory.novoRegiaoSaude(
                entity.getIdRedeSaude(),
                Regiao.valueOf(entity.getRegiao()),
                macrorregiaoFactory.novoMacro(
                        entity.getMacrorregiao().getIdMacro(),
                        entity.getMacrorregiao().getCodigoMunicipio(),
                        redeAtencaoFactory.novaRede(
                                entity.getMacrorregiao().getRedeAtencao().getIdRede(),
                                entity.getMacrorregiao().getRedeAtencao().getResponsavel(),
                                TipoServico.valueOf(entity.getMacrorregiao().getRedeAtencao().getTipo()),
                                entity.getMacrorregiao().getRedeAtencao().getDescricao()
                        )
                )
        );
    }

    public RegiaoSaudeEntity toRegiaoSaudeEntity (RegiaoSaude domain) {
        return new RegiaoSaudeEntity(
                domain.getIdRedeSaude(),
                domain.getRegiao().name(),
                new MacrorregiaoEntity(
                        domain.getMacrorregiao().getIdMacro(),
                        domain.getMacrorregiao().getCDMuncipio(),
                        new RedeAtencaoEntity(
                                domain.getMacrorregiao().getRedeAtencao().getIdRede(),
                                domain.getMacrorregiao().getRedeAtencao().getResponsavel(),
                                domain.getMacrorregiao().getRedeAtencao().getTipo().name(),
                                domain.getMacrorregiao().getRedeAtencao().getDescricao()
                        )
                )
        );
    }

    public Unidade toUnidadeDomain (UnidadeEntity entity) {
        return unidadeFactory.novaUnidade(
                entity.getIdUnidade(),
                entity.getNome(),
                entity.getCep(),
                entity.getBairro(),
                Status.valueOf(entity.getStatus()),
                regiaoSaudeFactory.novoRegiaoSaude(
                        entity.getRegiaoSaude().getIdRedeSaude(),
                        Regiao.valueOf(entity.getRegiaoSaude().getRegiao()),
                        macrorregiaoFactory.novoMacro(
                                entity.getRegiaoSaude().getMacrorregiao().getIdMacro(),
                                entity.getRegiaoSaude().getMacrorregiao().getCodigoMunicipio(),
                                redeAtencaoFactory.novaRede(
                                        entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getIdRede(),
                                        entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel(),
                                        TipoServico.valueOf(entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getTipo()),
                                        entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getDescricao()
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
                domain.getStatus().name(),
                new RegiaoSaudeEntity(
                        domain.getRegiaoSaude().getIdRedeSaude(),
                        domain.getRegiaoSaude().getRegiao().name(),
                        new MacrorregiaoEntity(
                                domain.getRegiaoSaude().getMacrorregiao().getIdMacro(),
                                domain.getRegiaoSaude().getMacrorregiao().getCDMuncipio(),
                                new RedeAtencaoEntity(
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getIdRede(),
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel(),
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getTipo().name(),
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getDescricao()
                                )
                        )
                )
        );
    }

}
