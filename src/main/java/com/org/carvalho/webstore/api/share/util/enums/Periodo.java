package com.org.carvalho.webstore.api.share.util.enums;

public enum Periodo {

    MANHA("Manhã, período entre as 08:00 até 11:59"),
    TARDE("Tarde, período entre as 12:00 até 17:59"),
    NOITE("Noite, período entre as 18:00 até 23:59"),
    MADRUGADA("Madrugada, período entre as 00:01 até 07:59");

    private String descricao;

    Periodo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
