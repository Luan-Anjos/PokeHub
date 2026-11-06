
package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pokeInfo.*;

public class Request {

    Scanner scanner = new Scanner(System.in);

    private final Controller controller;

    public Request(Controller controller) {
        this.controller = controller;
    }


    public String buscaPokemon() throws Exception {
        String url;

        if ("d".equalsIgnoreCase(controller.getSelect())){
            String geradorUrl = pokemonSpecies();
            url = geradorUrl;
        } else {
            url = controller.getUrlRequisicao() + controller.getNomePokemon();
        }

        System.out.println(url);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        final var json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    int status = response.statusCode();

                    System.out.println("Status HTTP: " + status);

                    return response.body();
                })
                .join();

        return json;
    }

    public void exibirBuscaPokemon() throws Exception {

        String json = buscaPokemon();
        final var objectMapper = new ObjectMapper();
        final var dadosPokemon = objectMapper.readValue(json, Pokemon.class);

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String branco = "\u001B[97m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "       ⚡ POKÉMON ⚡       " + ciano + "║");
        System.out.println("╠══════════════════════════╣" + reset);

        System.out.println(branco + " ID:               " + amarelo + dadosPokemon.getId() + reset);
        System.out.println(branco + " Nome:             " + verde + negrito + dadosPokemon.getName() + reset);
        System.out.println(branco + " Altura:           " + amarelo + dadosPokemon.getHeight() + reset);
        System.out.println(branco + " Peso:             " + amarelo + dadosPokemon.getWeight() + reset);
        System.out.println(branco + " Experiência base: " + amarelo + dadosPokemon.getBase_experience() + reset);

        System.out.println(ciano + "╠══════════════════════════╣");
        System.out.println(amarelo + negrito + " 💫 FIM DAS INFORMAÇÕES 💫" + ciano);
        System.out.println("╚══════════════════════════╝" + reset);

        System.out.println();
        System.out.print(amarelo + " Pressione ENTER para voltar ao menu..." + reset);
        scanner.nextLine();

    }

    public void exibirBattleAttributes() throws Exception {

        String json = buscaPokemon();
        final var objectMapper = new ObjectMapper();
        final var dadosPokemon = objectMapper.readValue(json, Pokemon.class);

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "     ⚡ ATRIBUTOS DE BATALHA ⚡     " + ciano + "║");
        System.out.println("╠══════════════════════════════════╣" + reset);

        for (Stats atributo : dadosPokemon.getStats()) {
            System.out.println(
                    verde + " " + atributo.getStat().getName()
                            + reset + ": "
                            + amarelo + negrito + atributo.getBase_stat() + reset
            );
        }

        System.out.println(ciano + "╠══════════════════════════════════╣");
        System.out.println(amarelo + negrito + "   💫 FIM DOS ATRIBUTOS 💫");
        System.out.println(ciano + "╚══════════════════════════════════╝" + reset);

        System.out.println();
        System.out.print(amarelo + " Pressione ENTER para voltar ao menu..." + reset);
        scanner.nextLine();
    }

    public void exibirAbility() throws Exception {
        String json = buscaPokemon();

        final var objectMapper = new ObjectMapper();
        final var dadosAbility = objectMapper.readValue(json, Pokemon.class);


        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "      ✨ HABILIDADES POKÉMON ✨    " + ciano + "║");
        System.out.println("╠══════════════════════════════════╣" + reset);

        for (Abilities abilitie : dadosAbility.getAbilities()) {
            System.out.println(
                    verde + " Slot " + abilitie.getSlot()
                            + reset + ": "
                            + amarelo + negrito
                            + abilitie.getAbility().getName()
                            + reset
            );
        }

        System.out.println(ciano + "╠══════════════════════════════════╣");
        System.out.println(amarelo + negrito + "     💫 FIM DAS HABILIDADES 💫");
        System.out.println(ciano + "╚══════════════════════════════════╝" + reset);

        System.out.println();
        System.out.print(amarelo + " Pressione ENTER para voltar ao menu..." + reset);

        scanner.nextLine();
    }

    public String pokemonSpecies() throws JsonProcessingException {
        String url = "https://pokeapi.co/api/v2/pokemon-species/" + controller.getNomePokemon();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        String json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

        final var objectMapper = new ObjectMapper();
        final var dadosId = objectMapper.readValue(json, Pokemon.class);

        String setId = dadosId.getEvolution_chain().getUrl();

        controller.setUrlEvolution(setId);

        return json;
    }

    public void exibirEvolutions() throws Exception {
        String json = buscaPokemon();

        final var objectMapper = new ObjectMapper();
        final var dadosSpecies = objectMapper.readValue(json, Pokemon.class);


        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "     🧬 EVOLUÇÕES POKÉMON 🧬       " + ciano + "║");
        System.out.println("╠══════════════════════════════════╣" + reset);

// Pokémon inicial
        System.out.println(
                verde + " 🌱 Inicial: "
                        + amarelo + negrito
                        + dadosSpecies.getChain().getSpecies().getName()
                        + reset
        );

