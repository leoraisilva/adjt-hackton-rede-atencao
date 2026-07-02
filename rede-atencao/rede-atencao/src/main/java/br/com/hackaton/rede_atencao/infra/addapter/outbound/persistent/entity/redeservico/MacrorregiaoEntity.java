package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico;

import jakarta.persistence.*;

@Entity
@Table(name = "macrorregiao_tb")
public class MacrorregiaoEntity {
    @Id
    @Column(name = "id_macro")
    private String idMacro;
    @Column(name = "codigo_municipio")
    private String codigoMunicipio;
    @ManyToOne
    @JoinColumn(name = "id_rede")
    private RedeAtencaoEntity idRede;

    public MacrorregiaoEntity(String idMacro, String codigoMunicipio, RedeAtencaoEntity idRede) {
        this.idMacro = idMacro;
        this.codigoMunicipio = codigoMunicipio;
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

    public RedeAtencaoEntity getRedeAtencao() {
        return idRede;
    }

    public void setRedeAtencao(RedeAtencaoEntity idRede) {
        this.idRede = idRede;
    }
}
