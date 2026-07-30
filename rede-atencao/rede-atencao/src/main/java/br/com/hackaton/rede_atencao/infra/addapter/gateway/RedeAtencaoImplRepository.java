package br.com.hackaton.rede_atencao.infra.addapter.gateway;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.application.domain.territorio.Address;
import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;
import br.com.hackaton.rede_atencao.application.usecase.outbound.RedeAtencaoRepository;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.IRedeServicoMapper;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.ITerritorioMapper;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.MacrorregiaoEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RedeAtencaoEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.RegiaoSaudeEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico.UnidadeEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.AddressEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio.TerritorioEntity;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class RedeAtencaoImplRepository implements RedeAtencaoRepository {
    private final IRedeServicoMapper redeServicoMapper;
    private final ITerritorioMapper territorioMapper;
    private final MacrorregiaoJpaRepository macrorregiaoJpaRepository;
    private final RedeAtencaoJpaRepository redeAtencaoJpaRepository;
    private final UnidadeJpaRepository unidadeJpaRepository;
    private final TerritorioJpaRepository territorioJpaRepository;
    private final RegiaoSaudeJpaRepository regiaoSaudeJpaRepository;
    private final AddressJpaRepository addressJpaRepository;

    public RedeAtencaoImplRepository(IRedeServicoMapper redeServicoMapper, ITerritorioMapper territorioMapper, MacrorregiaoJpaRepository macrorregiaoJpaRepository, RedeAtencaoJpaRepository redeAtencaoJpaRepository, UnidadeJpaRepository unidadeJpaRepository, TerritorioJpaRepository territorioJpaRepository, RegiaoSaudeJpaRepository regiaoSaudeJpaRepository, AddressJpaRepository addressJpaRepository) {
        this.redeServicoMapper = redeServicoMapper;
        this.territorioMapper = territorioMapper;
        this.macrorregiaoJpaRepository = macrorregiaoJpaRepository;
        this.redeAtencaoJpaRepository = redeAtencaoJpaRepository;
        this.unidadeJpaRepository = unidadeJpaRepository;
        this.territorioJpaRepository = territorioJpaRepository;
        this.regiaoSaudeJpaRepository = regiaoSaudeJpaRepository;
        this.addressJpaRepository = addressJpaRepository;
    }

    @Override
    public Unidade atualizar(Unidade redeServico)  {
        var redeEntity = redeAtencaoJpaRepository.findById(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getIdRede()).orElseGet(RedeAtencaoEntity::new);
        redeEntity.setResponsavel(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel());
        redeEntity.setDescricao(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getDescricao());
        redeEntity.setTipo(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getTipo().name());
        redeEntity.setEstado(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getEstado());
        redeEntity.setUf(redeServico.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getUf());
        redeAtencaoJpaRepository.save(redeEntity);

        var macroEntity = macrorregiaoJpaRepository.findById(redeServico.getRegiaoSaude().getMacrorregiao().getIdMacro()).orElseGet(MacrorregiaoEntity::new);
        macroEntity.setCodigoMunicipio(redeServico.getRegiaoSaude().getMacrorregiao().getCodigoMunicipio());
        macroEntity.setLocalidade(redeServico.getRegiaoSaude().getMacrorregiao().getLocalidade());
        macrorregiaoJpaRepository.save(macroEntity);

        var regiaoEntity = regiaoSaudeJpaRepository.findById(redeServico.getRegiaoSaude().getIdRegiaoSaude()).orElseGet(RegiaoSaudeEntity::new);
        regiaoEntity.setRegiao(redeServico.getRegiaoSaude().getRegiao().name());
        redeAtencaoJpaRepository.save(redeEntity);

        var unidadeEntity = unidadeJpaRepository.findById(redeServico.getIdUnidade()).orElseGet(UnidadeEntity::new);
        unidadeEntity.setBairro(redeServico.getBairro());
        unidadeEntity.setNome(redeServico.getNome());
        unidadeEntity.setLogradouro(redeServico.getLogradouro());
        unidadeEntity.setNumero(redeServico.getNumero());
        unidadeEntity.setComplemento(redeServico.getComplemento());
        unidadeEntity.setStatus(redeServico.getStatus().name());
        unidadeEntity = unidadeJpaRepository.save(unidadeEntity);

        return redeServicoMapper.toUnidadeDomain(unidadeEntity);
    }

    @Override
    public Unidade buscar(String input) {
        var unidadeEntity = unidadeJpaRepository.findById(input).orElseThrow(() -> new RuntimeException("Erro ao buscar unidade."));
        return redeServicoMapper.toUnidadeDomain(unidadeEntity);

    }

    @Override
    public List<Unidade> comparar(Address territorio) {
        var unidades = unidadeJpaRepository.findAll();

        var unidadesEntities = unidades.stream()
                .filter(u -> u.getBairro().equals(territorio.getBairro()))
                .map(redeServicoMapper::toUnidadeDomain)
                .toList();

        if (!unidadesEntities.isEmpty()) {
            return unidadesEntities;
        }

        unidadesEntities = unidades.stream()
                .filter(u -> u.getRegiaoSaude().getMacrorregiao().getCodigoMunicipio().equals(territorio.getCodigoMunicipio()))
                .map(redeServicoMapper::toUnidadeDomain)
                .toList();

        if (!unidadesEntities.isEmpty()) {
            return unidadesEntities;
        }

        return unidades.stream()
                .filter(u -> u.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getUf().equals(territorio.getUF()))
                .map(redeServicoMapper::toUnidadeDomain)
                .toList();
    }

    @Override
    public Unidade desativar(String idUnidade) {
        var unidade = unidadeJpaRepository.findById(idUnidade).orElseThrow(() -> new RuntimeException("Erro ao desativar unidade."));
        unidade.setStatus(Status.INATIVO.name());
        unidade = unidadeJpaRepository.save(unidade);
        return redeServicoMapper.toUnidadeDomain(unidade);
    }

    @Override
    public Unidade integrar(Unidade unidade) {
        var redeEntity = redeAtencaoJpaRepository.findByEstado(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getEstado()).stream()
                .filter(rede -> rede.getResponsavel().equals(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel()))
                .findAny()
                .orElseGet(RedeAtencaoEntity::new);
        if(redeEntity.getIdRede() == null) {
            redeEntity.setIdRede(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getIdRede());
            redeEntity.setResponsavel(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getResponsavel());
            redeEntity.setDescricao(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getDescricao());
            redeEntity.setTipo(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getTipo().name());
            redeEntity.setEstado(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getEstado());
            redeEntity.setUf(unidade.getRegiaoSaude().getMacrorregiao().getRedeAtencao().getUf());
            redeAtencaoJpaRepository.save(redeEntity);
        }

        var macroEntity = macrorregiaoJpaRepository.findByCodigoMunicipio(unidade.getRegiaoSaude().getMacrorregiao().getCodigoMunicipio()).stream()
                        .filter(macro -> macro.getLocalidade().equals(unidade.getRegiaoSaude().getMacrorregiao().getLocalidade()))
                        .findAny()
                        .orElseGet(MacrorregiaoEntity::new);
        if(macroEntity.getIdMacro() == null) {
            macroEntity.setIdMacro(unidade.getRegiaoSaude().getMacrorregiao().getIdMacro());
            macroEntity.setCodigoMunicipio(unidade.getRegiaoSaude().getMacrorregiao().getCodigoMunicipio());
            macroEntity.setLocalidade(unidade.getRegiaoSaude().getMacrorregiao().getLocalidade());
            macroEntity.setRedeAtencao(redeEntity);
            macrorregiaoJpaRepository.save(macroEntity);
        }

        var regiaoEntity = regiaoSaudeJpaRepository.findByRegiao(unidade.getRegiaoSaude().getRegiao().name()).orElseGet(RegiaoSaudeEntity::new);
        if(regiaoEntity.getIdRegiaoSaude() == null){
            regiaoEntity.setRegiao(unidade.getRegiaoSaude().getRegiao().name());
            regiaoEntity.setIdRegiaoSaude(unidade.getRegiaoSaude().getIdRegiaoSaude());
            regiaoEntity.setMacrorregiao(macroEntity);
            regiaoSaudeJpaRepository.save(regiaoEntity);
        }


        return redeServicoMapper.toUnidadeDomain(unidadeJpaRepository.save(redeServicoMapper.toUnidadeEntity(unidade)));
    }

    @Override
    public List<Unidade> listar() {
        var unidadelist = unidadeJpaRepository.findAll();
        return unidadelist.stream()
                .map(redeServicoMapper::toUnidadeDomain)
                .toList();
    }

    @Override
    public Territorio alterar(Territorio input) {
        var territorioEntity = territorioJpaRepository.findById(input.getIdTerritorio()).orElseThrow(() -> new RuntimeException("Erro ao Buscar territorio."));
        var addressEntity = addressJpaRepository.findByCep(input.getEndereco().getCep()).orElseGet(AddressEntity::new);
        addressEntity.setCep(input.getEndereco().getCep());
        addressEntity.setCodigoMunicipio(input.getEndereco().getCodigoMunicipio());
        addressEntity.setBairro(input.getEndereco().getBairro());
        addressEntity.setLocalidade(input.getEndereco().getLocalidade());
        addressEntity.setLogradouro(input.getEndereco().getLogradouro());
        addressEntity.setEstado(input.getEndereco().getEstado());
        addressEntity.setComplemento(input.getEndereco().getComplemento());
        addressEntity.setUf(input.getEndereco().getUF());
        addressEntity = addressJpaRepository.save(addressEntity);
        territorioEntity.setEndereco(addressEntity);
        territorioEntity.setNome(input.getNome());
       return territorioMapper.toTerritorioEntity(territorioEntity);
    }

    @Override
    public Territorio definir(Territorio input) {
        var addressEntity = addressJpaRepository.findByCep(input.getEndereco().getCep()).orElseGet(AddressEntity::new);
        addressEntity.setCep(input.getEndereco().getCep());
        addressEntity.setCodigoMunicipio(input.getEndereco().getCodigoMunicipio());
        addressEntity.setBairro(input.getEndereco().getBairro());
        addressEntity.setLocalidade(input.getEndereco().getLocalidade());
        addressEntity.setLogradouro(input.getEndereco().getLogradouro());
        addressEntity.setEstado(input.getEndereco().getEstado());
        addressEntity.setComplemento(input.getEndereco().getComplemento());
        addressEntity.setUf(input.getEndereco().getUF());
        addressEntity = addressJpaRepository.save(addressEntity);
        var territorioEntity = territorioMapper.toTerritorioEntity(input);
        territorioEntity.setEndereco(addressEntity);
        return territorioMapper.toTerritorioEntity(territorioJpaRepository.save(territorioEntity));
    }

    @Override
    public Territorio localizar(String idTerritorio) {
        var territorio = territorioJpaRepository.findById(idTerritorio).orElseThrow(() -> new RuntimeException("Erro ao buscar territorio."));
        return territorioMapper.toTerritorioEntity(territorio);
    }

    @Override
    public Address enderecar(Unidade unidade) {
        var addressEntity = addressJpaRepository.findByCodigoMunicipio(unidade.getRegiaoSaude().getMacrorregiao().getCodigoMunicipio()).stream()
                .filter(c -> c.getBairro().equals(unidade.getBairro()))
                .findAny().orElseThrow(() -> new RuntimeException("Endereco não foi encontrado."));
        return territorioMapper.toAddressDomain(addressEntity);
    }
}
