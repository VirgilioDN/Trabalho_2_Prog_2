package player;

import app.Dado;
import classe_herois.*;
import classe_monstros.*;

import java.util.ArrayList;

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

    // TODO
    // debugar a esquiva, ela sempre ta esquivando
    public Boolean esquiva(Player player) {
        Dado player_dado = new Dado();
        Dado monstro_dado = new Dado();
        if ((player_dado.D20()) > (monstro_dado.D20() + (player.destreza * 0.4))) {
            return true;
        } else {
            return false;
        }

    }

    public void attack(Player player) {
        if (this.esquiva(player)) {
            System.out.println(player.name + " esquivou do ataque de " + this.name);
        } else {
            player.atual_health -= this.ataque - (player.defesa * 0.4);
            System.out.println(this.name + " atacou o jogador " + player.name + " com "
                    + (this.ataque - (player.defesa * 0.4)) + " de dano.");
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
     * }
     */

    public void ataqueEspecial(Player player) {
        // Criar
    }

    public static void listaPlayers() {
        System.out.println("\n=== Lista de Jogadores ===\n");

        // Linha superior das caixas
        for (Player p : players) {
            System.out.printf("+-------------+  ");
        }
        System.out.println();

        // Nome dos jogadores
        for (Player p : players) {
            System.out.printf("| %-11s |  ", p.getName());
        }
        System.out.println();

        // Vida dos jogadores com coração ❤️
        for (Player p : players) {
            System.out.printf("| \u2764\uFE0F %-9d |  ", p.getAtual_Health());
            //System.out.printf("/", p.getAtual_Health());
        }
        System.out.println();

        for (Player p : players) {
            System.out.printf("| Ataque:%-4d |  ", p.getAtaque());
            //System.out.printf("/", p.getAtual_Health());
        }
        System.out.println();

        for (Player p : players) {
            System.out.printf("| Def:%-7d |  ", p.getDefesa());
            //System.out.printf("/", p.getAtual_Health());
        }
        System.out.println();

        // Linha inferior das caixas
        for (Player p : players) {
            System.out.printf("+-------------+  ");
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

    public void acao(Player player) {
        // Verifica qual classe tal jodgador pertence e chama o método de ação
        if (player instanceof Arqueiro) {
            // Arqueiro arqueiro = (Arqueiro) player;
            // arqueiro.realizarAcao(player);
        } else if (this instanceof Guerreiro) {
            // Down cast para ter certeza de que é um tipo de herói
            Guerreiro guerreiro = (Guerreiro) this;
            guerreiro.realizarAcao(player);
        } else if (player instanceof Mago) {
            this.attack(player);
        } else if (player instanceof Clerigo) {
            this.attack(player);
        } else if (player instanceof Ladino) {
            this.attack(player);
        } else if (player instanceof Paladino) {
            this.attack(player);
        } else if (player instanceof Aranha) {
            this.attack(player);
        } else if (player instanceof Gnomo) {
            this.attack(player);
        } else if (player instanceof Goblin) {
            this.attack(player);
        } else if (player instanceof Troll) {
            this.attack(player);
        } else if (player instanceof Harag) {
            this.attack(player);
        } else if (player instanceof Zabur) {
            this.attack(player);
        }
    }
}
