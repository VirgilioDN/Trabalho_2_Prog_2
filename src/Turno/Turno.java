package Turno;

// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import app.Game;
import classe_herois.Clerigo;
import classe_herois.Paladino;
import log.Log;
import player.Hero;
import player.IA;
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

    public void jogarTurno(Hero h, Game game) {
        // Input para escolher o monstro a ser atacado
        Scanner s = new Scanner(System.in);

        // Verifica se algum time está morto (se pelo menos um dos jogadores dos dois
        // times estiver vivo, continua o jogo)
        while (!h.isTeamDead(herois) && !h.isTeamDead(monstros)) {
            Log.registrarAcao("Turno " + turnoAtual);
            for (Player player : ordemPlayers) {
                Player.listaPlayers();

                if (h.isTeamDead(herois)) {
                    break;
                } else if (h.isTeamDead(monstros)) {
                    break;
                }
                // Verifica se o jogador está morto
                if (player.isDead()) {
                    System.out.println("O jogador " + player.getName() + " está morto e por isso não terá ação.");
                    continue;
                }

                // Ação do jogador
                System.out.println("Vez do jogador " + player.getName());
                Log.registrarAcao("Vez do jogador " + player.getName());
                if (player instanceof Hero) {
                    // verificando se o jogador é um clerigo (para poder curar)
                    if (player instanceof Clerigo || player instanceof Paladino) {
                        player.acaoComCura(monstros, herois, s);
                        continue;
                    }
                    System.out.println("Qual monstro você deseja atacar?");

                    // Cria array para armazenar os indices dos monstros
                    int[] q = new int[monstros.size()];
                    int i = 1;

                    try {
                        // Mostra os monstros para o usuario
                        for (Monster m : monstros) {
                            q[i - 1] = i - 1;
                            System.out.println(i + "- " + m.getName());
                            i++;
                        }
                        System.out.println();

                        // Escolha de ataque
                        int escolha = s.nextInt();

                        if (escolha < 1 || escolha > monstros.size()) {
                            System.out.println("Escolha inválida! Digite um número entre 1 e " + monstros.size());
                            continue;
                        }
                        for (int j : q) {
                            if (escolha - 1 == j) {
                                if (monstros.get(j).isDead()) {
                                    System.out.println(
                                            "Ops! Parece que o monstro escolhido está morto! Você perdeu sua vez.");
                                    Log.registrarAcao("Monstro escolhido morto.");
                                    break;
                                } else {
                                    player.acao(monstros.get(j), monstros, herois);

                                    // Verifica se o monstro morreu após o ataque
                                    if (monstros.get(j).isDead()) {
                                        Log.registrarAcao("O monstro " + monstros.get(j).getName() + " foi derrotado!");
                                        System.out
                                                .println("O monstro " + monstros.get(j).getName() + " foi derrotado!");
                                    }

                                    // Verifica se o jogador morreu após a ação
                                    if (player.isDead()) {
                                        Log.registrarAcao("O jogador " + player.getName() + " morreu durante o turno.");
                                        System.out
                                                .println("O jogador " + player.getName() + " morreu durante o turno.");

                                    }
                                }
                            }

                        }

                    } catch (InputMismatchException e) {
                        System.err.println("Entrada Inválida! Digite um número inteiro entre 1 e " + monstros.size());
                        s.nextLine();
                    }

                } else {
                    IA ia = new IA(herois, game);
                    ia.IA_monstros(player);
                }
            }

            // Verifica se algum time está morto para decidir o vencedor
            if (h.isTeamDead(herois)) {
                System.out.println("A batalha acabou! O time dos heróis perdeu!");
                Log.registrarAcao("A batalha acabou! O time dos heróis perdeu!");
                break;
            } else if (h.isTeamDead(monstros)) {
                Log.registrarAcao("A batalha acabou! O time dos monstros perdeu!");
                System.out.println("A batalha acabou! O time dos monstros perdeu!");
                break;
            }
            turnoAtual++;
        }
        s.close();
        System.out.println("A batalha possuiu " + this.turnoAtual + " turnos");

    }

}
