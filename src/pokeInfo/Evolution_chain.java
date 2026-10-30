package pokeInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Evolution_chain {
    String url;

    public String getUrl() {
        return url;
    }
}
