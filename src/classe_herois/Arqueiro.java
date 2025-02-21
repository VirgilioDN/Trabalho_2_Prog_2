package classe_herois;

import player.Hero;

public class Arqueiro extends Hero {
	private static int aggro = 100;
	private int flechas_elementais;

    public Arqueiro(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
    	super(name, forca, constituicao, destreza, intelecto, aggro);
    }

	
	
}