// Primeira evolução
        for (Evolves_to specie : dadosSpecies.getChain().getEvolves_to()) {

            System.out.println(
                    ciano + "       ↓" + reset
            );

            System.out.println(
                    verde + " ⚡ Evolução: "
                            + amarelo + negrito
                            + specie.getSpecies().getName()
                            + reset
            );

            // Segunda evolução
            for (Evolves_to evolution : specie.getEvolves_to()) {

                System.out.println(
                        ciano + "       ↓" + reset
                );

                System.out.println(
                        verde + " 🌟 Evolução final: "
                                + amarelo + negrito
                                + evolution.getSpecies().getName()
                                + reset
                );
            }
        }

        System.out.println(ciano + "╠══════════════════════════════════╣");
        System.out.println(amarelo + negrito + "      💫 FIM DAS EVOLUÇÕES 💫");
        System.out.println(ciano + "╚══════════════════════════════════╝" + reset);

        System.out.println();
        System.out.print(amarelo + " Pressione ENTER para voltar ao menu..." + reset);
        scanner.nextLine();
    }

    public void exbirInformacoesBio() throws JsonProcessingException {

        String json = pokemonSpecies();

        final var objectMapper = new ObjectMapper();
        final var dadosBio = objectMapper.readValue(json, Pokemon.class);

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "    🧬 INFORMAÇÕES BIOLÓGICAS    " + ciano + "║");
        System.out.println("╠══════════════════════════════════╣" + reset);

        System.out.println(
                verde + " 🌿 Habitat: "
                        + amarelo + negrito + dadosBio.getHabitat().getName()
                        + reset
        );

        System.out.println(
                verde + " 🎨 Cor: "
                        + amarelo + negrito + dadosBio.getColor().getName()
                        + reset
        );

        System.out.println(
                verde + " 🐾 Forma: "
                        + amarelo + negrito + dadosBio.getShape().getName()
                        + reset
        );

        System.out.println(
                verde + " \uD83C\uDFAF Taxa de captura: "
                        + amarelo + negrito + dadosBio.getCapture_rate()
                        + reset
        );

        System.out.println(
                verde + " ❤\uFE0F Felicidade base: "
                        + amarelo + negrito + dadosBio.getBase_happiness()
                        + reset
        );

        System.out.println(
                verde + " \uD83E\uDD5A Ciclos de incubação: "
                        + amarelo + negrito + dadosBio.getHatch_counter()
                        + reset
        );

        System.out.println(
                verde + " \uD83D\uDCC5 Geração: "
                        + amarelo + negrito + dadosBio.getGeneration().getName()
                        + reset
        );

        if (dadosBio.getFlavor_text_entries() != null
                && !dadosBio.getFlavor_text_entries().isEmpty()) {

            System.out.println(ciano + "──────────────────────────────────" + reset);

            System.out.println(
                    verde + " 📖 Descrição: "
                            + amarelo + dadosBio.getFlavor_text_entries()
                            .get(0).getFlavor_text()
                            + reset
            );
        }

        System.out.println(ciano + "╠══════════════════════════════════╣");
        System.out.println(amarelo + negrito + "    💫 FIM DAS INFORMAÇÕES 💫");
        System.out.println(ciano + "╚══════════════════════════════════╝" + reset);

        System.out.println();
        System.out.print(amarelo + " Pressione ENTER para voltar ao menu..." + reset);
        scanner.nextLine();

    }

    public void exibirMoves () throws Exception {
        String json = buscaPokemon();

        final var objectMapper = new ObjectMapper();
        final var dadosMoves = objectMapper.readValue(json, Pokemon.class);

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "       ⚔️ INFORMAÇÕES DO GOLPE    " + ciano + "║");
        System.out.println("╠══════════════════════════════════╣" + reset);

        System.out.println(
                verde + " \uD83E\uDD4A Golpe selecionado: "
                        + amarelo + negrito + controller.getMove()
                        + reset
        );

        System.out.println(
                verde + " 💥 Poder: "
                        + amarelo + negrito + dadosMoves.getPower()
                        + reset
        );

        System.out.println(
                verde + " 🎯 Precisão: "
                        + amarelo + negrito + dadosMoves.getAccuracy()
                        + reset
        );

        System.out.println(
                verde + " 🔋 PP: "
                        + amarelo + negrito + dadosMoves.getPp()
                        + reset
        );

        System.out.println(
                verde + " ⚡ Prioridade: "
                        + amarelo + negrito + dadosMoves.getPriority()
                        + reset
        );

        System.out.println(ciano + "╠══════════════════════════════════╣");
        System.out.println(amarelo + negrito + "       ✨ FIM DAS INFORMAÇÕES ✨");
        System.out.println(ciano + "╚══════════════════════════════════╝" + reset);

        System.out.println();
        System.out.print(amarelo + " Pressione ENTER para voltar ao menu..." + reset);
        scanner.nextLine();

    }


}



