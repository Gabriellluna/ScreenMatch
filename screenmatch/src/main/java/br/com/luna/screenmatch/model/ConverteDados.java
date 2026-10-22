package br.com.luna.screenmatch.model;

public interface ConverteDados {
    //aqui nós definimos um metodo que nao sabe ainda qual tipo de classe ele vai retornar
    //já que podemos converterdados para qualquer Classe, e como criamos permitindo o retorno de
    //qualquer tipo, nos parametros da funcao temos que deixar ele passar uma classe

    <T> T obterDados(String json, Class<T> clazz);

}
