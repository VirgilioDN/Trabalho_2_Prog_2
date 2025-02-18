package player;

import app.Dado;

public class Player {
    protected String name;
    protected int forca;
    protected int constituicao;
    protected int destreza;
    protected int intelecto;
    protected int health;
    protected int ataque;
    protected int defesa;
    protected int velocidade;

    public Player() {

    }
    
    public Player(String name, int forca, int constituicao, int destreza, int intelecto) {
        this.name = name;
        this.forca = forca;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.intelecto = intelecto;
        this.health = constituicao * 10;
        this.ataque = forca * 2;
        this.defesa = constituicao * 2;
        this.velocidade = destreza * 2;
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
    
    public Boolean esquiva(Player player) {
    	Dado player_dado = new Dado();
    	Dado monstro_dado = new Dado();
    	if((player_dado.D20()+this.destreza) > (monstro_dado.D20()+player.destreza)) {
    		return true;
    	}else {
    		return false;
    	}
		
    }
    
    public void attack(Player player) {
    	if(this.esquiva(player)) {
    		System.out.println("O jogador " + this.name + " esquivou");
    	}else {
    		player.health -= this.ataque - (player.defesa * 0.4);
            System.out.println("O jogador " + this.name + " atacou o jogador " + player.name + " com " + this.ataque + " de dano.");
    	}
    }

    
    /* será desenvolvida quando tivermos turnos
    public void block(Player player) {
        player.health -= this.defesa;
        System.out.println(
                "O jogador " + this.name + " bloqueou o ataque do jogador " + player.name + " com " + this.defesa
                        + " de dano.");
    }*/

    public void ataqueEspecial(Player player) {
        // Criar
    }

}
