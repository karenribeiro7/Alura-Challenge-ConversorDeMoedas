package br.com.alura.conversormoedas.excecao;

public class ValorInvalidoExcecao extends Exception {
    public ValorInvalidoExcecao(double valor) {
        super("O valor informado para conversão é inválido (" + valor + ")");
    }
}
