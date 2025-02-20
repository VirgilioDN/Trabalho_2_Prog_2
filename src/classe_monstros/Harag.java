package classe_monstros;

import player.Monster;
import player.Hero;

//Boss
public class Harag extends Monster {
    static int harag = 0;
    private int qtdAtaqueEspecial = 0;

    public Harag() {
        //Considero que constituição seja o PV
        super("Harag " + (++harag), 20, 300, 3, 2);
    }

    
    public void ataqueEspecial (){
        if ((qtdAtaqueEspecial < 2) && (super.getConstituicao() < 75)){
            for (Hero h : Hero.getHeros()){
                h.setHealth((h.getHealth() - 10));
            }
            qtdAtaqueEspecial++;
        }
    }

}
