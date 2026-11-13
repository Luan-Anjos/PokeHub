import services.Controller;
import services.ApiService;
import methods.Metodos;

public class Main {
    public static void main(String[] args) throws Exception {


        Controller controller = new Controller();

        ApiService apiService = new ApiService(controller);
        Metodos metodo = new Metodos(controller, apiService);


        while (true) {
            int escolha = metodo.menu();

            if (escolha == 0) {
                System.out.println("Obrigado por usar o PokeHub! 👋");
                break;
            }

            if (escolha == 1) {


                if (controller.getOptionBuscaPokemon(true)){
                    apiService.pokedex();
                }else {
                    metodo.namePokemon();
                    while (true) {
                        String escolhaBusca = metodo.opcaoBusca();

                        if (escolhaBusca.equals("X") || escolhaBusca.equals("x")) {
                            break;
                        }

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

            } else if (escolha == 2) {
                metodo.exibirPaginacao();
            } else if (escolha == 3) {

            } else if (escolha == 4) {

            } else {
                System.out.println("Opção inválida: Digite uma das opções que estão exibidas no terminal!");
            }
        }


    }


}