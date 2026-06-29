package br.com.hackaton.rede_atencao.infra.addapter.gateway;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;
import br.com.hackaton.rede_atencao.application.usecase.outbound.RedeAtencaoRepository;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.IRedeServicoMapper;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.ITerritorioMapper;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository.*;

import java.util.List;

public class RedeAtencaoImplRepository implements RedeAtencaoRepository {
    private final IRedeServicoMapper redeServicoMapper;
    private final ITerritorioMapper territorioMapper;
    private final AddressJpaRepository addressJpaRepository;
    private final MacrorregiaoJpaRepository macrorregiaoJpaRepository;
    private final RedeAtencaoJpaRepository redeAtencaoJpaRepository;
    private final UnidadeJpaRepository unidadeJpaRepository;
    private final TerritorioJpaRepository territorioJpaRepository;
    private final RegiaoSaudeJpaRepository regiaoSaudeJpaRepository;

    public RedeAtencaoImplRepository(IRedeServicoMapper redeServicoMapper, ITerritorioMapper territorioMapper, AddressJpaRepository addressJpaRepository, MacrorregiaoJpaRepository macrorregiaoJpaRepository, RedeAtencaoJpaRepository redeAtencaoJpaRepository, UnidadeJpaRepository unidadeJpaRepository, TerritorioJpaRepository territorioJpaRepository, RegiaoSaudeJpaRepository regiaoSaudeJpaRepository) {
        this.redeServicoMapper = redeServicoMapper;
        this.territorioMapper = territorioMapper;
        this.addressJpaRepository = addressJpaRepository;
        this.macrorregiaoJpaRepository = macrorregiaoJpaRepository;
        this.redeAtencaoJpaRepository = redeAtencaoJpaRepository;
        this.unidadeJpaRepository = unidadeJpaRepository;
        this.territorioJpaRepository = territorioJpaRepository;
        this.regiaoSaudeJpaRepository = regiaoSaudeJpaRepository;
    }

    @Override
    public Unidade atualizar(Unidade redeServico) {
        return null;
    }

    @Override
    public Unidade buscar(String input) {
        return null;
    }

    @Override
    public Unidade comparar(Territorio territorio) {
        return null;
    }

    @Override
    public Unidade desativar(String idUnidade) {
        return null;
    }

    @Override
    public Unidade integrar(Unidade unidade) {
        var redeSaudeEntity = redeServicoMapper.toRedeAtencaoEntity(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao());
        var macrorregiaoEntity = redeServicoMapper.toMacroEntity(unidade.getRegiaoSaude().getMacrorregiao());
        var regiaoSaudeEntity = redeServicoMapper.toRegiaoSaudeEntity(unidade.getRegiaoSaude());
        var unidadeEntity = redeServicoMapper.toUnidadeEntity(unidade);
        redeAtencaoJpaRepository.save(redeSaudeEntity);
        macrorregiaoJpaRepository.save(macrorregiaoEntity);
        regiaoSaudeJpaRepository.save(regiaoSaudeEntity);
        unidadeJpaRepository.save(unidadeEntity);
        return redeServicoMapper.toUnidadeDomain(unidadeEntity, regiaoSaudeEntity, macrorregiaoEntity, redeSaudeEntity);
    }

    @Override
    public List<Unidade> listar() {
        return null;
    }

    @Override
    public Territorio alterar(Territorio input) {
        return null;
    }

    @Override
    public Territorio definir(Territorio input) {
        return null;
    }

    @Override
    public Territorio localizar(String idTerritorio) {
        return null;
    }
}
