package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico;

import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.Regiao;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "regiao_saude_tb")
public class RegiaoSaudeEntity {
    private String idRedeSaude;
    private String regiao;
    private String macrorregiao;

    public RegiaoSaudeEntity(String idRedeSaude, String regiao, String macrorregiao) {
        this.idRedeSaude = idRedeSaude;
        this.regiao = regiao;
        this.macrorregiao = macrorregiao;
    }

    public RegiaoSaudeEntity () {}

    public String getIdRedeSaude() {
        return idRedeSaude;
    }

    public void setIdRedeSaude(String idRedeSaude) {
        this.idRedeSaude = idRedeSaude;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getMacrorregiao() {
        return macrorregiao;
    }

    public void setMacrorregiao(String macrorregiao) {
        this.macrorregiao = macrorregiao;
    }
}
