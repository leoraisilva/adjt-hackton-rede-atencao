package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "macrorregiao_tb")
public class MacrorregiaoEntity {
    private String idMacro;
    private String codigoMunicipio;
    private String redeAtencao;

    public MacrorregiaoEntity(String idMacro, String codigoMunicipio, String redeAtencao) {
        this.idMacro = idMacro;
        this.codigoMunicipio = codigoMunicipio;
        this.redeAtencao = redeAtencao;
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

    public String getRedeAtencao() {
        return redeAtencao;
    }

    public void setRedeAtencao(String redeAtencao) {
        this.redeAtencao = redeAtencao;
    }
}
