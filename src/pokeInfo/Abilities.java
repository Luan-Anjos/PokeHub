package pokeInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Abilities {
    String is_hidden;
    int slot;
    Ability ability;

    public String getIs_hidden() {
        return is_hidden;
    }

    public int getSlot() {
        return slot;
    }

    public Ability getAbility() {
        return ability;
    }
}
