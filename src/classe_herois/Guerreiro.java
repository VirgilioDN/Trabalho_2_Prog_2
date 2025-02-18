package classe_herois;
import player.Hero;

public class Guerreiro extends Hero {
	private static int aggro = 125;
	private int furia;

    public Guerreiro(String name, int forca, int constituicao, int destreza, int intelecto) {
    	super(name, forca, constituicao, destreza, intelecto);
    }
}

