package classe_monstros;
import player.Monster;

//Monstro fácil
public class Gnomo extends Monster {
    static int gnomo = 0;

    public Gnomo() {
        super("Gnomo " + (++gnomo), 5, 5, 8, 7, 0);
    }

}
