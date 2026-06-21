package br.com.hackaton.rede_atencao.application.domain.redeservico.macrorregiao;

public class DefaultMacrorregiaoFactory implements MacrorregiaoFactory{
    @Override
    public Macrorregiao novoMacro(String idMacro, String codigoMunicipio, String redeAtencao) {
        return new Macrorregiao.MacrorregiaoBuilder()
                .withIdMacro(idMacro)
                .withCDMunicipio(codigoMunicipio)
                .withRedeAtencao(redeAtencao)
                .build();
    }
}
