package br.com.luna.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Player(
        @JsonAlias("strPlayer") String name,
        @JsonAlias("strNationality") String nationality,
        @JsonAlias("strWage") String wage,
        @JsonAlias("dateBorn") String born
        ) {

    public long wageConverted(){
        if (wage == null || wage.isBlank()){
            return 0;
        }

        return Long.parseLong(wage.replaceAll("[^0-9]", ""));
    }

    public LocalDate bornConverted(){
        if (born == null || born.isBlank()){
            return null;
        }

        return LocalDate.parse(born);
    }
}
