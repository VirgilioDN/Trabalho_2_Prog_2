package classe_monstros;
import player.Monster;

//Monstro médio
public class Troll extends Monster {
    static int troll = 0;

    public Troll() {
        super("Troll " + (++troll), 14, 8, 4, 6, 0);
    }

}
