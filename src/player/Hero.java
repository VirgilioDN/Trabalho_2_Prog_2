package player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import Excessoes.NomeInvalido;
import app.Dado;
import classe_herois.Arqueiro;
import classe_herois.Mago;
import classe_herois.Guerreiro;
import classe_herois.Ladino;
import classe_herois.Paladino;
import log.Log;
import classe_herois.Clerigo;

public class Hero extends Player {
	private static ArrayList<Hero> heros = new ArrayList<Hero>();
	private static NomeInvalido verificaNome = new NomeInvalido();

	public Hero() {
	}

	public Hero(String name, int forca, int constituicao, int destreza, int intelecto, double aggro) {
		super(name, forca, constituicao, destreza, intelecto, aggro);
	}

	public static ArrayList<Hero> getHerois() {
		return heros;
	}

	public static void criarPersonagem() {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i <= 3; ++i) {
			String name = "";
			boolean nomeValido = false;
			while (!nomeValido) {
				try {
					System.out.println("Digite o nome do personagem: ");
					name = s.nextLine();
					verificaNome.verificaNome(name);
					nomeValido = true;
				} catch (NomeInvalido e) {
					System.out.println(e.getMessage());
				}

			}

			System.out.println("Escolha a classe de seu personagem!");
			System.out.println("1 - Guerreiro\n" +
					"Atributos: Força: 15, Constituição: 12, Destreza: 7, Intelecto: 7");
			System.out.println("2 - Mago\n" +
					"Atributos: Força: 7, Constituição: 10, Destreza: 9, Intelecto: 14");
			System.out.println("3 - Ladino\n" +
					"Atributos: Força: 12, Constituição: 7, Destreza: 14, Intelecto: 7");
			System.out.println("4 - Paladino\n" +
					"Atributos: Força: 12, Constituição: 14, Destreza: 6, Intelecto: 8");
			System.out.println("5 - Clérigo\n" +
					"Atributos: Força: 8, Constituição: 12, Destreza: 8, Intelecto: 12");
			System.out.println("6 - Arqueiro\n" +
					"Atributos: Força: 12, Constituição: 10, Destreza: 12, Intelecto: 8");

			// nao vejo necessidade de um sair
			// System.out.println("7 - Sair");

			int opcao = s.nextInt();

			System.out.println("Agora, para continuar a criação do personagem,\n" +
					"você jogará três D6 para distribuir o resultado nos atributos do seu jogador.\n" +
					" Você deve distribuí-los entre força, constituição, destreza e intelecto.\n");

			// criação dos dados
			Dado dado1 = new Dado();
			Dado dado2 = new Dado();
			Dado dado3 = new Dado();

			int atributos = dado1.D6() + dado2.D6() + dado3.D6();
			int atributos_aux = atributos;

			// TODO
			// fazer tratamento de excessoes aqui
			do {
				if (atributos_aux != atributos) {
					System.out.println("Você não distruibuiu todos os pontos.");
					atributos_aux = atributos;
				}
				System.out.println("Pontos de atributo disponíveis: " + atributos);

				// força
				System.out.print("Quantos pontos quer atribuir a Força? ");
				int forca = s.nextInt();
				while (atributos - forca < 0) {
					System.out.println("Não há pontos o suficiente para atribuir. Tente novamente");
					System.out.print("Quantos pontos quer atribuir a Força? ");
					forca = s.nextInt();
				}
				atributos -= forca;

				// Constituição
				System.out.print("Quantos pontos quer atribuir a Constituição? ");
				int constituicao = s.nextInt();
				while (atributos - constituicao < 0) {
					System.out.println("Não há pontos o suficiente para atribuir. Tente novamente");
					System.out.print("Quantos pontos quer atribuir a Constituição? ");
					constituicao = s.nextInt();
				}
				atributos -= constituicao;

				// destreza
				System.out.print("Quantos pontos quer atribuir a Destreza? ");
				int destreza = s.nextInt();
				while (atributos - destreza < 0) {
					System.out.println("Não há pontos o suficiente para atribuir. Tente novamente");
					System.out.print("Quantos pontos quer atribuir a destreza? ");
					destreza = s.nextInt();
				}
				atributos -= destreza;

				// intelecto
				System.out.print("Quantos pontos quer atribuir a Intelecto? ");
				int intelecto = s.nextInt();
				while (atributos - intelecto < 0) {
					System.out.println("Não há pontos o suficiente para atribuir. Tente novamente");
					System.out.print("Quantos pontos quer atribuir a Intelecto? ");
					intelecto = s.nextInt();
				}
				atributos -= intelecto;
				// teste
				double aggro;

				if (atributos == 0) {
					switch (opcao) {
						case 1:
							intelecto = forca += 14;
							constituicao += 12;
							destreza += 7;
							intelecto += 7;
							aggro = 1.25;
							Guerreiro guerreiro = new Guerreiro(name, forca, constituicao, destreza, intelecto, aggro);
							System.out.println("Personagem criado com sucesso!\n");
							heros.add(guerreiro);
							break;
						case 2:
							intelecto = forca += 7;
							constituicao += 10;
							destreza += 9;
							intelecto += 14;
							aggro = 0.75;
							Mago mago = new Mago(name, forca, constituicao, destreza, intelecto, aggro);
							System.out.println("Personagem criado com sucesso!\n");
							heros.add(mago);
							break;
						case 3:
							intelecto = forca += 12;
							constituicao += 7;
							destreza += 14;
							intelecto += 7;
							aggro = 0.75;
							Ladino ladino = new Ladino(name, forca, constituicao, destreza, intelecto, aggro);
							System.out.println("Personagem criado com sucesso!\n");
							heros.add(ladino);
							break;
						case 4:
							intelecto = forca += 12;
							constituicao += 14;
							destreza += 6;
							intelecto += 8;
							aggro = 1.25;
							Paladino paladino = new Paladino(name, forca, constituicao, destreza, intelecto, aggro);
							System.out.println("Personagem criado com sucesso!\n");
							heros.add(paladino);
							break;
						case 5:
							intelecto = forca += 8;
							constituicao += 12;
							destreza += 8;
							intelecto += 12;
							aggro = 1;
							Clerigo clerigo = new Clerigo(name, forca, constituicao, destreza, intelecto, aggro);
							System.out.println("Personagem criado com sucesso!\n");
							heros.add(clerigo);
							break;
						case 6:
							intelecto = forca += 12;
							constituicao += 18;
							destreza += 12;
							intelecto += 8;
							aggro = 1;
							Arqueiro arqueiro = new Arqueiro(name, forca, constituicao, destreza, intelecto, aggro);
							System.out.println("Personagem criado com sucesso!\n");
							heros.add(arqueiro);
							break;
						default:
							System.out.println("Opção inválida!");
							break;
					}
				}
				s.nextLine();
				Log.registrarAcao("Novo personagem criado chamado" + name + "com a classe de" + opcao);
				Log.registrarAcao("Atributos:\n" +
									"Força: "+ forca + "\n" + 
									"Constituição: "+ constituicao + "\n" + 
									"Destreza: "+ destreza + "\n" + 
									"Intelecto: "+ intelecto);

			} while (atributos > 0);
		}
	}

	public void listarPersonagens() {
		for (Hero hero : heros) {
			System.out.println("Nome: " + hero.getName());
			System.out.println("Força: " + hero.getForca());
			System.out.println("Constituição: " + hero.getConstituicao());
			System.out.println("Destreza: " + hero.getDestreza());
			System.out.println("Intelecto: " + hero.getIntelecto());
			// debug
			System.out.println("aggro: " + hero.getAggro());
			System.out.println();
			System.out.println();
		}
	}

	public static void heroAtributos() {
		for (Hero hero : heros) {
			System.out.println("Dano: " + hero.getAtaque());
			System.out.println("Vida: " + hero.getHealth() + "/" + hero.getAtual_Health());
			System.out.println("Defesa: " + hero.getDefesa());
			System.out.println("Velociade: " + hero.getVelocidade());
			System.out.println();
		}
	}

	public static ArrayList<Hero> getHeros() {
		return heros;
	}
}
