package br.com.luna.screenmatch.service;

import br.com.luna.screenmatch.model.Team;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ConverteDados implements br.com.luna.screenmatch.model.ConverteDados {
    ObjectMapper objectMapper = new ObjectMapper();

    public <T> T obterDados(String json, Class<T> object) {
        return objectMapper.readValue(json, object);
    }

    //<T> define que é um metodo generics
    //T após o <T> define o tipo de retorno, que por sua vez é igual ao tipo de Class
}