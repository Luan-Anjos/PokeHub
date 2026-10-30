package pokeInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Evolves_to {
    Species species;
    List<Evolves_to> evolves_to;

    public Species getSpecies() {
        return species;
    }

    public List<Evolves_to> getEvolves_to() {
        return evolves_to;
    }
}
