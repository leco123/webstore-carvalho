package com.org.carvalho.webstore.api.share.util.enums;

public enum StatusEntrega {

    AGUARDANDOAPROVACAO("Aguardando Aprovação"),
    APROVADO("Aprovado para entrega"),
    SEPARANDOPARAENTREGA("Separando para entrega"),
    CONFERINDOPEDIDOSEPARADO("Conferindo Pedido"),
    ENCAMINHADOPARATRANSPORTADORA("Encaminhado para Transportadora"),
    EMTRASNPORTE("Em transporte"),
    ENTREGUENATRANSPORTADORADOCLIENTE("Entregue na transportadora"),
    SAIUPARAENTREGA("Saiu para entrega"),
    TENTATIVADEENTREGA("Tentativa de entrega"),
    TENTATIVADEENTREGAENDERECONAOENCONTRADO("Não encontrou endereço ou endereço não existe"),
    TENTATIVADEENTREGAPESSOANAOMORAMAISNOLOCAL("Pessoa não mora mais no local"),
    DEVOLUCAODEMERCADORIAPORCLIENTE("Cliente não aceitou a mercadoria"),
    DEVOLUCAOMERCADORIAPORNAOENCONTRARPESSOA("Devolução de Mercadoria por não encontrar pessoa"),
    MERCADORIANAOFOIENTREGUE("Perda, roubo ou estraviada"),
    ENTREGUE("Entregue");

    private String descricao;

    StatusEntrega(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
