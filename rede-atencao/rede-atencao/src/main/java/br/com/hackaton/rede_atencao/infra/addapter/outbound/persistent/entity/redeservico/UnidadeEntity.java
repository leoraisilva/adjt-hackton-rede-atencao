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
    @Column(name = "numero")
    private int numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "id_regiao_saude")
    private RegiaoSaudeEntity idRegiaoSaude;

    public UnidadeEntity(String idUnidade, String nome, String logradouro, String complemento, int numero, String bairro, String status, RegiaoSaudeEntity idRegiaoSaude) {
        this.idUnidade = idUnidade;
        this.nome = nome;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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
