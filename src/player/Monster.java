package player;

import app.Game;
import java.util.ArrayList;
import java.util.Random;


public class Monster extends Player {

    private ArrayList<Monster> monstros = new ArrayList<>();
    //Goblin, Aranha, Goster, Orc, Esqueleto, Zabur
    static double PESOS_FACIL[] = {0.30, 0.60, 0.90, 0.95, 1.0};
    static double PESOS_MEDIO[] = {0.25, 0.50, 0.75, 0.90, 1.0};
    static double PESOS_DIFICIL[] = {0.20, 0.40, 0.60, 0.80, 1.0};

    public Monster(String name, int forca, int constituicao, int destreza, int intelecto) {
        super(name, forca, constituicao, destreza, intelecto);
    }

    public void tipoMonstros(int qtd, double pesos[]){
            for (int i = 0; i < qtd; i++){
                double opcao = Math.random();
                System.out.println("Opcao: " + opcao);
                if (opcao <= pesos[0]){
                    monstros.add(new Monster("Goblin", 10, 10, 10, 10));
                    players.add(new Monster("Goblin", 10, 10, 10, 10));
                }
                else if (opcao <= pesos[1]){
                    players.add(new Monster("Orc", 15, 15, 15, 15));
                }
                else if (opcao <= pesos[2]){
                    players.add(new Monster("Esqueleto", 10, 10, 10, 10));
                }
                else if (opcao <= pesos[3]){
                    players.add(new Monster("Zumbi", 10, 10, 10, 10));
                }
                else if (opcao <= pesos[4]){
                    players.add(new Monster("Lobo", 10, 10, 10, 10));
                }
                else if (opcao <= pesos[5]){
                    players.add(new Monster("Dragão", 20, 20, 20, 20));
                }
                System.out.println("Monstro " + players.get(i).getName() + " criado!");
            }
        }
    
    public void criaMonstros(){
        int qtd;
        Random r = new Random();
        if (Game.getDificuldade() == Game.Level.FACIL){
            qtd = 4;
            tipoMonstros(qtd, PESOS_FACIL);
        }
        else if (Game.getDificuldade() == Game.Level.MEDIO){
            qtd = r.nextInt(4,6);
            tipoMonstros(qtd, PESOS_MEDIO);
        }
        else if (Game.getDificuldade() == Game.Level.DIFICIL){
            qtd = r.nextInt(4,7);
            tipoMonstros(qtd, PESOS_DIFICIL);
        }
    }
}
