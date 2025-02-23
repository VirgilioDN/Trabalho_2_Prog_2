package classe_monstros;
import player.Monster;
import player.Hero;

public class Medusa extends Monster {
    static int medusa = 0;

    public Medusa() {
        super("Medusa " + (++medusa), 18, 600, 20, 15, 1);
    }

    public void ataqueEspecial(Hero hero) {
        if ((qtdAtaqueEspecial < 2) && (super.getConstituicao() < 75)){
            for (Hero h : Hero.getHeros()){
                h.setHealth((h.getHealth() - super.attack(h)));
            }
            qtdAtaqueEspecial++;
        }
    }

}
