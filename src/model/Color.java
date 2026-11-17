package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Color {
    private String name;

    public String getName() {
        return name;
    }
}
