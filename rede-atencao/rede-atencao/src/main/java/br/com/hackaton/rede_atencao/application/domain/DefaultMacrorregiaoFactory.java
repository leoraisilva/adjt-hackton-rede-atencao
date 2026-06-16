package br.com.hackaton.rede_atencao.application.domain;

public class DefaultMacrorregiaoFactory implements MacrorregiaoFactory{
    @Override
    public Macrorregiao novoMacro(String idMacro, String nome, String redeAtencao) {
        return new Macrorregiao.MacrorregiaoBuilder()
                .withIdMacro(idMacro)
                .withNome(nome)
                .withRedeAtencao(redeAtencao)
                .build();
    }
}
