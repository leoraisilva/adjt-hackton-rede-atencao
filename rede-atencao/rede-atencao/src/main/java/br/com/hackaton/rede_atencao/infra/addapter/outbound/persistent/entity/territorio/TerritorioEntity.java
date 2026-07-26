package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.territorio;

import jakarta.persistence.*;

@Entity
@Table(name = "territorio_tb")
public class TerritorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_territorio")
    private String idTerritorio;
    @Column(name = "nome")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "cep")
    private AddressEntity endereco;

    public TerritorioEntity(String idTerritorio, String nome, AddressEntity endereco) {
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

    public AddressEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(AddressEntity endereco) {
        this.endereco = endereco;
    }
}
