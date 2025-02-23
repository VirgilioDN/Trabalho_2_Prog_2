package classe_monstros;
import player.Monster;

//Monstro fácil
public class Lobo extends Monster {
    static int lobo = 0;

    public Lobo() {
        super("Lobo " + (++lobo), 6, 5, 9, 4, 0);
    }

}
