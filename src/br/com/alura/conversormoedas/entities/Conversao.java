package br.com.alura.conversormoedas.entities;

import br.com.alura.conversormoedas.util.Moeda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversao {

    private Moeda entrada;
    private Moeda saida;
    private double valorEntrada;
    private double valorSaida;
    private LocalDateTime dataHoraAtual;

    public Conversao(Moeda entrada, Moeda saida, double valorEntrada, double valorSaida, LocalDateTime dataHora) {
        this.entrada = entrada;
        this.saida = saida;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
        this.dataHoraAtual = dataHora;
    }

    private String formatarDataHora(LocalDateTime dataHora) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHora.format(formatador);
        return dataHoraFormatada;
    }

    @Override
    public String toString() {
        return String.format("O valor de %.2f (%s) foi convertido em %.2f (%s) em %s", valorEntrada, entrada.getCodigo(), valorSaida, saida.getCodigo(), formatarDataHora(dataHoraAtual));
    }
}
