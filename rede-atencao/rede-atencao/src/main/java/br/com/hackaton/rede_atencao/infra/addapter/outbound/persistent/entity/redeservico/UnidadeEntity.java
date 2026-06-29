package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico;

import br.com.hackaton.rede_atencao.application.domain.redeservico.unidade.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidade_tb")
public class UnidadeEntity {
    private String idUnidade;
    private String nome;
    private String cep;
    private String bairro;
    private Status status;
    private String regiaoSaude;

    public UnidadeEntity(String idUnidade, String nome, String cep, String bairro, Status status, String regiaoSaude) {
        this.idUnidade = idUnidade;
        this.nome = nome;
        this.cep = cep;
        this.bairro = bairro;
        this.status = status;
        this.regiaoSaude = regiaoSaude;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRegiaoSaude() {
        return regiaoSaude;
    }

    public void setRegiaoSaude(String regiaoSaude) {
        this.regiaoSaude = regiaoSaude;
    }
}
