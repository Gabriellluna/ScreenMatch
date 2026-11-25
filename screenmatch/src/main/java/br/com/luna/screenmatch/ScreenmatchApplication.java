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

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        Optional<Integer> maior = numeros.stream()
                .max(Comparator.comparing(Integer::intValue));

        System.out.println(maior.get());

        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");

        Map<Integer, List<String>> palavrasagrupadas = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(palavrasagrupadas);

        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");

        String tudo = nomes.stream()
                .collect(Collectors.joining(","));

        System.out.println(tudo);

        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer numeros3 = numeros2.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> (n * n))
                .reduce(0, Integer::sum);

        System.out.println(numeros3);

        List<Integer> numeros4 = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> particionado = numeros4.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Pares: " + particionado.get(true));  // Esperado: [2, 4, 6]
        System.out.println("Ímpares: " + particionado.get(false)); // Esperado: [1, 3, 5]


//      Principal  principal = new Principal();
//      principal.exibeMenu();

    }
}
