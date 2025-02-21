package classe_monstros;
import player.Monster;
//Monstro fácil
public class Goster extends Monster {
    static int goster = 0;

    public Goster() {
        super("Goster " + (++goster), 10, 2, 1, 1,1);
    }

}
