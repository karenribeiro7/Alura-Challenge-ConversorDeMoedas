package br.com.alura.conversormoedas.service;

import br.com.alura.conversormoedas.entities.Conversor;
import br.com.alura.conversormoedas.entities.ConversorExchangeRate;
import br.com.alura.conversormoedas.excecao.ValorInvalidoExcecao;
import br.com.alura.conversormoedas.util.Moeda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    public double converter(Moeda entrada, Moeda saida, double valor) throws IOException, InterruptedException, ValorInvalidoExcecao {
        if (valor <= 0) {
            throw new ValorInvalidoExcecao(valor);
        }
        String endereco = "https://v6.exchangerate-api.com/v6/fd2fdf76c01e657eaaf8041b/pair/" + entrada.getCodigo() + "/" + saida.getCodigo() + "/" + valor;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ConversorExchangeRate conversorExchangeRate = gson.fromJson(json, ConversorExchangeRate.class);

        Conversor conversor = new Conversor(conversorExchangeRate);

        return conversor.getResultado();
    }
}
