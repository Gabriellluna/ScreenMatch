package br.com.luna.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Serie(
        @JsonAlias("Title") String title,
        @JsonAlias("imdbRating") String avaliacao,
        @JsonAlias("totalSeasons") Integer totalTemporadas) {
}
