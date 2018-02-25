package Model;

import java.util.ArrayList;

public class Game {
	private Player player;
	private Store store ;
	private Villain[] villains;
	private Arena arena;
	


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Villain[] getVillains() {
		return villains;
	}

	public void setVillains(Villain[] villains) {
		this.villains = villains;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
}
