package classe_monstros;

import player.Monster;

//Monstro médio
public class Orc extends Monster {
    static int orc = 0;

    public Orc() {
        super("Orc " + (++orc), 15, 3, 2, 1,1);
    }

}
