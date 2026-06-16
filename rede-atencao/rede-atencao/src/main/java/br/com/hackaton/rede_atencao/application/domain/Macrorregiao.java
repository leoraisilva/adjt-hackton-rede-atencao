package br.com.hackaton.rede_atencao.application.domain;

public class Macrorregiao {
    private final String idMacro;
    private final String nome;
    private final String redeAtencao;

    public Macrorregiao(MacrorregiaoBuilder builder) {
        this.idMacro = builder.idMacro;
        this.nome = builder.nome;
        this.redeAtencao = builder.redeAtencao;
    }

    public String getIdMacro() {
        return idMacro;
    }

    public String getNome() {
        return nome;
    }

    public String getRedeAtencao() {
        return redeAtencao;
    }

    public static class MacrorregiaoBuilder {
        private String idMacro;
        private String nome;
        private String redeAtencao;

        public MacrorregiaoBuilder withIdMacro (String idMacro) {
            this.idMacro = idMacro;
            return this;
        }

        public MacrorregiaoBuilder withNome (String nome) {
            this.nome = nome;
            return this;
        }

        public MacrorregiaoBuilder withRedeAtencao (String redeAtencao) {
            this.redeAtencao = redeAtencao;
            return this;
        }

        public Macrorregiao build () {
            return new Macrorregiao(this);
        }
    }
}
