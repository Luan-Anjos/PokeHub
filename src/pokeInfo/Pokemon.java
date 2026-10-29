package pokeInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    int id;
    String name;
    int height;
    double weight;
    double base_experience;
    Habitat habitat;
    List<Stats> stats;
    List<Abilities> abilities;


    public int getId() {
        return id;
    }

    public double getBase_experience() {
        return base_experience;
    }

    public double getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }


    public Habitat getHabitat() {
        return habitat;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }
}
