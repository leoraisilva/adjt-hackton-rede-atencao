package br.com.hackaton.rede_atencao.infra.addapter.outbound.controller;

import br.com.hackaton.rede_atencao.application.usecase.inbound.alterar.Alterar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.alterar.AlterarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.alterar.AlterarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.Atualizar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.AtualizarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.atualizar.AtualizarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.Buscar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.buscar.BuscarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.Comparar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.CompararInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.comparar.CompararOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.definir.Definir;
import br.com.hackaton.rede_atencao.application.usecase.inbound.definir.DefinirInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.definir.DefinirOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.desativar.Desativar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.desativar.DesativarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.Integrar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarInput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.integrar.IntegrarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.listar.Listar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.listar.ListarOutput;
import br.com.hackaton.rede_atencao.application.usecase.inbound.localizar.Localizar;
import br.com.hackaton.rede_atencao.application.usecase.inbound.localizar.LocalizarOutput;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.dto.TerritorioDTO;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.dto.UnidadeDTO;
import br.com.hackaton.rede_atencao.infra.addapter.inbound.dto.UnidadeIntegrarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/redeatencao")
public class RedeAtencaoController {

    private final Alterar alterar;
    private final Buscar buscar;
    private final Atualizar atualizar;
    private final Definir definir;
    private final Integrar integrar;
    private final Desativar desativar;
    private final Localizar localizar;
    private final Comparar comparar;
    private final Listar listar;

    public RedeAtencaoController(Alterar alterar, Buscar buscar, Atualizar atualizar, Definir definir, Integrar integrar, Desativar desativar, Localizar localizar, Comparar comparar, Listar listar) {
        this.alterar = alterar;
        this.buscar = buscar;
        this.atualizar = atualizar;
        this.definir = definir;
        this.integrar = integrar;
        this.desativar = desativar;
        this.localizar = localizar;
        this.comparar = comparar;
        this.listar = listar;
    }

    @PostMapping("/unidade/integrar")
    public ResponseEntity<IntegrarOutput> integrar(@RequestBody UnidadeIntegrarDTO unidade) {
         return ResponseEntity.status(HttpStatus.CREATED).body(integrar.integrar(IntegrarInput.from(UnidadeIntegrarDTO.toDomain(unidade))));
    }

    @GetMapping("/unidade/buscar/{id}")
    public ResponseEntity<BuscarOutput> buscar(@PathVariable(value = "id") String idRede) {
        return ResponseEntity.status(HttpStatus.OK).body(buscar.buscar(idRede));
    }

    @GetMapping("/unidade/listar")
    public ResponseEntity<List<ListarOutput>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(listar.listar());
    }

    @PutMapping("/unidade/atualizar")
    public ResponseEntity<AtualizarOutput> atualizar(@RequestBody UnidadeDTO unidadeDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body( atualizar.atualizar(AtualizarInput.from(UnidadeDTO.toDomain(unidadeDTO))));
    }

    @DeleteMapping("/unidade/desativar/{id}")
    public ResponseEntity<DesativarOutput> desativar(@PathVariable(value = "id") String idUnidade) {
        return ResponseEntity.status(HttpStatus.OK).body(desativar.desativar(idUnidade));
    }

    @PostMapping("/territorio/definir")
    public ResponseEntity<DefinirOutput> definir (@RequestBody TerritorioDTO territorioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(definir.definir(DefinirInput.from(TerritorioDTO.toDomain(territorioDTO))));
    }

    @PutMapping("/territorio/alterar")
    public ResponseEntity<AlterarOutput> alterar (@RequestBody TerritorioDTO territorioDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alterar.alterar(AlterarInput.from(TerritorioDTO.toDomain(territorioDTO))));
    }

    @GetMapping("/territorio/localizar/{cep}")
    public ResponseEntity<LocalizarOutput> localizar (@PathVariable(value = "cep") String cep) {
        return ResponseEntity.status(HttpStatus.OK).body(localizar.localizar(cep));
    }

    @GetMapping("/unidade/comparar")
    public ResponseEntity<List<CompararOutput>> comparar (@RequestBody TerritorioDTO territorioDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(comparar.comparar(CompararInput.from(TerritorioDTO.toDomain(territorioDTO))));
    }
}
