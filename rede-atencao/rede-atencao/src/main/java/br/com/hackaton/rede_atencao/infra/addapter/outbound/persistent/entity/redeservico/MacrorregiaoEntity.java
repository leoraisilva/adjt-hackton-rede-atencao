package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico;

import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;
import jakarta.persistence.*;

@Entity
@Table(name = "macrorregiao_tb")
public class MacrorregiaoEntity {
    @Id
    @Column(name = "id_macro")
    private String idMacro;
    @Column(name = "codigo_municipio")
    private String codigoMunicipio;
    @Column(name = "localidade")
    private String localidade;
    @ManyToOne
    @JoinColumn(name = "id_rede")
    private RedeAtencaoEntity idRede;

    public MacrorregiaoEntity(String idMacro, String codigoMunicipio, String localidade, RedeAtencaoEntity idRede) {
        this.idMacro = idMacro;
        this.codigoMunicipio = codigoMunicipio;
        this.localidade = localidade;
        this.idRede = idRede;
    }

    public MacrorregiaoEntity() {}

    public String getIdMacro() {
        return idMacro;
    }

    public void setIdMacro(String idMacro) {
        this.idMacro = idMacro;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public RedeAtencaoEntity getRedeAtencao() {
        return idRede;
    }

    public void setRedeAtencao(RedeAtencaoEntity idRede) {
        this.idRede = idRede;
    }
}
