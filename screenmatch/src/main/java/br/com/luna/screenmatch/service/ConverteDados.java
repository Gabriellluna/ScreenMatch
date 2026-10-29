package br.com.luna.screenmatch.service;

import br.com.luna.screenmatch.model.Serie;
import tools.jackson.databind.ObjectMapper;

public class ConverteDados implements br.com.luna.screenmatch.model.ConverteDados {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> object) {
        return objectMapper.readValue(json, object);
    }


    //<T> define que é um metodo generics
    //T após o <T> define o tipo de retorno, que por sua vez é igual ao tipo de Class
}