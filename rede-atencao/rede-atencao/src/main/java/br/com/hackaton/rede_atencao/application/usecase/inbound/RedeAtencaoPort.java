package br.com.hackaton.rede_atencao.application.usecase.inbound;

import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.AtualizarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.AtualizarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.BuscarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.BuscarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.CompararInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.CompararOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.desativar.Desativar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.desativar.DesativarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.listar.ListarOutput;

import java.util.List;

public interface RedeAtencaoPort {
    AtualizarOutput atualizar (AtualizarInput input);
    BuscarOutput buscar (BuscarInput input);
    CompararOutput comparar (CompararInput input);
    DesativarOutput desativar (String idUnidade);
    IntegrarInput integrar (IntegrarInput input);
    List<ListarOutput> listar ();
}
