package app;

import player.IA;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Turno.Turno;
import player.Hero;
import player.Monster;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Hero heroGeneric = new Hero();
        ArrayList<Hero> herois = Hero.getHerois();
        ArrayList<Monster> monstros = Monster.getMonstros();
        System.out.println();
        System.out.println("Agora, vamos começar o jogo! Você enfrentará os monstros!");
        System.out.println();
        Turno t = new Turno(herois, monstros);
        t.jogarTurno(new Hero(), game);
        if (heroGeneric.isTeamDead(herois)) {
            System.out.println("Você infelizmente perdeu! Quem sabe na próxima!");
            game.finalizarJogo();
        } else {
            System.out.println("Parabéns! Você venceu! Porém, nao seria tao facil, não é mesmo?");
            System.out.println("Agora, você enfrentará um inimigo mais forte!");
            System.out.println();
            monstros.clear();
            Monster.limparLista();
            Monster.criaMonstros();
            monstros = Monster.getMonstros();
            t = new Turno(herois, monstros);
            t.jogarTurno(new Hero(), game);

            if (heroGeneric.isTeamDead(herois)) {
                System.out.println("Você infelizmente perdeu! Quem sabe na próxima!");
                game.finalizarJogo();
            } else {
                System.out.println("Parabéns! Você venceu!");
                game.finalizarJogo();
            }
        }
    }
}
