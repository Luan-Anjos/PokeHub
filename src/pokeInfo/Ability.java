package pokeInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Ability {
    String name;

    public String getName() {
        return name;
    }
}
