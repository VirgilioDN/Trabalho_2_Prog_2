package classe_monstros;

import player.Monster;

//Monstro médio
public class OrcAtirador extends Monster {
    static int orc = 0;

    public OrcAtirador() {
        super("Orc " + (++orc), 10, 8, 8, 6,0);
    }

}
