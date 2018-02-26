package Control;

import java.util.ArrayList;

import Model.Arena;
import Model.Game;
import Model.Item;
import Model.Player;
import Model.Store;
import Model.Villain;

public class NewGame {
	public static Game createGame(Game game, String name, int lifePoints, ArrayList<Item> items, float money, int attackPoints, int defensePoints, String img, String bg){
		//Create Villains
		Villain bane = new Villain("Bane", 1700, items, 800, 100,100,"bane.png", "");
		Villain freeze = new Villain("Mr. Freeze", 300, items, 80, 180,180, "freeze.png", "");
		Villain poison = new Villain("Poison Ivy", 800, items, 300, 120,120, "poison.png", "");
		Villain penguin = new Villain("The Penguin", 900, items, 400, 100,100, "penguin.png", "");
		Villain talia = new Villain("Talia al Ghul", 500, items, 200, 100,100, "talia.png", "");
		Villain face = new Villain("Two-Face", 1000, items, 600, 150,150, "two-face.png", "" );
		Villain riddler = new Villain("Riddler", 300, items, 100, 300,300, "riddler.png", "" );
		
		Villain[] villain = {bane,freeze,poison, penguin,talia,face,riddler};
		
		
		//Create Items in the Store
		Store store = new Store();	
		
		//Create arena
		Arena arena = new Arena();
		
		//Create new Game
		game.setStore(store);
		Player player = new Player(name, lifePoints, items, money, attackPoints, defensePoints, img, bg);
		game.setPlayer(player);
		game.setArena(arena);
		game.setVillains(villain);
		
		return game;
	}

}
