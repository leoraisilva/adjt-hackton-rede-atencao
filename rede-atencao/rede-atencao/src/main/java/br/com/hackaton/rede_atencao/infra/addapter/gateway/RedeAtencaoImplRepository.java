package br.com.hackaton.rede_atencao.infra.addapter.gateway;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;
import br.com.hackaton.rede_atencao.application.usecase.outbound.RedeAtencaoRepository;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.IRedeServicoMapper;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.ITerritorioMapper;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.MacrorregiaoEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RedeAtencaoEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RegiaoSaudeEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.UnidadeEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.AddressEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public Unidade atualizar(Unidade redeServico)  {
        var redeEntity = redeAtencaoJpaRepository.findById(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getIdRede()).orElseGet(RedeAtencaoEntity::new);
        redeEntity.setResponsavel(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel());
        redeEntity.setDescricao(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getDescricao());
        redeEntity.setTipo(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getTipo().name());
        redeEntity = redeAtencaoJpaRepository.save(redeEntity);

        var macroEntity = macrorregiaoJpaRepository.findById(redeServico.getRegiaoSaude().getMacrorregiao().getIdMacro()).orElseGet(MacrorregiaoEntity::new);
        macroEntity.setCodigoMunicipio(redeServico.getRegiaoSaude().getMacrorregiao().getCDMuncipio());
        macroEntity = macrorregiaoJpaRepository.save(macroEntity);

        var regiaoEntity = regiaoSaudeJpaRepository.findById(redeServico.getRegiaoSaude().getIdRedeSaude()).orElseGet(RegiaoSaudeEntity::new);
        regiaoEntity.setRegiao(redeServico.getRegiaoSaude().getRegiao().name());
        redeEntity = redeAtencaoJpaRepository.save(redeEntity);

        var unidadeEntity = unidadeJpaRepository.findById(redeServico.getIdUnidade()).orElseGet(UnidadeEntity::new);
        unidadeEntity.setBairro(redeServico.getBairro());
        unidadeEntity.setNome(redeServico.getNome());
        unidadeEntity.setCep(redeServico.getCep());
        unidadeEntity.setStatus(redeServico.getStatus().name());
        unidadeEntity = unidadeJpaRepository.save(unidadeEntity);

        return redeServicoMapper.toUnidadeDomain(unidadeEntity, regiaoEntity, macroEntity, redeEntity);
    }

    @Override
    public Unidade buscar(String input) {
        var unidadeEntity = unidadeJpaRepository.findById(input).orElseThrow(() -> new RuntimeException("Erro ao buscar unidade."));
        var regiao = regiaoSaudeJpaRepository.findById(unidadeEntity.getRegiaoSaude()).orElseGet(RegiaoSaudeEntity::new);
        var macro = macrorregiaoJpaRepository.findById(regiao.getMacrorregiao()).orElseGet(MacrorregiaoEntity::new);
        var rede = redeAtencaoJpaRepository.findById(macro.getRedeAtencao()).orElseGet(RedeAtencaoEntity::new);
        return redeServicoMapper.toUnidadeDomain(unidadeEntity,  regiao, macro, rede);

    }

    @Override
    public Unidade comparar(Territorio territorio) {
        var territorioEntity = territorioJpaRepository.findById(territorio.getIdTerritorio()).orElseThrow(() -> new RuntimeException("Erro ao comparar territorio."));
        var unidadeEntity = unidadeJpaRepository.findByCep(territorioEntity.getEndereco()).orElseThrow(() -> new RuntimeException("Erro ao comparar unidade."));
        var regiao = regiaoSaudeJpaRepository.findById(unidadeEntity.getRegiaoSaude()).orElseGet(RegiaoSaudeEntity::new);
        var macro = macrorregiaoJpaRepository.findById(regiao.getMacrorregiao()).orElseGet(MacrorregiaoEntity::new);
        var rede = redeAtencaoJpaRepository.findById(macro.getRedeAtencao()).orElseGet(RedeAtencaoEntity::new);
        return redeServicoMapper.toUnidadeDomain(unidadeEntity,  regiao, macro, rede);
    }

    @Override
    public Unidade desativar(String idUnidade) {
        var unidade = unidadeJpaRepository.findById(idUnidade).orElseThrow(() -> new RuntimeException("Erro ao desativar unidade."));
        unidade.setStatus(Status.INATIVO.name());
        unidade = unidadeJpaRepository.save(unidade);
        var regiao = regiaoSaudeJpaRepository.findById(unidade.getRegiaoSaude()).orElseGet(RegiaoSaudeEntity::new);
        var macro = macrorregiaoJpaRepository.findById(regiao.getMacrorregiao()).orElseGet(MacrorregiaoEntity::new);
        var rede = redeAtencaoJpaRepository.findById(macro.getRedeAtencao()).orElseGet(RedeAtencaoEntity::new);
        return redeServicoMapper.toUnidadeDomain(unidade,  regiao, macro, rede);
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
        List<Unidade> unidades = new ArrayList<>();
        var unidadelist = unidadeJpaRepository.findAll();
        unidadelist.forEach(u -> {
            var regiao = regiaoSaudeJpaRepository.findById(u.getRegiaoSaude()).orElseGet(RegiaoSaudeEntity::new);
            var macro = macrorregiaoJpaRepository.findById(regiao.getMacrorregiao()).orElseGet(MacrorregiaoEntity::new);
            var rede = redeAtencaoJpaRepository.findById(macro.getRedeAtencao()).orElseGet(RedeAtencaoEntity::new);
            unidades.add(redeServicoMapper.toUnidadeDomain(u, regiao, macro, rede));
        });
        return unidades;
    }

    @Override
    public Territorio alterar(Territorio input) {
        var territorioEntity = territorioJpaRepository.findById(input.getIdTerritorio()).orElseThrow(() -> new RuntimeException("Erro ao Buscar territorio."));
        territorioEntity.setEndereco(input.getEndereco().getCep());
        territorioEntity.setNome(input.getNome());
        var addressEntity = addressJpaRepository.findById(territorioEntity.getEndereco()).orElseThrow(() -> new RuntimeException("Erro ao Buscar endereco."));
        return territorioMapper.toTerritorioEntity(territorioEntity, addressEntity);
    }

    @Override
    public Territorio definir(Territorio input) {
        var territorioEntity = territorioJpaRepository.save(territorioMapper.toTerritorioEntity(input));
        var addressEntity = addressJpaRepository.findById(territorioEntity.getEndereco()).orElseGet(AddressEntity::new);
        return territorioMapper.toTerritorioEntity(territorioEntity, addressEntity);
    }

    @Override
    public Territorio localizar(String idTerritorio) {
        var territorio = territorioJpaRepository.findById(idTerritorio).orElseThrow(() -> new RuntimeException("Erro ao buscar territorio."));
        var address = addressJpaRepository.findById(territorio.getEndereco()).orElseThrow(() -> new RuntimeException("Erro ao buscar endereco."));
        return territorioMapper.toTerritorioEntity(territorio, address);
    }
}
