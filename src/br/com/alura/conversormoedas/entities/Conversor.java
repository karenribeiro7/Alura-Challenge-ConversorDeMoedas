package br.com.alura.conversormoedas.entities;

import com.google.gson.annotations.SerializedName;

public class Conversor {
    @SerializedName("base_code")
    private String entrada;
    @SerializedName("target_code")
    private String saida;
    @SerializedName("conversion_result")
    private double resultado;

    public Conversor(String entrada, String saida, double resultado) {
        this.entrada = entrada;
        this.saida = saida;
        this.resultado = resultado;
    }

    public Conversor(ConversorExchangeRate conversorExchangeRate) {
        this.entrada = conversorExchangeRate.base_code();
        this.saida = conversorExchangeRate.target_code();
        this.resultado = Double.valueOf(conversorExchangeRate.conversion_result());
    }

    public double getResultado() {
        return resultado;
    }
}
