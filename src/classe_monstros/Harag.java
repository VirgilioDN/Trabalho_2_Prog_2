package classe_monstros;

import player.Hero;
import player.Monster;

//Boss
public class Harag extends Monster {
    private int qtdAtaqueEspecial = 0;

    public Harag() {
        super("Harag ", 13, 35, 6, 18, 1);
    }

    @Override
    public void ataqueEspecial(Hero hero) {
        if ((qtdAtaqueEspecial > 2) && (this.getAtual_Health() < 100)) {
            for (Hero h : Hero.getHerois()) {
                this.attack(h);
                qtdAtaqueEspecial = 0;
                if (h.isDead()) {
                    h.setAtualHealth(0);
                }
            }
        } else {
            qtdAtaqueEspecial++;
            attack(hero);
            if (hero.isDead()) {
                hero.setAtualHealth(0);
            }
        }
    }

}
