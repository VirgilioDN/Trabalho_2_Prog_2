package classe_herois;

import java.util.Scanner;

import player.Hero;
import player.Player;

public class Guerreiro extends Hero {
	private static int aggro = 125;
	private int furia;

	public Guerreiro(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
		super(name, forca, constituicao, destreza, intelecto, aggro);
	}

	public void ataqueEspecial(Player p) {
		System.out.println("Ataque especial do guerreiro desferido no: " + p.getName());
	}

	public void realizarAcao(Player p) {
		System.out.println("Qual será sua ação?");
		System.out.println("1 - Atacar");
		System.out.println("2 - Defender");
		System.out.println("3 - Usar habilidade especial");
		Scanner s = new Scanner(System.in);
		int acao = s.nextInt();
		switch (acao) {
			case 1:
				this.attack(p);
				break;
			case 2:
				// defender();
				break;
			case 3:
				this.ataqueEspecial(p);
				break;
			default:
				System.out.println("Ação inválida");
		}

	}

}
