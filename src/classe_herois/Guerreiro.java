package classe_herois;

import java.util.ArrayList;
import java.util.Scanner;

import player.Hero;
import player.Monster;
import player.Player;

public class Guerreiro extends Hero {
	//private int furia;

	public Guerreiro(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
		super(name, forca, constituicao, destreza, intelecto, aggro);
	}

	public void golpeLateral(Player p, int player_esquerda, int player_direita, ArrayList<Monster> monstros) {
		if(player_direita < monstros.size() && player_direita >= 0 && player_esquerda > -1){
			this.attack(monstros.get(player_esquerda));
			this.attack(p);
			this.attack(monstros.get(player_direita));
		} else if(player_direita == -1){
			this.attack(monstros.get(player_esquerda));
			this.attack(p);
		} else if(player_esquerda == -1){
			this.attack(p);
			this.attack(monstros.get(player_direita));
		}

	}

	public void estocada(Player p){
		this.attack_crit(p);
	}

	public void realizarAcao(Player p, ArrayList<Monster> monstros) {
		System.out.println("Qual será sua ação?");
		System.out.println("1 - Atacar");
		System.out.println("2 - Defender");
		System.out.println("3 - Usar habilidade especial");
		Scanner s = new Scanner(System.in);
		int acao = s.nextInt();

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

		switch (acao) {
			case 1:
				this.attack(p);
				break;
			case 2:
				// defender();
				break;
			case 3:
				System.out.println("Escolha o ataque especial:  1 - Golpe lateral  2 - Estocada  3 - Golpe incapacitador (não implementado)");
				acao = s.nextInt();
				switch (acao) {
					case 1:
						golpeLateral(p, indice_esquerda, indice_direira, monstros); 
						break;
					case 2:
						estocada(p);
						break;
					default:
						break;
				}
				break;
			default:
				System.out.println("Ação inválida");
		}

	}

}
