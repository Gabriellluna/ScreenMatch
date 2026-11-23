package br.com.luna.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Team(
        @JsonAlias("idTeam") Integer idTeam,
        @JsonAlias("strTeam") String name,
        @JsonAlias("strStadium") String stadium,
        List<Player> players
) {
}
