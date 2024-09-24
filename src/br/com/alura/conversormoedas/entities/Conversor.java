package br.com.alura.conversormoedas.entities;

import com.google.gson.annotations.SerializedName;

public class Conversor {
    @SerializedName("base_code")
    private String entrada;
    @SerializedName("target_code")
    private String saida;
    @SerializedName("conversion_result")
    private double valor;

    public Conversor(String entrada, String saida, double valor) {
        this.entrada = entrada;
        this.saida = saida;
        this.valor = valor;
    }

    public Conversor(ConversorExchangeRate conversorExchangeRate) {
        this.entrada = conversorExchangeRate.base_code();
        this.saida = conversorExchangeRate.target_code();
        this.valor = Double.valueOf(conversorExchangeRate.conversion_result());
    }

    public double getValor() {
        return valor;
    }
}
