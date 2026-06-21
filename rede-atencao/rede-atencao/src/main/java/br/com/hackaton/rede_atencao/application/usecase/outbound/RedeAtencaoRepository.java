package br.com.hackaton.rede_atencao.application.usecase.outbound;

import br.com.hackaton.rede_atencao.application.domain.redeservico.RedeServico;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.AtualizarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.AtualizarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.BuscarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.BuscarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.CompararInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.CompararOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.desativar.DesativarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.listar.ListarOutput;

import java.util.List;

public interface RedeAtencaoRepository {
    RedeServico atualizar (RedeServico redeServico);
    RedeServico buscar (BuscarInput input);
    RedeServico comparar (Territorio territorio);
    RedeServico desativar (String idUnidade);
    RedeServico integrar (RedeServico redeServico);
    List<RedeServico> listar ();
}
