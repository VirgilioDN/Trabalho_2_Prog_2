package classe_herois;

import java.util.ArrayList;
import java.util.Scanner;

import player.Hero;
import player.Monster;
import player.Player;

public class Paladino extends Hero {
	private int oracoes = 10000;

	public Paladino(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
		super(name, forca, constituicao, destreza, intelecto, aggro);
	}

	public void castigoDivino(Player p) {
		this.attack_crit(p);
	}

	public void realizarAcao(Player p, ArrayList<Monster> monstros, ArrayList<Hero> herois, int acao) {
		Scanner s = new Scanner(System.in);
		// pega os adjacentes para uso de ataques especiais

		int indice_direira = -1;
		int indice_esquerda = -1;
		int indice = monstros.lastIndexOf(p);

		if (indice + 1 < monstros.size()) {
			indice_direira = indice + 1;
		}
		if (indice - 1 > 0) {
			indice_esquerda = indice - 1;
		}

		boolean condição = true;
		do {
			switch (acao) {
				case 1:
					this.attack(p);
					condição = false;
					break;
				case 2:
					condição = false;
					this.cura(herois);
					break;
				case 3:
					if (oracoes > 0) {
						System.out.println(
								"Escolha a magia:  1 - Toque curativo  2 - Castigo Divino");
						acao = s.nextInt();
						switch (acao) {
							case 1:
								cura(herois);
								oracoes -= 1;
								condição = false;
								break;
							case 2:
								castigoDivino(p);
								oracoes -= 1;
								condição = false;
								break;
							case 3:

								oracoes -= 1;
								condição = false;
								break;
							default:
								break;
						}
						break;
					} else {
						System.out.println("Você não tem Orações o suficiente. Realize outra ação");
						break;
					}
				default:
					System.out.println("Ação inválida");
					break;
			}
		} while (condição);

	}
}
