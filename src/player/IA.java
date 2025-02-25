package player;

import app.Dado;
import app.Game;
import classe_monstros.Dragao;
import classe_monstros.Harag;
import classe_monstros.Medusa;
import java.util.ArrayList;

public class IA{
	private ArrayList<Hero> herois;
	private Game game;

	public IA(ArrayList<Hero> herois, Game game){
		this.herois = herois;
		this.game = game;
	}

	public void IA_monstros(Player player_atual){
		Dado dado = new Dado();
		
		//variaveis facil
		int chance_acerto = 0;
		int hero = 0;

		//variaveis dificil
		int min_vida = 10000;
		int index_min_vida = 0;

		for (Hero h : herois){
			if(h.getHealth() < min_vida)
			index_min_vida = herois.indexOf(h);
		}

		boolean s = true;
		switch (game.getDificuldade()) {
			case FACIL:
				//ataca mais quem tem mais vida
				//roda o dado até alguem satisfazer a condição
				do{
					hero = dado.D4() - 1;
					chance_acerto = dado.D20();
					if(chance_acerto * herois.get(hero).aggro > 10){
						if (player_atual instanceof Dragao) {

							Dragao dragao = (Dragao) player_atual;
							dragao.ataqueEspecial(herois.get(hero));	
					
						} else if (player_atual instanceof Harag){

							Harag harag = (Harag) player_atual;
							harag.ataqueEspecial(herois.get(hero));
					
						} else if (player_atual instanceof Medusa){

							Medusa medusa = (Medusa) player_atual;
							medusa.ataqueEspecial(herois.get(hero));
					
						}else{
							player_atual.attack(herois.get(hero));
						}
						s = false;
					}
				}while(s);
				break;

			case MEDIO:
				//aleatorio
				hero = dado.D4() - 1;
				if (player_atual instanceof Dragao) {

					Dragao dragao = (Dragao) player_atual;
					dragao.ataqueEspecial(herois.get(hero));	
				
				} else if (player_atual instanceof Harag){

					Harag harag = (Harag) player_atual;
					harag.ataqueEspecial(herois.get(hero));
			
				} else if (player_atual instanceof Medusa){

					Medusa medusa = (Medusa) player_atual;
					medusa.ataqueEspecial(herois.get(hero));
				break;
				} else{
					player_atual.attack(herois.get(hero));
				}
				break;

			case DIFICIL:
			//tenta atacar o mais fraco se nao conseguir atraca aleatorio
				if (dado.D20() > 14){
					if (player_atual instanceof Dragao) {

						Dragao dragao = (Dragao) player_atual;
						dragao.ataqueEspecial(herois.get(index_min_vida));	
					
					} else if (player_atual instanceof Harag){
						
						Harag harag = (Harag) player_atual;
						harag.ataqueEspecial(herois.get(index_min_vida));
					
					} else if (player_atual instanceof Medusa){

						Medusa medusa = (Medusa) player_atual;
						medusa.ataqueEspecial(herois.get(index_min_vida));
						;
					}else{
						player_atual.attack(herois.get(index_min_vida));
					}

				} else{
					hero = dado.D4() - 1;
					if (player_atual instanceof Dragao) {

						Dragao dragao = (Dragao) player_atual;
						dragao.ataqueEspecial(herois.get(hero));	

					} else if (player_atual instanceof Harag){

						Harag harag = (Harag) player_atual;
						harag.ataqueEspecial(herois.get(hero));

					} else if (player_atual instanceof Medusa){

						Medusa medusa = (Medusa) player_atual;
						medusa.ataqueEspecial(herois.get(hero));

					}else{
						player_atual.attack(herois.get(hero));
					}

				}
				break;	

			default:
				break;
		}
	}
}