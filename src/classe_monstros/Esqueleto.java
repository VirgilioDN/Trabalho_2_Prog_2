package classe_monstros;
import player.Monster;

//Monstro fácil
public class Esqueleto extends Monster {
    static int esqueleto = 0;

    public Esqueleto() {
        super("Esqueleto " + (++esqueleto), 5 , 5, 5, 10, 0);
    }

}
