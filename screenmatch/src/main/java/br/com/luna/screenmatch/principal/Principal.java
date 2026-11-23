package br.com.luna.screenmatch.principal;

import br.com.luna.screenmatch.model.Player;
import br.com.luna.screenmatch.model.PlayerResponse;
import br.com.luna.screenmatch.model.Team;
import br.com.luna.screenmatch.model.TeamReponse;
import br.com.luna.screenmatch.service.ConsumoApi;
import br.com.luna.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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

        String nomeCodificado2 = ENDERECO2 + firstTeam.idTeam();
        var json2 = consumoApi.ObterDados(nomeCodificado2);
        PlayerResponse players = converte.obterDados(json2, PlayerResponse.class);
        Team teamcompleto = new Team(firstTeam.idTeam(), firstTeam.name(), firstTeam.stadium(), players.players());

        System.out.println("Informações do time: " + teamcompleto.toString());

        List<Player> playerstoshow = teamcompleto.players();

        List<Player> playersnamed = playerstoshow.stream()
                .filter(player -> player.wageConverted() > 0)
                .sorted(Comparator.comparing(Player::wageConverted).reversed())
                .limit(3)
                .collect(Collectors.toList()); //quando usamos collector, isso permite que adicionemos itens à lista ou removemos
                //quando usamos toList, a lista é imutável

        for (Player player : playersnamed) {
            System.out.println(String.format("Nome: %s - Salário: %s - Nascimento: %s",  player.name(), player.wage(), player.born()));
        }

        System.out.println("A partir de que ano de nascimento deseja ver os jogadores? ");
        var ano = sc.nextInt();
        sc.nextLine();

        LocalDate data = LocalDate.parse(String.format("%d-01-01", ano));
        System.out.println("Data de nascimento: " + data);

        playerstoshow.stream()
                .filter(player -> player.bornConverted().isAfter(data))
                .forEach(player -> {
                    System.out.println("Nome: " + player.name() + " Ano de nascimento: " +
                            player.bornConverted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                });

    }
}
