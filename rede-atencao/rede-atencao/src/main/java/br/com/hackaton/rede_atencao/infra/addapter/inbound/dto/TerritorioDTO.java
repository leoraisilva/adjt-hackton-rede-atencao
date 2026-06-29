package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;


import br.com.hackaton.rede_atencao.infra.addapter.inbound.dto.AddressDTO;

public record TerritorioDTO (String idTerritorio, String nome, AddressDTO endereco) {
}
