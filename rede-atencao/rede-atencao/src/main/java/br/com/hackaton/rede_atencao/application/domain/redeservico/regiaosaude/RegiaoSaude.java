package br.com.hackaton.rede_atencao.application.domain.redeservico.regiaosaude;

import br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao.Macrorregiao;

public class RegiaoSaude {
    private final String idRedeSaude;
    private final Regiao regiao;
    private final Macrorregiao macrorregiao;

    public RegiaoSaude(RegiaoSaudeBuilder builder) {
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

    public Macrorregiao getMacrorregiao() {
        return macrorregiao;
    }

    public static class RegiaoSaudeBuilder {
        private String idRedeSaude;
        private Regiao regiao;
        private Macrorregiao macrorregiao;

        public RegiaoSaudeBuilder withIdRedeSaude (String redeSaude) {
            this.idRedeSaude = redeSaude;
            return this;
        }

        public RegiaoSaudeBuilder withMacrorregiao (Macrorregiao macrorregiao) {
            this.macrorregiao = macrorregiao;
            return this;
        }

        public RegiaoSaudeBuilder withRegiao (Regiao regiao) {
            this.regiao = regiao;
            return this;
        }

        public RegiaoSaude build () {
            return new RegiaoSaude(this);
        }
    }
}
