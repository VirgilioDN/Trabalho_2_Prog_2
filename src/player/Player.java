package player;

import app.Dado;
import classe_herois.*;
import classe_monstros.*;
import log.Log;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    protected String name;
    protected int forca;
    protected int constituicao;
    protected int destreza;
    protected int intelecto;
    protected int health;
    protected int atual_health;
    protected int ataque;
    protected int defesa;
    protected int velocidade;
    protected double aggro;
    protected static ArrayList<Player> players = new ArrayList<Player>();

    public Player() {
    }

    public Player(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
        this.name = name;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.intelecto = intelecto;
        this.health = constituicao * 10;
        this.ataque = forca * 2;
        this.defesa = constituicao * 2;
        this.velocidade = destreza * 2;
        this.atual_health = this.health;
        this.aggro = aggro;
        players.add(this);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public int getForca() {
        return forca;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getIntelecto() {
        return intelecto;
    }

    public int getHealth() {
        return health;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getAtual_Health() {
        return atual_health;
    }

    public double getAggro() {
        return aggro;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public enum Acerto {
        ACERTO, ERRO, ACERTO_CRITICO;
    }

    // ataques
    public void attack(Player player) {
        Dado dado = new Dado();
        Acerto hit;
        if (15 > (dado.D20() + Math.floor((Math.log(player.destreza) / Math.log(3))))) {
            hit = Acerto.ERRO;
        } else {
            if (16 < dado.D20() + Math.floor((Math.log(this.destreza) / Math.log(2.4)))) {
                hit = Acerto.ACERTO_CRITICO;
            } else {
                hit = Acerto.ACERTO;
            }
        }

        switch (hit) {
            case ERRO:
                System.out.println(player.name + " esquivou do ataque de " + this.name);
                Log.registrarAcao(player.name + " esquivou do ataque de " + this.name);
                break;
            case ACERTO:
                if (this.ataque - Math.floor((Math.log(player.defesa) / Math.log(1.33))) < 0) {
                    player.atual_health -= this.ataque * 0.3;
                    System.out.println(this.name + " acertou o jogador " + player.name + " causando "
                            + (this.ataque * 0.3) + " de dano.");
                    Log.registrarAcao(this.name + " acertou o jogador " + player.name + " causando "
                            + (this.ataque * 0.3) + " de dano.");
                } else {
                    player.atual_health -= this.ataque - Math.floor((Math.log(player.defesa) / Math.log(1.33)));
                    System.out.println(this.name + " acertou o jogador " + player.name + ", causando "
                            + (this.ataque - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
                    Log.registrarAcao(this.name + " acertou o jogador " + player.name + ", causando "
                            + (this.ataque - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
                }
                break;
            case ACERTO_CRITICO:
                player.atual_health -= this.ataque * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)));
                System.out.println(this.name + " acertou o jogador " + player.name + " com um ACERTO CRÍTICO! causando "
                        + (this.ataque * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
                Log.registrarAcao(this.name + " acertou o jogador " + player.name + " com um ACERTO CRÍTICO! causando "
                        + (this.ataque * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
                break;
            default:
                break;
        }
    }

    public void attack_crit(Player player) {
        player.atual_health -= this.ataque * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)));
        System.out.println(this.name + " acertou o jogador " + player.name + " com um ACERTO CRÍTICO! causando "
                + (this.ataque * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
        Log.registrarAcao(this.name + " acertou o jogador " + player.name + " com um ACERTO CRÍTICO! causando "
                + (this.ataque * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
    }

    // ataque de mago
    public void attack_mago(Player player) {
        Dado dado = new Dado();
        Acerto hit;
        if (15 > (dado.D20() + Math.floor((Math.log(player.destreza) / Math.log(3))))) {
            hit = Acerto.ERRO;
        } else {
            if (16 < dado.D20() + Math.floor((Math.log(this.destreza) / Math.log(2.4)))) {
                hit = Acerto.ACERTO_CRITICO;
            } else {
                hit = Acerto.ACERTO;
            }
        }

        switch (hit) {
            case ERRO:
                System.out.println(player.name + " esquivou do ataque de " + this.name);
                Log.registrarAcao(player.name + " esquivou do ataque de " + this.name);
                break;
            case ACERTO:
                if (this.intelecto - Math.floor((Math.log(player.defesa) / Math.log(1.33))) < 0) {
                    player.atual_health -= this.intelecto * 0.3;
                    System.out.println(this.name + " acertou o jogador " + player.name + " causando "
                            + (this.intelecto * 0.3) + " de dano.");
                    Log.registrarAcao(this.name + " acertou o jogador " + player.name + " causando "
                            + (this.intelecto * 0.3) + " de dano.");
                } else {
                    player.atual_health -= this.intelecto - Math.floor((Math.log(player.defesa) / Math.log(1.33)));
                    System.out.println(this.name + " acertou o jogador " + player.name + ", causando "
                            + (this.intelecto - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
                    Log.registrarAcao(this.name + " acertou o jogador " + player.name + ", causando "
                            + (this.intelecto - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
                }
                break;
            case ACERTO_CRITICO:
                player.atual_health -= this.intelecto * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)));
                System.out.println(this.name + " acertou o jogador " + player.name + " com um ACERTO CRÍTICO! causando "
                        + (this.intelecto * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
                Log.registrarAcao(this.name + " acertou o jogador " + player.name + " com um ACERTO CRÍTICO! causando "
                        + (this.intelecto * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
                break;
            default:
                break;
        }
    }

    public void attack_mago_crit(Player player) {
        player.atual_health -= this.intelecto * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)));
        System.out.println(this.name + " acertou o jogador " + player.name + " com um ACERTO CRÍTICO! causando "
                + (this.intelecto * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
        Log.registrarAcao(this.name + " acertou o jogador " + player.name + " com um ACERTO CRÍTICO! causando "
                + (this.intelecto * 2 - Math.floor((Math.log(player.defesa) / Math.log(1.33)))) + " de dano.");
    }

    // tratamento de excessao
    public void cura(ArrayList<Hero> herois) {
        Scanner s = new Scanner(System.in);
        System.out.println("Quem você deseja curar?");

        int[] q = new int[herois.size()];
        int i = 1;

        for (Hero m : herois) {
            q[i - 1] = i - 1;
            System.out.println(i + " - " + m.getName());
            i++;
        }
        System.out.println();

        int escolha = s.nextInt();
        for (int j : q) {
            if (escolha - 1 == j) {
                if (herois.get(j).isDead()) {
                    System.out.println(
                            "Ops! Parece que o heroi escolhido está morto! Você perdeu sua cura.");
                    Log.registrarAcao("Heroi escolhido morto.");
                    break;
                } else {
                    if (herois.get(j).atual_health + 50 > herois.get(j).health) {
                        int a = herois.get(j).health - herois.get(j).atual_health;
                        herois.get(j).atual_health = herois.get(j).health;
                        System.out.println(this.name + "curou " + a + " de vida do jogador " + herois.get(j).name);
                    } else {
                        herois.get(j).atual_health += 50;
                        System.out.println(this.name + " curou 50 de vida do jogador " + herois.get(j).name);
                    }
                }
            }
        }
    }

    // tratamento de excessao
    public void cura_em_massa(ArrayList<Hero> herois) {
        for (Hero m : herois) {
            if (m.isDead()) {
                System.out.println("Ops! Parece que o heroi escolhido está morto! Ele não pôde ser curado");
            } else {
                if (m.atual_health + 30 > m.health) {
                    int a = m.health - m.atual_health;
                    m.atual_health = m.health;
                    System.out.println(this.name + "curou " + a + " de vida do jogador " + m.name);
                } else {
                    m.atual_health += 30;
                    System.out.println(this.name + " curou 30 de vida do jogador " + m.name);
                }
            }
        }
    }

    /*
     * será desenvolvida quando tivermos turnos
     * public void block(Player player) {
     * player.health -= this.defesa;
     * System.out.println(
     * "O jogador " + this.name + " bloqueou o ataque do jogador " + player.name +
     * " com " + this.defesa
     * + " de dano.");
     * Log.registrarAcao("O jogador " + this.name + " bloqueou o ataque do jogador "
     * + player.name +
     * " com " + this.defesa
     * + " de dano.");
     * }
     */

    // TODO
    // aumentar
    public static void listaPlayers() {
        System.out.println("\n=== Lista de Jogadores ===\n");

        // Linha superior das caixas
        for (Player p : players) {
            System.out.printf("+-------------------+  ");
        }
        System.out.println();

        // Nome dos jogadores
        for (Player p : players) {
            System.out.printf("| %-17s |  ", p.getName());
        }
        System.out.println();

        // Vida dos jogadores com coração ❤️
        for (Player p : players) {
            System.out.printf("| Vida: %-3d/%-7d |  ", p.atual_health, p.health);
            // System.out.printf("/", p.getAtual_Health());
        }
        System.out.println();

        for (Player p : players) {
            System.out.printf("| Ataque: %-9d |  ", p.getAtaque());
            // System.out.printf("/", p.getAtual_Health());
        }
        System.out.println();

        for (Player p : players) {
            System.out.printf("| Def: %-12d |  ", p.getDefesa());
            // System.out.printf("/", p.getAtual_Health());
        }
        System.out.println();

        // Linha inferior das caixas
        for (Player p : players) {
            System.out.printf("+-------------------+  ");
        }
        System.out.println("\n");

    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public <T extends Player> boolean isTeamDead(ArrayList<T> heros) {
        for (Player player : heros) {
            if (!(player.isDead())) {
                return false;
            }
        }
        return true;
    }

    public void acaoComCura(ArrayList<Monster> monstros, ArrayList<Hero> herois, Scanner s) {
        boolean condition = true;
        do {
            System.out.println("Qual será sua ação?");
            System.out.println("1 - Atacar");
            System.out.println("2 - Curar");
            System.out.println("3 - Usar habilidade especial");
            int acao = s.nextInt();
            if (acao == 1 || acao == 3) {
                condition = false;
                System.out.println("Qual monstro você deseja atacar?");

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
                        if (monstros.get(j).isDead()) {
                            System.out.println(
                                    "Ops! Parece que o monstro escolhido está morto! Você perdeu sua vez.");
                            Log.registrarAcao("Monstro escolhido morto.");
                            break;
                        } else {
                            if (this instanceof Clerigo) {
                                Clerigo clerigo = (Clerigo) this;
                                clerigo.realizarAcao(monstros.get(j), monstros, herois, acao);
                            } else if (this instanceof Paladino) {
                                // Paladino paladino = (Paladino) this;
                                // paladino.realizarAcao(monstros.get(j), monstros, herois, acao);
                            }

                            // Verifica se o monstro morreu após o ataque
                            if (monstros.get(j).isDead()) {
                                Log.registrarAcao(
                                        "O monstro " + monstros.get(j).getName() + " foi derrotado!");
                                System.out.println(
                                        "O monstro " + monstros.get(j).getName() + " foi derrotado!");
                            }

                            // Verifica se o jogador morreu após a ação
                            if (this.isDead()) {
                                Log.registrarAcao(
                                        "O jogador " + this.getName() + " morreu durante o turno.");
                                System.out.println(
                                        "O jogador " + this.getName() + " morreu durante o turno.");

                            }
                        }
                    }

                }
            } else if (acao == 2) {
                if (this instanceof Clerigo) {
                    Clerigo clerigo = (Clerigo) this;
                    clerigo.realizarAcao(monstros.get(0), monstros, herois, acao);
                } else if (this instanceof Paladino) {
                    // Paladino paladino = (Paladino) this;
                    // paladino.realizarAcao(monstros.get(0), monstros, herois, acao);
                }
                condition = false;

            } else if (acao < 1 || acao > 3) {
                condition = true;
            }
        } while (condition);
    }

    public void acao(Player player, ArrayList<Monster> monstros, ArrayList<Hero> herois) {
        // Verifica qual classe tal jodgador pertence e chama o método de ação
        if (this instanceof Arqueiro) {

            Arqueiro arqueiro = (Arqueiro) this;
            arqueiro.realizarAcao(player, monstros);

        } else if (this instanceof Guerreiro) {

            // Down cast para ter certeza de que é um tipo de herói
            Guerreiro guerreiro = (Guerreiro) this;
            guerreiro.realizarAcao(player, monstros);

        } else if (this instanceof Mago) {

            Mago mago = (Mago) this;
            mago.realizarAcao(player, monstros);

        } else if (this instanceof Ladino) {

            Ladino ladino = (Ladino) this;
            ladino.realizarAcao(player, monstros);

        }
    }
}
