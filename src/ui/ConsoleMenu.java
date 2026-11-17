package ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import controller.NavigationController;
import service.ApiService;

import java.util.Scanner;

public class ConsoleMenu {

    int escolha;
    String escolhaBusca;

    private final NavigationController navigationController;
    private final ApiService apiService;

    public ConsoleMenu(NavigationController navigationController, ApiService apiService) {
        this.navigationController = navigationController;
        this.apiService = apiService;
    }

    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    Scanner scanner = new Scanner(System.in);

    public void namePokemon() throws JsonProcessingException {
        limparTerminal();

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String cinza = "\u001B[37m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();
        System.out.println(ciano + "╔══════════════════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "               🔎 BUSCAR POKÉMON               " + ciano + "║");
        System.out.println("╠══════════════════════════════════════════════╣" + reset);

        System.out.println(amarelo + negrito + " [1] " + verde + "📖 Abrir Pokédex" + reset);
        System.out.println(cinza + "     Recomendado: veja os nomes exatos antes" + reset);
        System.out.println();

        System.out.println(amarelo + negrito + " [2] " + verde + "⚡ Buscar por nome" + reset);
        System.out.println(cinza + "     Digite o nome exato (confira na Pokédex)" + reset);

        System.out.println(ciano + "╚══════════════════════════════════════════════╝" + reset);
        System.out.print(amarelo + " ⚡ Escolha uma opção: " + reset);

        int optionBuscaPokemon = scanner.nextInt();

        scanner.nextLine();

        if(optionBuscaPokemon == 1){
            navigationController.setOptionBuscaPokemon(true);
        } else if (optionBuscaPokemon == 2){
            System.out.print(amarelo + negrito
                    + " ⚡ Digite o nome do Pokémon: "
                    + reset);
            String pokemon = scanner.nextLine();
            navigationController.setNomePokemon(pokemon);
        }


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
        String cinza = "\u001B[37m";
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
        System.out.println(cinza + "     Pokédex paginada e ficha técnica completa" + reset);
        System.out.println();

        System.out.println(amarelo + negrito + " 02 " + reset + " " + ciano + "ℹ️  Sobre o PokeHub" + reset);
        System.out.println(cinza + "     Informações, arquitetura e roadmap" + reset);
        System.out.println();

        System.out.println(amarelo + negrito + " 00 " + reset + " " + ciano + "🚪 Sair" + reset);
        System.out.println(cinza + "     Encerrar a aplicação" + reset);

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
                + verde + negrito + navigationController.getNomePokemon() + reset);

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
        navigationController.setSelect(escolhaBusca);

        if (escolhaBusca.equalsIgnoreCase("A") || escolhaBusca.equalsIgnoreCase("B") || escolhaBusca.equalsIgnoreCase("C")) {
            navigationController.setUrlRequisicao("https://pokeapi.co/api/v2/pokemon/");
        } else if (escolhaBusca.equalsIgnoreCase("D")) {
            return escolhaBusca;
        } else if (escolhaBusca.equalsIgnoreCase("E")) {
            navigationController.setUrlRequisicao("https://pokeapi.co/api/v2/pokemon-species/");
        } else if (escolhaBusca.equalsIgnoreCase("F")) {
            navigationController.setUrlRequisicao("https://pokeapi.co/api/v2/move/");
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
        navigationController.setMove(buscaMove);
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
        for (EvolvesTo specie : dadosSpecies.getChain().getEvolves_to()) {

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
            for (EvolvesTo evolution : specie.getEvolves_to()) {

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
                        + amarelo + negrito + navigationController.getMove()
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
            navigationController.setNumeroPokedex(enter);

            if ("X".equalsIgnoreCase(enter)) {
                navigationController.setPage(0);
                break;
            } else if ("".equals(enter)) {
                contador += 20;
                navigationController.setPage(contador);
            } else if ("-".equals(enter)) {
                navigationController.setNumeroPokedex(enter);

                if (contador <= 0) {
                    System.out.println(
                            "\n" + amarelo + " ⚠ Você já está na primeira página!" + reset
                    );
                } else {
                    contador -= 20;
                    navigationController.setPage(contador);
                }
            } else if ("x".equalsIgnoreCase("x")) {
                break;
            } else {
                System.out.println(
                        "\n" + amarelo + " ⚠ Opção inválida. Tente novamente." + reset
                );
            }
        }
    }

    public void exibirSobre() {
        limparTerminal();

        String amarelo = "\u001B[93m";
        String ciano = "\u001B[96m";
        String verde = "\u001B[92m";
        String cinza = "\u001B[37m";
        String reset = "\u001B[0m";
        String negrito = "\u001B[1m";

        System.out.println();
        System.out.println(ciano + "╔════════════════════════════════════════════════════════════╗");
        System.out.println("║" + amarelo + negrito + "                    ℹ️  SOBRE O POKEHUB                     " + ciano + "║");
        System.out.println("╠════════════════════════════════════════════════════════════╣" + reset);

        System.out.println(verde + negrito + "  📌 O PROJETO" + reset);
        System.out.println(cinza + "  Aplicação CLI desenvolvida em Java para exploração de" + reset);
        System.out.println(cinza + "  dados do universo Pokémon em tempo real via PokeAPI." + reset);
        System.out.println();

        System.out.println(verde + negrito + "  ⚙️  TECNOLOGIAS & ARQUITETURA" + reset);
        System.out.println(amarelo + "  • " + cinza + "Java (Orientação a Objetos & Coleções)" + reset);
        System.out.println(amarelo + "  • " + cinza + "Java HttpClient (Consumo assíncrono de API REST)" + reset);
        System.out.println(amarelo + "  • " + cinza + "Jackson Databind (Desserialização JSON)" + reset);
        System.out.println(amarelo + "  • " + cinza + "Arquitetura em Camadas (Model, Service, Controller, UI)" + reset);
        System.out.println();

        System.out.println(verde + negrito + "  🚀 FUNCIONALIDADES ATUAIS" + reset);
        System.out.println(amarelo + "  • " + cinza + "Pokédex interativa com paginação dinâmica" + reset);
        System.out.println(amarelo + "  • " + cinza + "Ficha completa: atributos, habilidades, evoluções e golpes" + reset);
        System.out.println();

        System.out.println(verde + negrito + "  🔄 EVOLUÇÃO CONTÍNUA (ROADMAP)" + reset);
        System.out.println(cinza + "  Projeto em constante refatoração e melhoria de código." + reset);
        System.out.println(amarelo + "  • " + cinza + "Em breve: Persistência local em JSON (Favoritos/Time)" + reset);
        System.out.println(amarelo + "  • " + cinza + "Em breve: Tratamento avançado de exceções e cache" + reset);
        System.out.println();

        System.out.println(verde + negrito + "  👨‍💻 DESENVOLVEDOR" + reset);
        System.out.println(cinza + "  Criado por Luan como projeto prático da trilha Java." + reset);

        System.out.println(ciano + "╚════════════════════════════════════════════════════════════╝" + reset);
        System.out.print(amarelo + "\n  Pressione [ENTER] para voltar ao menu principal..." + reset);
        scanner.nextLine();
    }


}

