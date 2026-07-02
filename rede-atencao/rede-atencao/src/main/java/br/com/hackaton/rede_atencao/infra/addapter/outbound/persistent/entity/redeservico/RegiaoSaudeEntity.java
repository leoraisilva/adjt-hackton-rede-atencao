package br.com.hackaton.rede_atencao.infra.addapter.outbound.persistent.entity.redeservico;

import br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude.Regiao;
import jakarta.persistence.*;

@Entity
@Table(name = "regiao_saude_tb")
public class RegiaoSaudeEntity {
    @Id
    @Column(name = "id_regiao_saude")
    private String idRegiaoSaude;
    @Column(name = "regiao")
    private String regiao;
    @ManyToOne
    @JoinColumn(name = "id_macro")
    private MacrorregiaoEntity idMacro;

    public RegiaoSaudeEntity(String idRegiaoSaude, String regiao, MacrorregiaoEntity idMacro) {
        this.idRegiaoSaude = idRegiaoSaude;
        this.regiao = regiao;
        this.idMacro = idMacro;
    }

    public RegiaoSaudeEntity () {}

    public String getIdRegiaoSaude() {
        return idRegiaoSaude;
    }

    public void setIdRegiaoSaude(String idRegiaoSaude) {
        this.idRegiaoSaude = idRegiaoSaude;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public MacrorregiaoEntity getMacrorregiao() {
        return idMacro;
    }

    public void setMacrorregiao(MacrorregiaoEntity idMacro) {
        this.idMacro = idMacro;
    }
}
