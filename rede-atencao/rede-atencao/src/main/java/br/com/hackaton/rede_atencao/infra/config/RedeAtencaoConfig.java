package br.com.hackaton.rede_atencao.infra.config;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.DefaultMacrorregiaoFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.MacrorregiaoFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.DefaultRedeAtencaoFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencaoFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.DefaultRegiaoSaudeFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.RegiaoSaudeFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.DefaultUnidadeFactory;
import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.UnidadeFactory;
import br.com.hackaton.rede_atencao.application.domain.territorio.AddressFactory;
import br.com.hackaton.rede_atencao.application.domain.territorio.DefaultAddressFactory;
import br.com.hackaton.rede_atencao.application.domain.territorio.DefaultTerritorioFactory;
import br.com.hackaton.rede_atencao.application.domain.territorio.TerritorioFactory;
import br.com.hackaton.rede_atencao.application.service.RedeAtencaoService;
import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;
import br.com.hackaton.rede_atencao.application.usecase.inbound.alterar.Alterar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.Atualizar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.Buscar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.Comparar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.definir.Definir;
import br.com.hackaton.rede_atencao.application.usecase.inbound.desativar.Desativar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.Integrar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.listar.Listar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.localizar.Localizar;
import br.com.hackaton.rede_atencao.application.usecase.outbound.RedeAtencaoRepository;
import br.com.hackaton.rede_atencao.infra.addapter.gateway.RedeAtencaoImplRepository;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.IRedeServicoMapper;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.ITerritorioMapper;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.RedeServicoMapper;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.mapper.TerritorioMapper;
import br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedeAtencaoConfig {

    @Bean
    Alterar alterar(RedeAtencaoPort redeAtencaoPort) {
        return new Alterar(redeAtencaoPort);
    }

    @Bean
    Buscar buscar(RedeAtencaoPort redeAtencaoPort) {
        return new Buscar(redeAtencaoPort);
    }

    @Bean
    Atualizar atualizar(RedeAtencaoPort redeAtencaoPort) {
        return new Atualizar(redeAtencaoPort);
    }

    @Bean
    Definir definir(RedeAtencaoPort redeAtencaoPort) {
        return new Definir(redeAtencaoPort);
    }

    @Bean
    Integrar integrar(RedeAtencaoPort redeAtencaoPort) {
        return new Integrar(redeAtencaoPort);
    }

    @Bean
    Desativar desativar(RedeAtencaoPort redeAtencaoPort) {
        return new Desativar(redeAtencaoPort);
    }

    @Bean
    Localizar localizar(RedeAtencaoPort redeAtencaoPort) {
        return new Localizar(redeAtencaoPort);
    }

    @Bean
    Listar listar(RedeAtencaoPort redeAtencaoPort) {
        return new Listar(redeAtencaoPort);
    }

    @Bean
    Comparar comparar(RedeAtencaoPort redeAtencaoPort) {
        return new Comparar(redeAtencaoPort);
    }

    @Bean
    RedeAtencaoPort redeAtencaoPort(RedeAtencaoRepository redeAtencaoRepository) {
        return new RedeAtencaoService(redeAtencaoRepository);
    }

    @Bean
    RedeAtencaoRepository redeAtencaoRepository(IRedeServicoMapper redeServicoMapper, ITerritorioMapper territorioMapper, MacrorregiaoJpaRepository macrorregiaoJpaRepository, RedeAtencaoJpaRepository redeAtencaoJpaRepository, UnidadeJpaRepository unidadeJpaRepository, TerritorioJpaRepository territorioJpaRepository, RegiaoSaudeJpaRepository regiaoSaudeJpaRepository) {
        return new RedeAtencaoImplRepository(redeServicoMapper, territorioMapper, macrorregiaoJpaRepository, redeAtencaoJpaRepository, unidadeJpaRepository, territorioJpaRepository, regiaoSaudeJpaRepository);
    }

    @Bean
    IRedeServicoMapper redeServicoMapper(RedeAtencaoFactory redeAtencaoFactory, MacrorregiaoFactory macrorregiaoFactory, RegiaoSaudeFactory regiaoSaudeFactory, UnidadeFactory unidadeFactory) {
        return new RedeServicoMapper(redeAtencaoFactory, macrorregiaoFactory, regiaoSaudeFactory, unidadeFactory);
    }

    @Bean
    ITerritorioMapper territorioMapper (TerritorioFactory territorioFactory, AddressFactory addressFactory) {
        return new TerritorioMapper(territorioFactory, addressFactory);
    }

    @Bean
    RedeAtencaoFactory redeAtencaoFactory() {
        return new DefaultRedeAtencaoFactory();
    }

    @Bean
    MacrorregiaoFactory macrorregiaoFactory() {
        return new DefaultMacrorregiaoFactory();
    }

    @Bean
    UnidadeFactory unidadeFactory() {
        return new DefaultUnidadeFactory();
    }

    @Bean
    RegiaoSaudeFactory regiaoSaudeFactory() {
        return new DefaultRegiaoSaudeFactory();
    }

    @Bean
    TerritorioFactory territorioFactory() {
        return new DefaultTerritorioFactory();
    }

    @Bean
    AddressFactory addressFactory() {
        return new DefaultAddressFactory();
    }

}
