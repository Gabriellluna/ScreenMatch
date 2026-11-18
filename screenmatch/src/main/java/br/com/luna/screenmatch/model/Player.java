package br.com.luna.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Player(
        @JsonAlias("strPlayer") String name,
        @JsonAlias("strNationality") String nationality
        ) {
}
