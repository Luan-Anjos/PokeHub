package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlavorTextEntries {
    private String flavor_text;

    public String getFlavor_text() {
        return flavor_text;
    }
}
