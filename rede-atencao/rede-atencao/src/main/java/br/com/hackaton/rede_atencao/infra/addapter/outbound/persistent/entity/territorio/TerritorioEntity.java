package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio;

import br.com.hackaton.rede_atencao.application.domain.territorio.territorio.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "territorio_tb")
public class TerritorioEntity {
    private String idTerritorio;
    private String nome;
    private String endereco;

    public TerritorioEntity(String idTerritorio, String nome, String endereco) {
        this.idTerritorio = idTerritorio;
        this.nome = nome;
        this.endereco = endereco;
    }

    public TerritorioEntity() {}

    public String getIdTerritorio() {
        return idTerritorio;
    }

    public void setIdTerritorio(String idTerritorio) {
        this.idTerritorio = idTerritorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
