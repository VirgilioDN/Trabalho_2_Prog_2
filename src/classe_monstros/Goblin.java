package classe_monstros;

import player.Monster;

//Monstro fácil
public class Goblin extends Monster {
    static int gob = 0;

    public Goblin() {
        super("Goblin " + (++gob), 10, 4, 4, 5, 0);
    }

}
