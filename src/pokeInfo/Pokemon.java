package pokeInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    int id;
    String name;
    int height;
    double weight;
    double base_experience;
    Habitat habitat;


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
}
