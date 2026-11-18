package br.com.luna.screenmatch;

import br.com.luna.screenmatch.model.PlayerResponse;
import br.com.luna.screenmatch.model.Team;
import br.com.luna.screenmatch.model.TeamReponse;
import br.com.luna.screenmatch.principal.Principal;
import br.com.luna.screenmatch.service.ConsumoApi;
import br.com.luna.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.exibeMenu();
    }
}
