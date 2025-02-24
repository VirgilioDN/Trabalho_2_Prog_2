package app;

import Turno.Turno;
import log.Log;

import java.util.ArrayList;
import java.util.Scanner;

import player.Hero;
import player.IA;
import player.Monster;
import player.Player;

public class Game {
    private int qtdMonstros;
    private int qtdHerois;
    // private Turno turno;
    // private Log logs;
    private static Level dificuldade;

    public Game() {
        setDificuldade();
        Hero.criarPersonagem();
        Monster.criaMonstros();
        //Player.listaPlayers();
        //Hero.heroAtributos();
        // Hero.menuHeroi();
    }

    public void comecarJogo() {

    }

    public enum Level {
        FACIL, MEDIO, DIFICIL;
    }

    public static void setDificuldade() {
        Scanner s = new Scanner(System.in);
        System.out.println("Escolha a dificuldade do jogo: ");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        int opcao = s.nextInt();
        if (opcao == 1) {
            Log.registrarAcao("Dificuldade escolhida: Fácil" );
            Game.dificuldade = Level.FACIL;
        } else if (opcao == 2) {
            Log.registrarAcao("Dificuldade escolhida: Médio" );
            Game.dificuldade = Level.MEDIO;
        } else if (opcao == 3) {
            Log.registrarAcao("Dificuldade escolhida: Difícil" );
            Game.dificuldade = Level.DIFICIL;
        }
    }

    public static Level getDificuldade() {
        return dificuldade;
    }

}
