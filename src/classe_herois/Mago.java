package classe_herois;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import player.Hero;
import player.Monster;
import player.Player;

public class Mago extends Hero {
	private int magias = 3;

	public Mago(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
		super(name, forca, constituicao, destreza, intelecto, aggro);
	}

	public void bolaDFogo(Player p, int player_esquerda, int player_direita, ArrayList<Monster> monstros) {
		if (player_direita < monstros.size() && player_direita >= 0 && player_esquerda > -1) {
			this.attack_mago(monstros.get(player_esquerda));
			this.attack_mago(p);
			this.attack_mago(monstros.get(player_direita));
			if (monstros.get(player_esquerda).isDead()) {
				monstros.get(player_esquerda).setAtualHealth(0);
			}
			if (p.isDead()) {
				p.setAtualHealth(0);
			}
			if (monstros.get(player_direita).isDead()) {
				monstros.get(player_direita).setAtualHealth(0);
			}
		} else if (player_direita == -1) {
			this.attack_mago(monstros.get(player_esquerda));
			this.attack_mago(p);
			if (monstros.get(player_esquerda).isDead()) {
				monstros.get(player_esquerda).setAtualHealth(0);
			}
			if (p.isDead()) {
				p.setAtualHealth(0);
			}
		} else if (player_esquerda == -1) {
			this.attack_mago(p);
			this.attack_mago(monstros.get(player_direita));
			if (p.isDead()) {
				p.setAtualHealth(0);
			}
			if (monstros.get(player_direita).isDead()) {
				monstros.get(player_direita).setAtualHealth(0);
			}
		}
	}

	public void nevasca(ArrayList<Monster> monstros) {
		for (Monster m : monstros) {
			this.attack_mago(m);
		}
	}

	public void relampago(Player p) {
		this.attack_mago_crit(p);
	}

	public void realizarAcao(Player p, ArrayList<Monster> monstros) {
		Scanner s = new Scanner(System.in);
		int acao;
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
			try {
				condição = true;
				System.out.println("Qual será sua ação?");
				System.out.println("1 - Atacar");
				System.out.println("2 - Usar habilidade especial");
				acao = s.nextInt();
				switch (acao) {
					case 1:
						this.attack_mago(p);
						condição = false;
						break;
					case 2:
						if (magias > 0) {
							System.out.println("Escolha a magia:  1 - Bola de fogo  2 - Nevasca  3 - Relâmpago");
							acao = s.nextInt();
							switch (acao) {
								case 1:
									bolaDFogo(p, indice_esquerda, indice_direira, monstros);
									magias -= 1;
									condição = false;
									break;
								case 2:
									nevasca(monstros);
									magias -= 1;
									condição = false;
									break;
								case 3:
									relampago(p);
									magias -= 1;
									condição = false;
									break;
								default:
									break;
							}
							break;
						} else {
							System.out.println("Você não tem magias o suficiente. Realize outra ação");
							break;
						}
					default:
						System.out.println("Ação inválida");
						break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Entrada Inválida! Digite um número inteiro entre 1 e 3");
				s.nextLine();
			}

		} while (condição);

	}

}
