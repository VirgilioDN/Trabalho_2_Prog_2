package classe_herois;

import player.Hero;

public class Paladino extends Hero {
	private static int aggro= 125;
	private int oracoes;

    public Paladino(String name, int forca, int constituicao, int destreza, int intelecto,double aggro) {
    	super(name, forca, constituicao, destreza, intelecto, aggro);
    }
}
