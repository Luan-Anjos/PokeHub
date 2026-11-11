
package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pokeInfo.*;

public class ApiService {
    int status;
    Scanner scanner = new Scanner(System.in);

    private final Controller controller;

    public ApiService(Controller controller) {
        this.controller = controller;
    }

    public String buscaPokemon() throws Exception {
        String url;

        if ("d".equalsIgnoreCase(controller.getSelect())) {
            pokemonSpecies();
            String geradorUrl = controller.getUrlEvolution();
            url = geradorUrl;
        } else {
            url = controller.getUrlRequisicao() + controller.getNomePokemon();
        }

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        final var json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    status = response.statusCode();
                    if (status == 200) {
                        return response.body();
                    } else if (status == 404) {
                        System.out.println("Pokemon não encontrado!");
                    } else if (status == 403) {
                        System.out.println("Acesso bloqueado!");
                    } else if (status == 429) {
                        System.out.println("Excesso de requisições!");
                    } else if (status == 500) {
                        System.out.println("PokeAPI indisponivel!");
                    } else {
                        System.out.println("Erro HTTP inesperado: " + status);
                    }
                    return null;

                })
                .join();
        return json;
    }

    public String pokemonSpecies() throws JsonProcessingException {
        String url = "https://pokeapi.co/api/v2/pokemon-species/" + controller.getNomePokemon();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        String json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    status = response.statusCode();
                    return response.body();
                })
                .join();

        final var objectMapper = new ObjectMapper();
        final var dadosId = objectMapper.readValue(json, Pokemon.class);

        String setId = dadosId.getEvolution_chain().getUrl();

        controller.setUrlEvolution(setId);

        return json;
    }

    public String pokedex () throws JsonProcessingException {

        String url = "https://pokeapi.co/api/v2/pokemon?offset="+ controller.getPage() +"&limit=20";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        String json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    status = response.statusCode();
                    return response.body();
                })
                .join();

        return json;
    }


}



