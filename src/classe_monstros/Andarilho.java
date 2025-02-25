package classe_monstros;

import player.Monster;

//Monstro médio
public class Andarilho extends Monster {
    static int andarilho = 0;

    public Andarilho() {
        super("Andarilho " + (++andarilho), 9, 7, 7 , 7, 0);
    }
}
