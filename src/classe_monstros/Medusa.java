package classe_monstros;

import player.Hero;
import player.Monster;

public class Medusa extends Monster {
    static int medusa = 0;
    private int qtdAtaqueEspecial = 0;

    public Medusa() {
        super("Medusa ", 15, 30, 9, 10, 1);
    }

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
