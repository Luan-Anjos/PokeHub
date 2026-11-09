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
                metodo.namePokemon();
                while (true) {
                    String escolhaBusca = metodo.opcaoBusca();

                    if (escolhaBusca.equals("X") || escolhaBusca.equals("x")) {
                        break;
                    }

                    if (escolhaBusca.equals("A") || escolhaBusca.equals("a")) {
                        metodo.exibirBuscaPokemon();
                    } else if (escolhaBusca.equals("B") || escolhaBusca.equals("b")) {
                        metodo.exibirBattleAttributes();
                    } else if (escolhaBusca.equals("C") || escolhaBusca.equals("c")) {
                        metodo.exibirAbility();
                    } else if (escolhaBusca.equals("D") || escolhaBusca.equals("d")) {
                        metodo.exibirEvolutions();
                    } else if (escolhaBusca.equals("E") || escolhaBusca.equals("e")) {
                        metodo.exbirInformacoesBio();
                    } else if (escolhaBusca.equals("F") || escolhaBusca.equals("f")) {
                        metodo.pokeMoves();
                        metodo.exibirMoves();
                    } else {
                        System.out.println("Essa opção não é válida: ");
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