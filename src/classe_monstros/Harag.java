package classe_monstros;

import player.Hero;
import player.Monster;

//Boss
public class Harag extends Monster {
    private int qtdAtaqueEspecial = 0;

    public Harag() {
        super("Harag ", 20, 50, 3, 10,1);
    }
    
    public void ataqueEspecial (){
        if ((qtdAtaqueEspecial < 2) && (super.getConstituicao() < 75)){
            for (Hero h : Hero.getHeros()){
                h.setHealth((h.getHealth() - super.attack(h)));
            }
            qtdAtaqueEspecial++;
        }
    }

}
