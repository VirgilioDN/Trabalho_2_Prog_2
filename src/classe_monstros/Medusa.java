package classe_monstros;
import player.Monster;
import player.Hero;

public class Medusa extends Monster {
    static int medusa = 0;
    private int qtdAtaqueEspecial = 0;

    public Medusa() {
        super("Medusa " + (++medusa), 14, 30, 9, 10, 1);
    }

    public void ataqueEspecial(Hero hero) {
        if ((qtdAtaqueEspecial < 2) && (this.getAtual_Health() < 100)){
            for (Hero h : Hero.getHerois()){
                this.attack(h);
            }
        }else{
            qtdAtaqueEspecial++;
            attack(hero);
        }
    }

}
