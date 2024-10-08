package br.com.alura.conversormoedas.util;

public enum Moeda {
    DOLAR("USD"),
    PESO_ARGENTINO("ARS"),
    REAL_BRASILEIRO("BRL"),
    PESO_COLOMBIANO("COP"),
    BOLIVIANO("BOB"),
    PESO_CHILENO("CLP"),
    EURO("EUR");

    private final String codigo;

    Moeda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
