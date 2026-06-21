package br.com.hackaton.rede_atencao.application.domain.redeservico.redeatencao;

public class RedeAtencao {
    private final String idRede;
    private final String responsavel;
    private final TipoServico tipo;
    private final String descricao;

    public RedeAtencao(RedeAtencaoBuilder redeAtencaoBuilder) {
        this.idRede = redeAtencaoBuilder.idRede;
        this.responsavel = redeAtencaoBuilder.responsavel;
        this.tipo = redeAtencaoBuilder.tipo;
        this.descricao = redeAtencaoBuilder.descricao;
    }

    public String getIdRede() {
        return idRede;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static class RedeAtencaoBuilder {
        private String idRede;
        private String responsavel;
        private TipoServico tipo;
        private String descricao;

        public RedeAtencaoBuilder withIdRede (String idRede) {
            this.idRede = idRede;
            return this;
        }

        public RedeAtencaoBuilder withResponsavel (String responsavel) {
            this.responsavel = responsavel;
            return this;
        }

        public RedeAtencaoBuilder withTipo (TipoServico tipo) {
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
