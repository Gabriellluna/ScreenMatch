package br.com.luna.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Team(
        @JsonAlias("idTeam") Integer idTeam,
        @JsonAlias("strTeam") String name,
        @JsonAlias("strStadium") String stadium) {
}
