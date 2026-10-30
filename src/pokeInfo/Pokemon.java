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
    List<Stats> stats;
    List<Abilities> abilities;
    Chain chain;
    Evolution_chain evolution_chain;
    Color color;
    Shape shape;
    Habitat habitat;
    List<Flavor_text_entries> flavor_text_entries;
    int capture_rate;
    int base_happiness;
    int hatch_counter;
    Generation generation;
    int accuracy;
    int pp;
    int priority;
    int power;

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

    public Chain getChain() {
        return chain;
    }

    public Evolution_chain getEvolution_chain() {
        return evolution_chain;
    }

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public List<Flavor_text_entries> getFlavor_text_entries() {
        return flavor_text_entries;
    }

    public int getCapture_rate() {
        return capture_rate;
    }

    public int getBase_happiness() {
        return base_happiness;
    }

    public int getHatch_counter() {
        return hatch_counter;
    }

    public Generation getGeneration() {
        return generation;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPp() {
        return pp;
    }

    public int getPriority() {
        return priority;
    }

    public int getPower() {
        return power;
    }
}
