package methods;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pokeInfo.*;
import services.Controller;
import services.ApiService;

import java.util.Scanner;

public class Metodos {

    int escolha;
    String escolhaBusca;

    private final Controller controller;
    private final ApiService apiService;

    public Metodos(Controller controller, ApiService apiService) {
        this.controller = controller;
        this.apiService = apiService;
    }

    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    Scanner scanner = new Scanner(System.in);

    public void namePokemon() {
        limparTerminal();

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "         🔎 BUSCAR POKÉMON         " + ciano + "║");
        System.out.println("╚══════════════════════════════════╝" + reset);

        System.out.print(amarelo + negrito
                + " ⚡ Digite o nome do Pokémon: "
                + reset);

        String pokemon = scanner.nextLine();
        controller.setNomePokemon(pokemon);
    }

    public int opcao() {
        escolha = menu();
        return escolha;
    }

    public int menu() {
        limparTerminal();

        // Cores padrão do PokeHub
        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String preto = "\u001B[30m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "          ✦ POKÉMON INFORMATION SYSTEM ✦       " + ciano + "║");
        System.out.println("║" + amarelo + negrito + "                     POKEHUB                  " + ciano + "║");
        System.out.println("╠══════════════════════════════════════════════╣" + reset);

        System.out.println(amarelo + "  Sua jornada pelo mundo Pokémon começa aqui." + reset);

        System.out.println(ciano + "╠══════════════════════════════════════════════╣");
        System.out.println("║" + amarelo + negrito + "                  MENU PRINCIPAL               " + ciano + "║");
        System.out.println("╠══════════════════════════════════════════════╣" + reset);

        System.out.println(amarelo + negrito + " 01 " + reset + " " + ciano + "🔎 Buscar Pokémon" + reset);
        System.out.println("     Consulte dados e características");
        System.out.println();

        System.out.println(amarelo + negrito + " 02 " + reset + " " + ciano + "🧬 Explorar tipos" + reset);
        System.out.println("     Tipos, vantagens e fraquezas");
        System.out.println();

        System.out.println(amarelo + negrito + " 03 " + reset + " " + ciano + "⚖️ Comparar Pokémon" + reset);
        System.out.println("     Compare atributos e estatísticas");
        System.out.println();

        System.out.println(amarelo + negrito + " 04 " + reset + " " + ciano + "ℹ️ Sobre o PokeHub" + reset);
        System.out.println("     Informações sobre o projeto");
        System.out.println();

        System.out.println(amarelo + negrito + " 00 " + reset + " " + ciano + "🚪 Sair" + reset);
        System.out.println("     Encerrar a aplicação");

        System.out.println(ciano + "╠══════════════════════════════════════════════╣" + reset);
        System.out.print(amarelo + negrito + " ⚡ Escolha uma opção: " + reset);
        escolha = scanner.nextInt();
        scanner.nextLine();

        return escolha;
    }

    public String opcaoBusca() {
        escolhaBusca = menuBuscaPoke();
        return escolhaBusca;
    }

    public String menuBuscaPoke() {
        limparTerminal();

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "       ⚡ MENU DO POKÉMON ⚡       " + ciano + "║");
        System.out.println("╠══════════════════════════════════╣" + reset);

        System.out.println(" Pokémon selecionado: "
                + verde + negrito + controller.getNomePokemon() + reset);

        System.out.println(ciano + "──────────────────────────────────" + reset);

        System.out.println(amarelo + negrito + " A " + reset + " - Dados básicos");
        System.out.println(amarelo + negrito + " B " + reset + " - Atributos de batalha");
        System.out.println(amarelo + negrito + " C " + reset + " - Habilidades");
        System.out.println(amarelo + negrito + " D " + reset + " - Evoluções");
        System.out.println(amarelo + negrito + " E " + reset + " - Informações biológicas");
        System.out.println(amarelo + negrito + " F " + reset + " - Movimentos e ataques");
        System.out.println(amarelo + negrito + " X " + reset + " - Voltar ao menu principal");

        System.out.println(ciano + "╠══════════════════════════════════╣" + reset);
        System.out.print(amarelo + negrito + " ⚡ Escolha uma opção: " + reset);
        escolhaBusca = scanner.nextLine();
        controller.setSelect(escolhaBusca);

        if (escolhaBusca.equalsIgnoreCase("A") || escolhaBusca.equalsIgnoreCase("B") || escolhaBusca.equalsIgnoreCase("C")) {
            controller.setUrlRequisicao("https://pokeapi.co/api/v2/pokemon/");
        } else if (escolhaBusca.equalsIgnoreCase("D")) {
            return escolhaBusca;
        } else if (escolhaBusca.equalsIgnoreCase("E")) {
            controller.setUrlRequisicao("https://pokeapi.co/api/v2/pokemon-species/");
        } else if (escolhaBusca.equalsIgnoreCase("F")) {
            controller.setUrlRequisicao("https://pokeapi.co/api/v2/move/");
        } else {
            System.out.println("Falha ou inserir a URL!");
        }

        return escolhaBusca;
    }

    public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pokeMoves() {
        limparTerminal();

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();

        System.out.println(ciano + "╔══════════════════════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "       ⚔️ DIGITE O NOME DO ATAQUE (MOVE)       " + ciano + "   ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + reset);

        System.out.print(amarelo + negrito
                + " ⚡ Digite o nome do ataque: "
                + reset);
        String buscaMove = scanner.nextLine();
        controller.setMove(buscaMove);
    }

    public void exibirBuscaPokemon() throws Exception {
        limparTerminal();
        String json = apiService.buscaPokemon();
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
        limparTerminal();
        String json = apiService.buscaPokemon();
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
        limparTerminal();
        String json = apiService.buscaPokemon();

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

    public void exibirEvolutions() throws Exception {
        limparTerminal();
        String json = apiService.buscaPokemon();

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
        limparTerminal();

        String json = apiService.pokemonSpecies();

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
        limparTerminal();

        String json = apiService.buscaPokemon();

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

    public void exibirPaginacao() throws JsonProcessingException {

        limparTerminal();

        int contador = 0;

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        String enter;

        while (true) {
            int numeroPokedex = contador + 1;

            String json = apiService.pokedex();

            final var objectMapper = new ObjectMapper();
            PokePage dadosPage = objectMapper.readValue(json, PokePage.class);

            System.out.println();
            System.out.println(ciano + "╔══════════════════════════════════╗");
            System.out.println("║" + amarelo + negrito + "          📖 POKÉDEX              " + ciano + "║");
            System.out.println("╠══════════════════════════════════╣" + reset);


            for (Species pokemon : dadosPage.getResults()) {
                System.out.println(verde + numeroPokedex + ": " + amarelo + pokemon.getName() + reset);
                numeroPokedex++;
            }

            System.out.println(ciano + "╠══════════════════════════════════╣");
            System.out.println(amarelo + " [ENTER] " + verde + "Próxima página");
            System.out.println(amarelo + " [-]     " + verde + "Página anterior");
            System.out.println(amarelo + " [X]     " + verde + "Sair");
            System.out.println(ciano + "╚══════════════════════════════════╝" + reset);

            System.out.print(amarelo + " Escolha uma opção: " + reset);
            enter = scanner.nextLine();
            controller.setNumeroPokedex(enter);

            if ("X".equalsIgnoreCase(enter)) {
                controller.setPage(0);
                break;
            } else if ("".equals(enter)) {
                contador += 20;
                controller.setPage(contador);
            } else if ("-".equals(enter)) {
                controller.setNumeroPokedex(enter);

                if (contador <= 0) {
                    System.out.println(
                            "\n" + amarelo + " ⚠ Você já está na primeira página!" + reset
                    );
                } else {
                    contador -= 20;
                    controller.setPage(contador);
                }
            } else {
                System.out.println(
                        "\n" + amarelo + " ⚠ Opção inválida. Tente novamente." + reset
                );
            }
        }
    }


}

