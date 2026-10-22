package br.com.luna.screenmatch.service;

import br.com.luna.screenmatch.model.Serie;
import tools.jackson.databind.ObjectMapper;

public class ConverteDados implements br.com.luna.screenmatch.model.ConverteDados {
    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public <T> T obterDados(String json, Class<T> clazz) {
        return objectMapper.readValue(json, clazz);
    }
}
