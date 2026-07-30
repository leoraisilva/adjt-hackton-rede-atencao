package br.com.hackaton.rede_atencao.application.service;

import br.com.hackaton.rede_atencao.application.usecase.inbound.RedeAtencaoPort;
import br.com.hackaton.rede_atencao.application.usecase.inbound.alterar.AlterarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.alterar.AlterarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.AtualizarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.AtualizarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.BuscarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.CompararInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.CompararOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.definir.DefinirInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.definir.DefinirOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.desativar.DesativarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.enderecar.EnderecarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.enderecar.EnderecarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.listar.ListarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.localizar.LocalizarOutput;
import br.com.hackaton.rede_atencao.application.usecase.outbound.RedeAtencaoRepository;

import java.util.List;

public class RedeAtencaoService implements RedeAtencaoPort {
    private final RedeAtencaoRepository repository;

    public RedeAtencaoService(RedeAtencaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public AtualizarOutput atualizar(AtualizarInput input) {
        return AtualizarOutput.from(repository.atualizar(AtualizarInput.to(input)));

    }

    @Override
    public BuscarOutput buscar(String input) {
        return BuscarOutput.from(repository.buscar(input));
    }

    @Override
    public List<CompararOutput> comparar(CompararInput input) {
        return repository.comparar(CompararInput.to(input)).stream()
                .map(CompararOutput::from)
                .toList();
    }

    @Override
    public DesativarOutput desativar(String idUnidade) {
        return DesativarOutput.from(repository.desativar(idUnidade));
    }

    @Override
    public IntegrarOutput integrar(IntegrarInput input) {
        return IntegrarOutput.from(repository.integrar(IntegrarInput.to(input)));
    }

    @Override
    public List<ListarOutput> listar() {
        return repository.listar().stream()
                .map(ListarOutput::from)
                .toList();
    }

    @Override
    public AlterarOutput alterar(AlterarInput input) {
        return AlterarOutput.from(repository.alterar(AlterarInput.to(input)));
    }

    @Override
    public DefinirOutput definir(DefinirInput input) {
        return DefinirOutput.from(repository.definir(DefinirInput.to(input)));
    }

    @Override
    public LocalizarOutput localizar(String idTerritorio) {
        return LocalizarOutput.from(repository.localizar(idTerritorio));
    }

    @Override
    public EnderecarOutput enderecar(EnderecarInput input) {
        return EnderecarOutput.from(repository.enderecar(EnderecarInput.to(input)));
    }
}
