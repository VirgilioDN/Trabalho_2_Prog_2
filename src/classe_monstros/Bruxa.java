package classe_monstros;

import player.Monster;

//Médio
public class Bruxa extends Monster {
    static int bruxa = 0;

    public Bruxa() {
        super("Bruxa " + (++bruxa), 12, 8 , 8, 10, 0);
    }
}
