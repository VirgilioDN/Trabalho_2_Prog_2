package app;

import player.IA;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Turno.Turno;
import app.Game.Level;
import classe_monstros.Dragao;
import classe_monstros.Harag;
import classe_monstros.Medusa;
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
            Level level = Game.getDificuldade();
            if (level == Level.DIFICIL) {
                Dragao dragao = new Dragao();
                Monster.addInList(dragao);
            } else if (level == Level.MEDIO) {
                Medusa med = new Medusa();
                Monster.addInList(med);
            } else {
                Harag hereg = new Harag();
                Monster.addInList(hereg);
            }
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
