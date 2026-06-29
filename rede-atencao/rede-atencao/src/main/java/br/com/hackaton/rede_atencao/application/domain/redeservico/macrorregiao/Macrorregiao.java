package br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao;

import br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao.RedeAtencao;

public class Macrorregiao {
    private final String idMacro;
    private final String codigoMunicipio;
    private final RedeAtencao redeAtencao;

    public Macrorregiao(MacrorregiaoBuilder builder) {
        this.idMacro = builder.idMacro;
        this.codigoMunicipio = builder.codigoMunicipio;
        this.redeAtencao = builder.redeAtencao;
    }

    public String getIdMacro() {
        return idMacro;
    }

    public String getCDMuncipio() {
        return codigoMunicipio;
    }

    public RedeAtencao getRedeAtencao() {
        return redeAtencao;
    }

    public static class MacrorregiaoBuilder {
        private String idMacro;
        private String codigoMunicipio;
        private RedeAtencao redeAtencao;

        public MacrorregiaoBuilder withIdMacro (String idMacro) {
            this.idMacro = idMacro;
            return this;
        }

        public MacrorregiaoBuilder withCDMunicipio (String codigoMunicipio) {
            this.codigoMunicipio = codigoMunicipio;
            return this;
        }

        public MacrorregiaoBuilder withRedeAtencao (RedeAtencao redeAtencao) {
            this.redeAtencao = redeAtencao;
            return this;
        }

        public Macrorregiao build () {
            return new Macrorregiao(this);
        }
    }
}
