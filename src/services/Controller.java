package services;

public class Controller {

    private String nomePokemon;
    private String UrlEvolution;
    private String move;

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public String getUrlEvolution() {
        return UrlEvolution;
    }

    public void setUrlEvolution(String urlEvolution) {
        UrlEvolution = urlEvolution;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
