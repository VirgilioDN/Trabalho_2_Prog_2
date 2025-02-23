package classe_monstros;

import player.Hero;
import player.Monster;
import player.Player;
public class Dragao extends Monster {

    public Dragao() {
        super("Dragão ", 16, 700, 5, 10, 1);
    }

    public void ataqueEspecial() {
        if ((qtdAtaqueEspecial < 2) && (super.getConstituicao() < 75)){
            for (Hero h : Hero.getHeros()){
                h.setHealth((h.getHealth() - super.attack(h);));
            }
            qtdAtaqueEspecial++;
        }
    }

}
