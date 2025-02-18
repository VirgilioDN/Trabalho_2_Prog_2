package classe_herois;

import player.Hero;

public class Mago extends Hero{
	private static int aggro = 75;
	private static int magias;
	
    public Mago(String name, int forca, int constituicao, int destreza, int intelecto) {
    	super(name, forca, constituicao, destreza, intelecto);
    }
}

