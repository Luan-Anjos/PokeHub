package pokeInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokePage {
    private List<Species> results;

    public List<Species> getResults() {
        return results;
    }

    public void setResults(List<Species> results) {
        this.results = results;
    }
}