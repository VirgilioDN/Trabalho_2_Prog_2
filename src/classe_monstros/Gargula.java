package classe_monstros;

import player.Monster;

//Monstro fácil
public class Gargula extends Monster {
    static int gargulas = 0;

    public Gargula() {
        super("Gargulas " + (++gargulas), 7, 7, 4, 5, 0);
    }
}
