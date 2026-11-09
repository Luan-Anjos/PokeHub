package services;

public class Controller {

    private String nomePokemon;
    private String UrlEvolution;
    private String move;
    private String UrlRequisicao;
    private String select;
    private int page;


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

    public String getUrlRequisicao() {
        return UrlRequisicao;
    }

    public void setUrlRequisicao(String urlRequisicao) {
        UrlRequisicao = urlRequisicao;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
