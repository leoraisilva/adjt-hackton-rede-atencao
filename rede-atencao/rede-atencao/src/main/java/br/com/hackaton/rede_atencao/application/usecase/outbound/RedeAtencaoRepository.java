package br.com.hackaton.rede_atencao.application.usecase.outbound;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Territorio;

import java.util.List;

public interface RedeAtencaoRepository {
    Unidade atualizar (Unidade redeServico);
    Unidade buscar (String input);
    Unidade comparar (Territorio territorio);
    Unidade desativar (String idUnidade);
    Unidade integrar (Unidade unidade);
    List<Unidade> listar ();
    Territorio alterar (Territorio input);
    Territorio definir (Territorio input);
    Territorio localizar (String idTerritorio);
}

