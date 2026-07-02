package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico;

import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.TipoServico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rede_atencao_tb")
public class RedeAtencaoEntity {
    @Id
    @Column(name = "id_rede")
    private String idRede;
    @Column(name = "responsavel")
    private String responsavel;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "descricao")
    private String descricao;

    public RedeAtencaoEntity(String idRede, String responsavel, String tipo, String descricao) {
        this.idRede = idRede;
        this.responsavel = responsavel;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public RedeAtencaoEntity () {}

    public String getIdRede() {
        return idRede;
    }

    public void setIdRede(String idRede) {
        this.idRede = idRede;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
