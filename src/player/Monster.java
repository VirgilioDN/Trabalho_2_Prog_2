package player;

import app.Game;
import classe_monstros.*;
import java.util.ArrayList;
import java.util.Random;

public class Monster extends Player {

    private static ArrayList<Monster> monstros = new ArrayList<>();
    // Goblin, Aranha, Gárgulas, Esqueleto, Zumbi, Gnomo, Lobo (90)(75)(50)
    // Orc atirador, Bruxa, Troll, Andarilho, Zabur (10)(25)(50)
    // Medusa, Dragão, Harag
    static final double PESOS_FACIL[] = { 0.20, 0.30, 0.40, 0.50, 0.60, 0.70, 0.90, 0.92, 0.95, 0.97, 0.98, 1.0 };
    static final double PESOS_MEDIO[] = { 0.10, 0.20, 0.35, 0.40, 0.50, 0.60, 0.70, 0.75, 0.85, 0.90, 0.95, 1.0 };
    static final double PESOS_DIFICIL[] = { 0.07, 0.14, 0.21, 0.28, 0.35, 0.42, 0.50, 0.60, 0.70, 0.80, 0.90, 1.0 };

    public Monster(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
        super(name, forca, constituicao, destreza, intelecto, aggro);
        monstros.add(this);
    }

    public static void addInList(Monster m) {
        monstros.add(m);
    }

    public static void limparLista() {
        monstros.clear();
    }

    public static void tipoMonstros(int qtd, double pesos[]) {
        for (int i = 0; i < qtd; i++) {
            double opcao = Math.random();
            System.out.println("Opcao: " + opcao);
            if (opcao <= pesos[0]) {
                Goblin goblin = new Goblin();

                // players.add(new Monster("Goblin", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[1]) {
                Aranha aranha = new Aranha();
                // players.add(new Monster("Orc", 15, 15, 15, 15, 1));
            } else if (opcao <= pesos[2]) {
                Gargula gargula = new Gargula();
                // players.add(new Monster("Esqueleto", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[3]) {
                Esqueleto esqueleto = new Esqueleto();
                // players.add(new Monster("Zumbi", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[4]) {
                Zumbi zumbi = new Zumbi();
                // players.add(new Monster("Zumbi", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[5]) {
                Gnomo gnomo = new Gnomo();
                // players.add(new Monster("Zumbi", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[6]) {
                Lobo lobo = new Lobo();
                // players.add(new Monster("Zumbi", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[7]) {
                OrcAtirador orc = new OrcAtirador();
                // players.add(new Monster("Zumbi", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[8]) {
                Bruxa bruxa = new Bruxa();
                // players.add(new Monster("Zumbi", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[9]) {
                Troll troll = new Troll();
                // players.add(new Monster("Zumbi", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[10]) {
                Andarilho andarilho = new Andarilho();
                // players.add(new Monster("Zumbi", 10, 10, 10, 10, 1));
            } else if (opcao <= pesos[11]) {
                Zabur zabur = new Zabur();
                // players.add(new Monster("Lobo", 10, 10, 10, 10, 1));
            }
            System.out.println("Monstro " + monstros.get(i).getName() + " criado!");
        }
    }

    public static void criaMonstros() {
        int qtd;
        Random r = new Random();
        if (Game.getDificuldade() == Game.Level.FACIL) {
            qtd = 4;
            tipoMonstros(qtd, PESOS_FACIL);
        } else if (Game.getDificuldade() == Game.Level.MEDIO) {
            qtd = r.nextInt(4, 6);
            tipoMonstros(qtd, PESOS_MEDIO);
        } else if (Game.getDificuldade() == Game.Level.DIFICIL) {
            qtd = r.nextInt(4, 7);
            tipoMonstros(qtd, PESOS_DIFICIL);
        }
    }

    public static ArrayList<Monster> getMonstros() {
        return monstros;
    }
}
