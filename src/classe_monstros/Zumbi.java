package classe_monstros;
import player.Monster;

public class Zumbi extends Monster {
    static int zumbis = 0;

    public Zumbi() {
        super("Zumbi " + (++zumbis), 5, 5, 4, 2, 0);
    }

}
