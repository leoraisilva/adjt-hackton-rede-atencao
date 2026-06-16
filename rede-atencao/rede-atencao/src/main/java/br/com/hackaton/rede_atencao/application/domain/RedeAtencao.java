package br.com.hackaton.rede_atencao.application.domain;

public class RedeAtencao {
    private final String idRede;
    private final String nome;
    private final String tipo;
    private final String descricao;

    public RedeAtencao(RedeAtencaoBuilder redeAtencaoBuilder) {
        this.idRede = redeAtencaoBuilder.idRede;
        this.nome = redeAtencaoBuilder.nome;
        this.tipo = redeAtencaoBuilder.tipo;
        this.descricao = redeAtencaoBuilder.descricao;
    }

    public String getIdRede() {
        return idRede;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static class RedeAtencaoBuilder {
        private String idRede;
        private String nome;
        private String tipo;
        private String descricao;

        public RedeAtencaoBuilder withIdRede (String idRede) {
            this.idRede = idRede;
            return this;
        }

        public RedeAtencaoBuilder withNome (String nome) {
            this.nome = nome;
            return this;
        }

        public RedeAtencaoBuilder withTipo (String tipo) {
            this.tipo = tipo;
            return this;
        }

        public RedeAtencaoBuilder withDescricao (String descricao) {
            this.descricao = descricao;
            return this;
        }

        public RedeAtencao build () {
            return new RedeAtencao(this);
        }
    }
}
