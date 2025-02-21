package player;

import java.util.ArrayList;
import app.Dado;
import app.Game;

public class IA extends Game {
	private ArrayList<Hero> players;
	public static Level dificuldade;

	public IA(ArrayList<Hero> players){
		this.players = players;
	}

	public void setDificuldadeIA(){
		dificuldade = super.getDificuldade();
	}


	public void IA_monstros(Player player_atual){
		Dado dado = new Dado();
		int chance_acerto = 0;
		int hero = 0;
		boolean s = true;
		switch (dificuldade) {
			case FACIL:
				//ataca mais quem tem mais vida
				//roda o dado até alguem satisfazer a condição
				do{
					hero = dado.D4() - 1;
					chance_acerto = dado.D20();
					if(chance_acerto * players.get(hero).aggro > 10){
						player_atual.attack(players.get(hero));
						s = false;
					}
				}while(s);
				break;

			case MEDIO:
				//aleatorio
				hero = dado.D4() - 1;
				player_atual.attack(players.get(hero));
				break;

			case DIFICIL:
				break;	
			default:
				break;
		}
	}
}

//inclompleta, preciso de alguns recursos
