package pokeInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Shape {
    private String name;

    public String getName() {
        return name;
    }
}
