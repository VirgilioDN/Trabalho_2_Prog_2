package app;

import Turno.Turno;
import app.Game.Level;
import classe_monstros.Andarilho;
import classe_monstros.Aranha;
import classe_monstros.Bruxa;
import classe_monstros.Dragao;
import classe_monstros.Esqueleto;
import classe_monstros.Harag;
import classe_monstros.Lobo;
import classe_monstros.Medusa;
import classe_monstros.OrcAtirador;
import java.util.ArrayList;
import log.Log;
import player.Hero;
import player.Monster;
import player.Player;

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
            Player.limparLista();
            monstros.clear();
            Monster.limparLista();

            Level l = game.getDificuldade();

            for (Hero h : herois) {
                Player.addInList(h);
            }

            if(l == Level.DIFICIL){
                Dragao dragao = new Dragao();
                Bruxa bruxa = new Bruxa();
                OrcAtirador orc = new OrcAtirador();
            }
            else if(l == Level.MEDIO){
                Medusa med = new Medusa();
                Andarilho and = new Andarilho();
                Lobo lobo = new Lobo();
            }
            else{
                Harag hereg = new Harag();
                Aranha a = new Aranha();
                Esqueleto esq = new Esqueleto();
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
        Log.mostrarHistorico();
    }
}
