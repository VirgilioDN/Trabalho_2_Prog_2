package app;

import java.util.Scanner;
import player.Hero;
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
        Player.listaPlayers();
    }

    public void comecarJogo() {

    }

    public enum Level{
        FACIL, MEDIO, DIFICIL;
    }

    public static void setDificuldade(){
        Scanner s = new Scanner(System.in);
        System.out.println("Escolha a dificuldade do jogo: ");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        int opcao = s.nextInt();
        if (opcao == 1){
            Game.dificuldade = Level.FACIL;
        }
        else if (opcao == 2){
            Game.dificuldade = Level.MEDIO;
        }
        else if (opcao == 3){
            Game.dificuldade = Level.DIFICIL;
        }
    }

    public static Level getDificuldade(){
        return dificuldade;
    }

}
