package br.com.luna.screenmatch;

import br.com.luna.screenmatch.model.Serie;
import br.com.luna.screenmatch.service.ConsumoApi;
import br.com.luna.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JacksonJsonParser;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        ConverteDados converte = new ConverteDados();
        System.out.println("ScreenmatchApplication started");
        ConsumoApi api = new ConsumoApi();
        String nomeCodificado = "gilmore+girls";
        var json = api.ObterDados(String.format("https://www.omdbapi.com/?t=%s&apikey=d6539f72", nomeCodificado));
        System.out.println(json);
        Serie serie = converte.obterDados(json, Serie.class);
        System.out.println("Dados do objeto série: "+ serie.toString());
    }
}
