package com.org.carvalho.webstore.api.share.util.enums;

public enum StatusPagamento {

    AGUARDANDOAPROVACAO("Aguardando Aprovação"),
    FALHAAPICANCELADO("Falha API Pagamento, Cancelado."),
    CANCELADOCONTAPROPRIA("Cancelado por conta própria."),
    CANCELADOOUTROS("Pagamento Cancelado"),
    CANCELADOCARTAOBLOQUEADO("Cancelado, Cartão Bloqueado."),
    CANCELADOCARTAOSEMSALDO("Cancelado, Cartão sem saldo."),
    CANCELADOMOTIVODESCONHECIDO("Cancelado, Motivo desconhecido"),
    APROVADO("Pagamento Aprovado");

    private String descricao;

    StatusPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
