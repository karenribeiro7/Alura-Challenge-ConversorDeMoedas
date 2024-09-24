package br.com.alura.conversormoedas.entities;

public record ConversorExchangeRate(String base_code, String target_code, double conversion_result) {
}
