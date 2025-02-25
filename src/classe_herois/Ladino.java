package classe_herois;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import player.Hero;
import player.Monster;
import player.Player;

public class Ladino extends Hero {

	public Ladino(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
		super(name, forca, constituicao, destreza, intelecto, aggro);
	}

	// critico garantido
	public void apunhalar(Player p) {
		this.attack_crit(p);
	}

	// ataque adjacente
	public void lancarBomba(Player p, int player_esquerda, int player_direita, ArrayList<Monster> monstros) {
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

	// não sei se vai precisar da lista
	public void realizarAcao(Player p, ArrayList<Monster> monstros) {

		Scanner s = new Scanner(System.in);
		boolean cond = true;
		while (cond) {
			try {
				cond = true;
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
				if (indice - 1 > -1) {
					indice_esquerda = indice - 1;
				}

				switch (acao) {
					case 1:
						this.attack(p);
						cond = false;
						break;
					case 2:// INVISIBILIDADE AINDA NAO EXISTE
						cond = false;
						System.out.println(
								"Escolha o ataque especial:  1 - Apunhalar  2 - Lançar bomba");
						acao = s.nextInt();
						switch (acao) {
							case 1:
								apunhalar(p);
								break;
							case 2:
								lancarBomba(p, indice_esquerda, indice_direira, monstros);
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
				System.err.println("Entrada inválida! Digite um número inteiro entre 1 e 3");
				s.nextLine();
			}
		}

	}
}
