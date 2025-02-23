package app;

import player.IA;

import java.util.ArrayList;

import Turno.Turno;
import player.Hero;
import player.Monster;

public class App {
    public static void main(String[] args) throws  Exception {
        Game game = new Game();
        ArrayList<Hero> herois = Hero.getHerois();
        ArrayList<Monster> monstros = Monster.getMonstros();
        Turno t = new Turno(herois, monstros);
        t.jogarTurno(new Hero(),game);
    }
}
