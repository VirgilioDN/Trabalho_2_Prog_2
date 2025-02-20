package player;

import java.util.ArrayList;
import java.util.Scanner;

import app.Dado;
import classe_herois.Arqueiro;
import classe_herois.Mago;
import classe_herois.Guerreiro;
import classe_herois.Ladino;
import classe_herois.Paladino;
import classe_herois.Clerigo;

public class Hero extends Player {
    private static ArrayList<Hero> heros = new ArrayList<Hero>();

    public Hero(String name, int forca, int constituicao, int destreza, int intelecto) {
        super(name, forca, constituicao, destreza, intelecto);
    }

    public static void criarPersonagem() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i <= 3; ++i) {
        	
        	System.out.println("Digite o nome do personagem: ");
            String name = s.nextLine();
        	
            System.out.println("Escolha a classe de seu personagem!");
            System.out.println("1 - Guerreiro\n" + 
            					"Atributos: Força: 15, Constituição: 12, Destreza: 7, Intelecto: 7");
            System.out.println("2 - Mago");
            System.out.println("3 - Ladino");
            System.out.println("4 - Paladino");
            System.out.println("5 - Clérigo");
            System.out.println("6 - Arqueiro");
            
            //nao vejo necessidade de um sair
            //System.out.println("7 - Sair");
            
            int opcao = s.nextInt();
        	
            System.out.println("Agora, para continuar a criação do personagem,\n" +
            				   "você jogará três D6 para distribuir o resultado nos atributos do seu jogador.\n" +
                               " Você deve distribuí-los entre força, constituição, destreza e intelecto.\n");
            
            //criação dos dados
            Dado dado1 = new Dado();
            Dado dado2 = new Dado();
            Dado dado3 = new Dado();
            
            int atributos = dado1.D6()+dado2.D6()+dado3.D6();
            int atributos_aux = atributos;
            
            //TODO
            //fazer tratamento de excessoes aqui
            do{if(atributos_aux != atributos) {
            	System.out.println("Você não distruibuiu todos os pontos.");
            	atributos_aux = atributos;
            }
            	System.out.println("Pontos de atributo disponíveis: " + atributos);
            	
            	//força
            	System.out.print("Quantos pontos quer atribuir a Força? ");
            	int forca = s.nextInt();
            	while(atributos - forca < 0) {
            		System.out.println("Não há pontos o suficiente para atribuir. Tente novamente");
                	System.out.print("Quantos pontos quer atribuir a Força? ");
                	forca = s.nextInt();
            	}
            	atributos -= forca;
            	
            	//Constituição
            	System.out.print("Quantos pontos quer atribuir a Constituição?? ");
            	int constituicao = s.nextInt();
            	while(atributos - constituicao < 0) {
            		System.out.println("Não há pontos o suficiente para atribuir. Tente novamente");
                	System.out.print("Quantos pontos quer atribuir a Constituição? ");
                	constituicao = s.nextInt();
            	}
            	atributos -= constituicao;
            	
            	//destreza
            	System.out.print("Quantos pontos quer atribuir a Destreza?? ");
            	int destreza = s.nextInt();
            	while(atributos - destreza < 0) {
            		System.out.println("Não há pontos o suficiente para atribuir. Tente novamente");
                	System.out.print("Quantos pontos quer atribuir a destreza? ");
                	destreza = s.nextInt();
            	}
            	atributos -= destreza;
            	
            	//intelecto
            	System.out.print("Quantos pontos quer atribuir a Intelecto?? ");
            	int intelecto = s.nextInt();
            	while(atributos - intelecto < 0) {
            		System.out.println("Não há pontos o suficiente para atribuir. Tente novamente");
                	System.out.print("Quantos pontos quer atribuir a Intelecto? ");
                	intelecto = s.nextInt();
            	}
            	atributos -= intelecto;
            	
            	if(atributos == 0) {
	            	switch (opcao) {
	                case 1:
	                	intelecto = 
	                	forca += 15;  constituicao += 12;  destreza += 7;  intelecto += 7;
	                    Guerreiro guerreiro = new Guerreiro(name, forca, constituicao, destreza, intelecto);
	                    System.out.println("Personagem criado com sucesso!\n");
	                    heros.add(guerreiro);
	                    break;
	                case 2:
	                	intelecto = 
	                	forca += 15;  constituicao += 12;  destreza += 7;  intelecto += 7;
	                    Mago mago = new Mago(name, forca, constituicao, destreza, intelecto);
	                    System.out.println("Personagem criado com sucesso!\n");
	                    heros.add(mago);
	                    break;
	                case 3:
	                	intelecto = 
	                	forca += 15;  constituicao += 12;  destreza += 7;  intelecto += 7;
	                    Ladino ladino = new Ladino(name, forca, constituicao, destreza, intelecto);
	                    System.out.println("Personagem criado com sucesso!\n");
	                    heros.add(ladino);
	                    break;
	                case 4:
	                	intelecto = 
	                	forca += 15;  constituicao += 12;  destreza += 7;  intelecto += 7;
	                    Paladino paladino = new Paladino(name, forca, constituicao, destreza, intelecto);
	                    System.out.println("Personagem criado com sucesso!\n");
	                    heros.add(paladino);
	                    break;
	                case 5:
	                	intelecto = 
	                	forca += 15;  constituicao += 12;  destreza += 7;  intelecto += 7;
	                    Clerigo clerigo = new Clerigo(name, forca, constituicao, destreza, intelecto);
	                    System.out.println("Personagem criado com sucesso!\n");
	                    heros.add(clerigo);
	                    break;
	                case 6:
	                	intelecto = 
	                	forca += 15;  constituicao += 12;  destreza += 7;  intelecto += 7;
	                    Arqueiro arqueiro = new Arqueiro(name, forca, constituicao, destreza, intelecto);
	                    System.out.println("Personagem criado com sucesso!\n");
	                    heros.add(arqueiro);
	                    break;
	                default:
	                    System.out.println("Opção inválida!");
	                    break;
	            	}
            	}
				s.nextLine();
            	
            } while(atributos > 0);
        }
    }

    public void listarPersonagens() {
        for (Hero hero : heros) {
            System.out.println("Nome: " + hero.getName());
            System.out.println("Força: " + hero.getForca());
            System.out.println("Constituição: " + hero.getConstituicao());
            System.out.println("Destreza: " + hero.getDestreza());
            System.out.println("Intelecto: " + hero.getIntelecto());
            System.out.println();
        }
    }

	public static ArrayList<Hero> getHeros() {
		return heros;
	}
}
