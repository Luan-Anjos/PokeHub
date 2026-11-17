import controller.NavigationController;
import service.ApiService;
import ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) throws Exception {


        NavigationController navigationController = new NavigationController();

        ApiService apiService = new ApiService(navigationController);
        ConsoleMenu metodo = new ConsoleMenu(navigationController, apiService);


        while (true) {
            int escolha = metodo.menu();

            if (escolha == 0) {
                System.out.println("Obrigado por usar o PokeHub! 👋");
                break;
            }

            if (escolha == 1) {
                metodo.namePokemon();

                if (navigationController.getOptionBuscaPokemon()) {
                    metodo.exibirPaginacao();
                    navigationController.setOptionBuscaPokemon(false);
                } else {
                    while (true) {
                        String escolhaBusca = metodo.opcaoBusca();

                        if (escolhaBusca.equals("X") || escolhaBusca.equals("x")) {
                            break;
                        } else {
                            if (escolhaBusca.equalsIgnoreCase("A")) {
                                metodo.exibirBuscaPokemon();
                            } else if (escolhaBusca.equalsIgnoreCase("B")) {
                                metodo.exibirBattleAttributes();
                            } else if (escolhaBusca.equalsIgnoreCase("C")) {
                                metodo.exibirAbility();
                            } else if (escolhaBusca.equalsIgnoreCase("D")) {
                                metodo.exibirEvolutions();
                            } else if (escolhaBusca.equalsIgnoreCase("E")) {
                                metodo.exbirInformacoesBio();
                            } else if (escolhaBusca.equalsIgnoreCase("F")) {
                                metodo.pokeMoves();
                                metodo.exibirMoves();
                            } else {
                                System.out.println("Essa opção não é válida: ");
                            }
                        }


                    }
                }
            } else if (escolha == 2) {
                metodo.exibirSobre();
            }  else {
                System.out.println("Opção inválida: Digite uma das opções que estão exibidas no terminal!");
            }
        }


    }


}