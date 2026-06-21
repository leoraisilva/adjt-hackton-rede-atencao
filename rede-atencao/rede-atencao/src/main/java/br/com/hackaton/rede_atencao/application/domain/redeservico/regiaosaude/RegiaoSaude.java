package br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude;

public class RegiaoSaude {
    private final String idRedeSaude;
    private final Regiao regiao;
    private final String macrorregiao;

    public RegiaoSaude(RedeSaudeBuilder builder) {
        this.idRedeSaude = builder.idRedeSaude;
        this.regiao = builder.regiao;
        this.macrorregiao = builder.macrorregiao;
    }

    public String getIdRedeSaude() {
        return idRedeSaude;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public String getMacrorregiao() {
        return macrorregiao;
    }

    public static class RedeSaudeBuilder {
        private String idRedeSaude;
        private Regiao regiao;
        private String macrorregiao;

        public RedeSaudeBuilder withIdRedeSaude (String redeSaude) {
            this.idRedeSaude = redeSaude;
            return this;
        }

        public RedeSaudeBuilder withMacrorregiao (String macrorregiao) {
            this.macrorregiao = macrorregiao;
            return this;
        }

        public RedeSaudeBuilder withRegiao (Regiao regiao) {
            this.regiao = regiao;
            return this;
        }

        public RegiaoSaude build () {
            return new RegiaoSaude(this);
        }
    }
}
