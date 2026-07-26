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
                entity.getDescricao(),
                entity.getEstado(),
                entity.getUf()
        );
    }

    public RedeAtencaoEntity toRedeAtencaoEntity (RedeAtencao domain) {
        return new RedeAtencaoEntity(
                domain.getIdRede(),
                domain.getResponsavel(),
                domain.getTipo().name(),
                domain.getDescricao(),
                domain.getEstado(),
                domain.getUf()
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
                        entity.getRedeAtencao().getDescricao(),
                        entity.getRedeAtencao().getEstado(),
                        entity.getRedeAtencao().getUf()
                ),
                entity.getLocalidade()
        );
    }

    public MacrorregiaoEntity toMacroEntity (Macrorregiao domain) {
        return new MacrorregiaoEntity(
                domain.getIdMacro(),
                domain.getCodigoMunicipio(),
                domain.getLocalidade(),
                new RedeAtencaoEntity(
                        domain.getRedeAtencao().getIdRede(),
                        domain.getRedeAtencao().getResponsavel(),
                        domain.getRedeAtencao().getTipo().name(),
                        domain.getRedeAtencao().getDescricao(),
                        domain.getRedeAtencao().getEstado(),
                        domain.getRedeAtencao().getUf()
                )
        );
    }

    public RegiaoSaude toRegiaoSaudeDomain (RegiaoSaudeEntity entity) {
        return regiaoSaudeFactory.novoRegiaoSaude(
                entity.getIdRegiaoSaude(),
                Regiao.valueOf(entity.getRegiao()),
                macrorregiaoFactory.novoMacro(
                        entity.getMacrorregiao().getIdMacro(),
                        entity.getMacrorregiao().getCodigoMunicipio(),
                        redeAtencaoFactory.novaRede(
                                entity.getMacrorregiao().getRedeAtencao().getIdRede(),
                                entity.getMacrorregiao().getRedeAtencao().getResponsavel(),
                                TipoServico.valueOf(entity.getMacrorregiao().getRedeAtencao().getTipo()),
                                entity.getMacrorregiao().getRedeAtencao().getDescricao(),
                                entity.getMacrorregiao().getRedeAtencao().getEstado(),
                                entity.getMacrorregiao().getRedeAtencao().getUf()
                        ),
                        entity.getMacrorregiao().getLocalidade()
                )
        );
    }

    public RegiaoSaudeEntity toRegiaoSaudeEntity (RegiaoSaude domain) {
        return new RegiaoSaudeEntity(
                domain.getIdRegiaoSaude(),
                domain.getRegiao().name(),
                new MacrorregiaoEntity(
                        domain.getMacrorregiao().getIdMacro(),
                        domain.getMacrorregiao().getCodigoMunicipio(),
                        domain.getMacrorregiao().getLocalidade(),
                        new RedeAtencaoEntity(
                                domain.getMacrorregiao().getRedeAtencao().getIdRede(),
                                domain.getMacrorregiao().getRedeAtencao().getResponsavel(),
                                domain.getMacrorregiao().getRedeAtencao().getTipo().name(),
                                domain.getMacrorregiao().getRedeAtencao().getDescricao(),
                                domain.getMacrorregiao().getRedeAtencao().getEstado(),
                                domain.getMacrorregiao().getRedeAtencao().getUf()
                        )
                )
        );
    }

    public Unidade toUnidadeDomain (UnidadeEntity entity) {
        return unidadeFactory.novaUnidade(
                entity.getIdUnidade(),
                entity.getNome(),
                entity.getLogradouro(),
                entity.getComplemento(),
                entity.getNumero(),
                entity.getBairro(),
                Status.valueOf(entity.getStatus()),
                regiaoSaudeFactory.novoRegiaoSaude(
                        entity.getRegiaoSaude().getIdRegiaoSaude(),
                        Regiao.valueOf(entity.getRegiaoSaude().getRegiao()),
                        macrorregiaoFactory.novoMacro(
                                entity.getRegiaoSaude().getMacrorregiao().getIdMacro(),
                                entity.getRegiaoSaude().getMacrorregiao().getCodigoMunicipio(),
                                redeAtencaoFactory.novaRede(
                                        entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getIdRede(),
                                        entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel(),
                                        TipoServico.valueOf(entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getTipo()),
                                        entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getDescricao(),
                                        entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getEstado(),
                                        entity.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getUf()
                                ),
                                entity.getRegiaoSaude().getMacrorregiao().getLocalidade()
                        )
                )
        );
    }

    public UnidadeEntity toUnidadeEntity (Unidade domain) {
        return new UnidadeEntity(
                domain.getIdUnidade(),
                domain.getNome(),
                domain.getLogradouro(),
                domain.getComplemento(),
                domain.getNumero(),
                domain.getBairro(),
                domain.getStatus().name(),
                new RegiaoSaudeEntity(
                        domain.getRegiaoSaude().getIdRegiaoSaude(),
                        domain.getRegiaoSaude().getRegiao().name(),
                        new MacrorregiaoEntity(
                                domain.getRegiaoSaude().getMacrorregiao().getIdMacro(),
                                domain.getRegiaoSaude().getMacrorregiao().getCodigoMunicipio(),
                                domain.getRegiaoSaude().getMacrorregiao().getLocalidade(),
                                new RedeAtencaoEntity(
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getIdRede(),
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel(),
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getTipo().name(),
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getDescricao(),
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getEstado(),
                                        domain.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getUf()
                                )
                        )
                )
        );
    }

}
