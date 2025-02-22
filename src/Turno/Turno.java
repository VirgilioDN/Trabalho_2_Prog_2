package Turno;

// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import player.Hero;
import player.Monster;
import player.Player;

public class Turno {

    private ArrayList<Player> ordemPlayers;
    private ArrayList<Hero> herois;
    private ArrayList<Monster> monstros;
    private int turnoAtual;

    public Turno(ArrayList<Hero> herois, ArrayList<Monster> monstros) {
        this.herois = herois;
        this.monstros = monstros;
        this.setOrdemPlayers(herois, monstros);
        this.turnoAtual = 1;
    }

    public void setOrdemPlayers(ArrayList<Hero> herois, ArrayList<Monster> monstros) {
        // Une erdena os jogadores de acordo com a velocidade
        this.ordemPlayers = new ArrayList<Player>(herois);
        this.ordemPlayers.addAll(monstros);
        this.ordemPlayers.sort((p1, p2) -> p2.getVelocidade() - p1.getVelocidade());
    }

    public ArrayList<Player> getOrdemPlayers() {
        return ordemPlayers;
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }

    public void jogarTurno(Hero h) {
        // Como nao tem a batalha ainda, pra acabar o jogo,é usado um input
        Scanner s = new Scanner(System.in);

        // Verifica se algum time está morto (se pelo menos um dos jogadores dos dois
        // times estiver vivo, continua o jogo)
        while (!h.isTeamDead(herois) && !h.isTeamDead(monstros)) {

            for (Player player : ordemPlayers) {
                // Verifica se o jogador está morto
                if (player.isDead()) {
                    System.out.println("O jogador " + player.getName() + " está morto e por isso não terá ação.");
                    continue;
                }
                // Ação do jogador
                System.out.println("Vez do jogador " + player.getName());
                if (player instanceof Hero) {
                    System.out.println("Qual mosntro você deseja atacar?");

                    // Cria array para armazenar os indices dos monstros
                    int[] q = new int[monstros.size()];
                    int i = 1;

                    // Mostra os monstros para o usuario
                    for (Monster m : monstros) {
                        q[i - 1] = i - 1;
                        System.out.println(i + "- " + m.getName());
                        i++;
                    }
                    System.out.println();

                    // Escolha de ataque
                    int escolha = s.nextInt();
                    for (int j : q) {
                        if (escolha - 1 == j) {
                            player.acao(monstros.get(j));
                        }

                    }

                } else {
                    // Ação do monstro
                    continue;
                }
            }

            // Verifica se algum time está morto para decidir o vencedor
            if (h.isTeamDead(herois)) {
                System.out.println("A batalha acabou! O time dos heróis perdeu!");
                break;
            } else if (h.isTeamDead(monstros)) {
                System.out.println("A batalha acabou! O time dos monstros perdeu!");
                break;
            }
            turnoAtual++;
        }
        s.close();
        System.out.println("A batalha possuiu " + this.turnoAtual + " turnos");

    }

}
