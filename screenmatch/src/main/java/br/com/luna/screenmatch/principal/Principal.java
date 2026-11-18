package br.com.luna.screenmatch.principal;

import br.com.luna.screenmatch.model.PlayerResponse;
import br.com.luna.screenmatch.model.Team;
import br.com.luna.screenmatch.model.TeamReponse;
import br.com.luna.screenmatch.service.ConsumoApi;
import br.com.luna.screenmatch.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private final String ENDERECO = "https://www.thesportsdb.com/api/v1/json/123/searchteams.php?t=";
    private final String ENDERECO2 = "https://www.thesportsdb.com/api/v1/json/123/lookup_all_players.php?id=";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();

    public void exibeMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do time que deseja buscar: ");
        String time = sc.nextLine();
        String nomeCodificado = ENDERECO + time.replace(" ", "+");
        var json = consumoApi.ObterDados(nomeCodificado);

        TeamReponse arsenal = converte.obterDados(json, TeamReponse.class);
        Team firstTeam = arsenal.teams().get(0);
        System.out.println("Dados do time: " + firstTeam.name() + " - " + firstTeam.stadium());
        String nomeCodificado2 = ENDERECO2 + firstTeam.idTeam();
        var json2 = consumoApi.ObterDados(nomeCodificado2);

        PlayerResponse players = converte.obterDados(json2, PlayerResponse.class);

        players.players().forEach(System.out::println);

    }
}
