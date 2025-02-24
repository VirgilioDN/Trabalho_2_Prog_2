package classe_herois;

import java.util.ArrayList;
import java.util.Scanner;

import player.Hero;
import player.Monster;
import player.Player;

public class Clerigo extends Hero{
	private int favores_divinos = 3;

    public Clerigo(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
    	super(name, forca, constituicao, destreza, intelecto, aggro);
    }


	public void julgamento_divino(ArrayList<Monster> monstros){
		for(Monster m : monstros){
			this.attack_mago(m);
		}
	}

	public void realizarAcao(Player p, ArrayList<Monster> monstros, ArrayList<Hero> herois) {
		Scanner s = new Scanner(System.in);
		int acao;
		//pega os adjacentes para uso de ataques especiais
		
		int indice_direira = -1;
		int indice_esquerda = -1;
		int indice = monstros.lastIndexOf(p);

		if(indice + 1 < monstros.size()){
			indice_direira = indice + 1;
		}
		if(indice - 1 > 0){
			indice_esquerda = indice - 1;
		}

		boolean condição = true;
	do{
		condição = true;
		System.out.println("Qual será sua ação?");
		System.out.println("1 - Atacar");
		System.out.println("2 - Defender");
		System.out.println("3 - Usar habilidade especial");
		acao = s.nextInt();
		switch (acao) {
			case 1:
				this.attack_mago(p);
				condição = false;
				break;
			case 2:
				// defender();
				break;
			case 3:
			if(favores_divinos > 0){
				System.out.println("Escolha a magia:  1 - Curar  2 - Cura em massa  3 - Julgamento Divino");
				acao = s.nextInt();
				switch (acao) {
					case 1:
						cura(herois);
						favores_divinos -= 1;
						condição = false;
						break;
					case 2:
						cura_em_massa(herois);
						favores_divinos -= 1;
						condição = false;
						break;
					case 3:
						julgamento_divino(monstros);
						favores_divinos -= 1;
						condição = false;
						break;
					default:
						break;
				}
				break;
			} else{
				System.out.println("Você não tem Favores Divinos o suficiente. Realize outra ação");
				break;
			}
			default:
				System.out.println("Ação inválida");
				break;
		}
	}while (condição);

	}
	
}
