
package api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pokeInfo.Pokemon;

public class Request {

    Scanner scanner = new Scanner(System.in);

    public String namePokemon (){
        System.out.println("Digite o nome do Pokemon: ");
        String pokemon = scanner.nextLine().trim().toLowerCase();

        return pokemon;
    }


    public void buscaPokemon() throws Exception {

        String url = "https://pokeapi.co/api/v2/pokemon/" + namePokemon();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        final var json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

        final var objectMapper = new ObjectMapper();
        final var dadosPokemon = objectMapper.readValue(json, Pokemon.class);

        System.out.println("ID: " + dadosPokemon.getId());
        System.out.println("Nome: " + dadosPokemon.getName());
        System.out.println("Altura: " + dadosPokemon.getHeight());
        System.out.println("Peso: " + dadosPokemon.getWeight());
        System.out.println("Experiência base: " + dadosPokemon.getBase_experience());

    }
}