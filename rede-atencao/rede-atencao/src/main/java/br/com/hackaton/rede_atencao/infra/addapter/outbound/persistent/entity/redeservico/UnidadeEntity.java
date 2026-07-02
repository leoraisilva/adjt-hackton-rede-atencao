package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "unidade_tb")
public class UnidadeEntity {
    @Id
    @Column(name = "id_unidade")
    private String idUnidade;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cep")
    private String cep;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "id_regiao_saude")
    private RegiaoSaudeEntity idRegiaoSaude;

    public UnidadeEntity(String idUnidade, String nome, String cep, String bairro, String status, RegiaoSaudeEntity idRegiaoSaude) {
        this.idUnidade = idUnidade;
        this.nome = nome;
        this.cep = cep;
        this.bairro = bairro;
        this.status = status;
        this.idRegiaoSaude = idRegiaoSaude;
    }

    public UnidadeEntity () {}

    public String getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(String idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RegiaoSaudeEntity getRegiaoSaude() {
        return idRegiaoSaude;
    }

    public void setRegiaoSaude(RegiaoSaudeEntity idRegiaoSaude) {
        this.idRegiaoSaude = idRegiaoSaude;
    }
}
