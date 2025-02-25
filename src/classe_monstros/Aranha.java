package classe_monstros;

import player.Monster;

//Monstro fácil
public class Aranha extends Monster {
    static int aranha = 0;

    public Aranha() {
        super("Aranha " + (++aranha), 8, 5, 5, 5, 1);
    }
}
