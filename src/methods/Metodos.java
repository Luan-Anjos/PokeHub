package methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import pokeInfo.Pokemon;
import services.Controller;
import services.Request;

import java.util.Scanner;

public class Metodos {

    int escolha;
    String escolhaBusca;

    private final Controller controller;

    public Metodos(Controller controller) {
        this.controller = controller;
    }

    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    Scanner scanner = new Scanner(System.in);

    public void namePokemon(){
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

        if (escolhaBusca.equalsIgnoreCase("A")||escolhaBusca.equalsIgnoreCase("B")||escolhaBusca.equalsIgnoreCase("C")){
            controller.setUrlRequisicao("https://pokeapi.co/api/v2/pokemon/");
        } else if (escolhaBusca.equals("D")) {
            controller.setSelect(escolhaBusca);
            controller.setUrlRequisicao(null);
        } else if (escolhaBusca.equalsIgnoreCase("E")){
            controller.setUrlRequisicao("https://pokeapi.co/api/v2/pokemon-species/");
        } else if (escolhaBusca.equalsIgnoreCase("F")){
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

    public void pokeMoves(){
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




}

