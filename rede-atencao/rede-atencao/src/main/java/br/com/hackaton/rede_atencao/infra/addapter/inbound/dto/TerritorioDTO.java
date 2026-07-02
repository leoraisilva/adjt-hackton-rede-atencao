package br.com.hackaton.rede_atencao.infra.addapter.inbound.dto;


import br.com.hackaton.rede_atencao.application.domain.territorio.Territorio;

public record TerritorioDTO (String idTerritorio, String nome, AddressDTO endereco) {
    public static Territorio toDomain(TerritorioDTO territorioDTO) {
        return new Territorio.TerritorioBuilder()
                .withIdTerritorio(territorioDTO.idTerritorio)
                .withNome(territorioDTO.nome)
                .withEndereco(AddressDTO.toDomain(territorioDTO.endereco))
                .build();
    }
}
