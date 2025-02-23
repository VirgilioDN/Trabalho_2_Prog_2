package classe_monstros;
import player.Monster;
//Monstro médio
public class Zabur extends Monster {
    static int zabur = 0;

    public Zabur() {
        super("Zabur " + (++zabur), 8, 9, 9, 8, 0);
    }

}
