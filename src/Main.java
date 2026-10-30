import services.Controller;
import services.Request;
import methods.Metodos;

public class Main {
    public static void main(String[] args) throws Exception {


        Controller controller = new Controller();

        Metodos metodo = new Metodos(controller);
        Request request = new Request(controller);

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
                        request.exibirBuscaPokemon();
                    } else if (escolhaBusca.equals("B") || escolhaBusca.equals("b")) {
                        request.exibirBattleAttributes();
                    } else if (escolhaBusca.equals("C") || escolhaBusca.equals("c")) {
                        request.exibirAbility();
                    } else if (escolhaBusca.equals("D") || escolhaBusca.equals("d")) {
                        request.exibirEvolutions();
                    } else if (escolhaBusca.equals("E") || escolhaBusca.equals("e")) {

                    } else if (escolhaBusca.equals("F") || escolhaBusca.equals("f")) {

                    } else if (escolhaBusca.equals("G") || escolhaBusca.equals("g")) {

                    }

                }
            } else if (escolha == 2) {

            } else if (escolha == 3) {

            } else if (escolha == 4) {

            } else {
                System.out.println("Opção inválida: Digite uma das opções que estão exibidas no terminal!");
            }
        }


    }


}