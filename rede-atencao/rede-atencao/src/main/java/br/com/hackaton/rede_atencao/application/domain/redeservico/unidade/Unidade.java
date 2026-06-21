package br.com.hackaton.rede_atencao.application.domain.redeservico.unidade;

public class Unidade {
    private final String idUnidade;
    private final String nome;
    private final String cep;
    private final String bairro;
    private final Status status;
    private final String regiaoSaude;

    public Unidade(UnidadeBuilder builder) {
        this.idUnidade = builder.idUnidade;
        this.nome = builder.nome;
        this.cep = builder.cep;
        this.bairro = builder.bairro;
        this.status = builder.status;
        this.regiaoSaude = builder.regiaoSaude;
    }

    public String getIdUnidade() {
        return idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public Status getStatus() {
        return status;
    }

    public String getRegiaoSaude() {
        return regiaoSaude;
    }

    public static class UnidadeBuilder {
        private String idUnidade;
        private String nome;
        private String cep;
        private String bairro;
        private Status status;
        private String regiaoSaude;

        public UnidadeBuilder withIdUnidade(String idUnidade) {
            this.idUnidade = idUnidade;
            return this;
        }

        public UnidadeBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public UnidadeBuilder withCep(String cep) {
            this.cep = cep;
            return this;
        }

        public UnidadeBuilder withBairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public UnidadeBuilder withStatus (Status status) {
            this.status = status;
            return this;
        }

        public UnidadeBuilder withRegiaoSaude(String regiaoSaude) {
            this.regiaoSaude = regiaoSaude;
            return this;
        }

        public Unidade build () {
            return new Unidade(this);
        }
    }
}
