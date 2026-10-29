package pokeInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Habitat {
    String name;
    String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


}
