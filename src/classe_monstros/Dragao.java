package classe_monstros;

import player.Hero;
import player.Monster;
import player.Player;

public class Dragao extends Monster {
    private int qtdAtaqueEspecial = 0;

    public Dragao() {
        super("Dragão ", 18, 40, 7, 10, 1);
    }

    @Override
    public void ataqueEspecial(Hero hero) {
        if ((qtdAtaqueEspecial > 2) && (this.getAtual_Health() < 100)) {
            for (Hero h : Hero.getHerois()) {
                this.attack(h);
                qtdAtaqueEspecial = 0;
            }
        } else {
            qtdAtaqueEspecial++;
            attack(hero);
        }
    }

}
