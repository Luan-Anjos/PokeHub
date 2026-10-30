package pokeInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flavor_text_entries {
    private String flavor_text;

    public String getFlavor_text() {
        return flavor_text;
    }
}
