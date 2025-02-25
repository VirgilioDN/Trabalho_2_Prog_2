package classe_herois;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

import app.Dado;
import player.Hero;
import player.Monster;
import player.Player;

public class Arqueiro extends Hero {
	private int flechas_especiais = 1000;

	public Arqueiro(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
		super(name, forca, constituicao, destreza, intelecto, aggro);
	}

	// ataca todos os monstros
	public void chuvaDFlechas(ArrayList<Monster> monstros) {
		for (Monster m : monstros) {
			this.attack(m);
		}
	}

	public void ricochete(Player p, ArrayList<Monster> monstros) {
		this.attack(p);

		// cria lista auxiliar sem o montro atacado
		ArrayList<Monster> auxiliar = new ArrayList<Monster>();
		for (Monster m : monstros) {
			if (m != p) {
				auxiliar.add(m);
			}
		}

		// ataca aleatoriamente um monstro na lista e dps retira para que ele nao seja
		// atacado dnv
		Random r = new Random();
		for (int i = 0; i < 2; i++) {
			if (auxiliar.isEmpty() == true) {
				break;
			}
			int prox_monstro = r.nextInt(0, auxiliar.size() - 1);
			this.attack(auxiliar.get(prox_monstro));
			auxiliar.remove(prox_monstro);
		}
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
						this.attack(p);
						condição = false;
						break;
					case 2:
						if (flechas_especiais > 0) {
							System.out.println(
									"Escolha a magia:  1 - Chuva de flechas  2 - Ricochete");
							acao = s.nextInt();
							switch (acao) {
								case 1:
									chuvaDFlechas(monstros);
									flechas_especiais -= 1;
									condição = false;
									break;
								case 2:
									ricochete(p, monstros);
									condição = false;
									break;
								case 3:
									condição = false;
									break;
								default:
									System.out.println("Ação inválida");
									break;
							}
							break;
						} else {
							System.out.println("Você não tem Flechas especiais o suficiente. Realize outra ação");
							break;
						}
					default:
						System.out.println("Ação inválida");
						break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Entrada Inválida! Digite um número inteiro entre 1 e 3");
				s.nextLine();
			} catch (Exception e){
				System.err.println("Parece que ocorreu um erro no seu ataque, e por isso, você perdeu sua vez!");
			}

		} while (condição);

	}

}
