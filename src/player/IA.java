package player;

import java.util.ArrayList;
import app.Dado;

//TODO
//implementar eventualmente o metodo para dificuldades maiores

public class IA {
	private ArrayList<Hero> players;
	//isso vai virar um enum com as dificuldades
	//private String dificuldade;

	public IA(ArrayList<Hero> players){
		this.players = players;
	}

	//TODO
	//vou consertar eventualmente os multiplicadores, a esquiva está acontecendo muito frequentemente
	public void IA_facil(Player player_atual){;
		Dado dado = new Dado();
		int chance_acerto = 0;
		int hero = 0;
		boolean s = true;

		//roda o dado até alguem satisfazer a condição
		do{
			hero = dado.D4() - 1;
			chance_acerto = dado.D20();
			if(chance_acerto * players.get(hero).aggro > 10){
				player_atual.attack(players.get(hero));
				Hero.listaPlayers();
				s = false;
			}
	}while(s);
}
}

//inclompleta, preciso de alguns recursos
