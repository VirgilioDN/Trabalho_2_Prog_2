package classe_herois;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import player.Hero;
import player.Monster;
import player.Player;

public class Guerreiro extends Hero {
	// private int furia;

	public Guerreiro(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
		super(name, forca, constituicao, destreza, intelecto, aggro);
	}

	public void golpeLateral(Player p, int player_esquerda, int player_direita, ArrayList<Monster> monstros) {
		if (player_direita < monstros.size() && player_direita >= 0 && player_esquerda > -1) {
			this.attack(monstros.get(player_esquerda));
			this.attack(p);
			this.attack(monstros.get(player_direita));
		} else if (player_direita == -1) {
			this.attack(monstros.get(player_esquerda));
			this.attack(p);
		} else if (player_esquerda == -1) {
			this.attack(p);
			this.attack(monstros.get(player_direita));
		}

	}

	public void estocada(Player p) {
		this.attack_crit(p);
	}

	public void realizarAcao(Player p, ArrayList<Monster> monstros) {
		boolean condition = true;
		Scanner s = new Scanner(System.in);
		while (condition) {
			try {
				condition = true;
				System.out.println("Qual será sua ação?");
				System.out.println("1 - Atacar");
				System.out.println("2 - Usar habilidade especial");

				int acao = s.nextInt();

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

				switch (acao) {
					case 1:
						condition = false;
						this.attack(p);
						break;
					case 2:
						condition = false;
						System.out.println(
								"Escolha o ataque especial:  1 - Golpe lateral  2 - Estocada");
						acao = s.nextInt();
						switch (acao) {
							case 1:
								golpeLateral(p, indice_esquerda, indice_direira, monstros);
								break;
							case 2:
								estocada(p);
								break;
							default:
								System.out.println("Ação inválida, você perdeu a vez");
								break;
						}
						break;
					default:
						System.out.println("Ação inválida");
				}
			} catch (InputMismatchException e) {
				System.err.println("Entrada Inválida! Digite um número inteiro entre 1 e 3");
				s.nextLine();
			}
		}

	}

}
