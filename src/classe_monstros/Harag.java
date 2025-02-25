package classe_monstros;

import player.Hero;
import player.Monster;

//Boss
public class Harag extends Monster {
    private int qtdAtaqueEspecial = 0;

    public Harag() {
        super("Harag ", 8, 35, 3, 18,1);
    }
    
    public void ataqueEspecial(Hero hero) {
        if ((qtdAtaqueEspecial < 2) && (this.getAtual_Health() < 100)){
            for (Hero h : Hero.getHeros()){
                this.attack(h);
            }
        }else{
            qtdAtaqueEspecial++;
            attack(hero);
        }
    }

}
