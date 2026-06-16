package br.com.hackaton.rede_atencao.application.domain;

public class RegiaoSaude {
    private final String idRedeSaude;
    private final String nome;
    private final String macrorregiao;

    public RegiaoSaude(RedeSaudeBuilder builder) {
        this.idRedeSaude = builder.idRedeSaude;
        this.nome = builder.nome;
        this.macrorregiao = builder.macrorregiao;
    }

    public String getIdRedeSaude() {
        return idRedeSaude;
    }

    public String getNome() {
        return nome;
    }

    public String getMacrorregiao() {
        return macrorregiao;
    }

    public static class RedeSaudeBuilder {
        private String idRedeSaude;
        private String nome;
        private String macrorregiao;

        public RedeSaudeBuilder withIdRedeSaude (String redeSaude) {
            this.idRedeSaude = redeSaude;
            return this;
        }

        public RedeSaudeBuilder withMacrorregiao (String macrorregiao) {
            this.macrorregiao = macrorregiao;
            return this;
        }

        public RedeSaudeBuilder withNome (String nome) {
            this.nome = nome;
            return this;
        }

        public RegiaoSaude build () {
            return new RegiaoSaude(this);
        }
    }
}
