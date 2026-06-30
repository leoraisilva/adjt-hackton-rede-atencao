package br.com.hackaton.rede_atencao.infra.addapter.outbound.controller;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Unidade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redeatencao")
public class RedeAtencaoController {

    @PostMapping("/create/unidade")
    public void createUnidade(@RequestBody Unidade unidade) {

    }
}
