package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EvolvesTo {
    Species species;
    List<EvolvesTo> evolves_to;

    public Species getSpecies() {
        return species;
    }

    public List<EvolvesTo> getEvolves_to() {
        return evolves_to;
    }
}
