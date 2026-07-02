package br.com.hackaton.rede_atencao.application.usecase.inbound;

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
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.listar.ListarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.localizar.LocalizarOutput;

import java.util.List;

public interface RedeAtencaoPort {
    AtualizarOutput atualizar (AtualizarInput input);
    BuscarOutput buscar (String input);
    CompararOutput comparar (CompararInput input);
    DesativarOutput desativar (String idUnidade);
    IntegrarOutput integrar (IntegrarInput input);
    List<ListarOutput> listar ();
    AlterarOutput alterar (AlterarInput input);
    DefinirOutput definir (DefinirInput input);
    LocalizarOutput localizar (String idTerritorio);
}
