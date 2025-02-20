package app;

import player.Player;

public class App {
    public static void main(String[] args) throws  Exception {
        Player player = new Player("Jogador 1", 10, 10, 10, 10);
        Player player2 = new Player("Jogador2", 10, 10, 10, 10);
        Player player3 = new Player("Jogador3", 10, 10, 10, 10);
        
        Player.listaPlayers();
    }
}
