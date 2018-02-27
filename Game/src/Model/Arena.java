package Model;
import java.util.concurrent.ThreadLocalRandom;

public class Arena {
	private int playerDice;
	private int villainDice;
	
	private int generateDice(){
		int min = 1;
		int max = 6;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		return randomNum;
	}

	public int getPlayerDice() {
		this.playerDice = generateDice();
		return playerDice;
	}


	public int getVillainDice() {
		this.villainDice = generateDice();
		return villainDice;
	}

}
