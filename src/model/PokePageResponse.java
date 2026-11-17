package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokePageResponse {

    private int count;
    private String next;
    private String previous;
    private List<PokePage> results;

    public List<PokePage> getResults() {
        return results;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }
}