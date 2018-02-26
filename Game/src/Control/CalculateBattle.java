package Control;

import Model.Arena;
import Model.Game;
import Model.Player;
import Model.Villain;

public class CalculateBattle {
	public static int playerLifePoints;
	public static int villainLifePoints;
	
	public CalculateBattle(Game game, int villainNumber){
		CalculateBattle.playerLifePoints = game.getPlayer().getLifePoints();
		CalculateBattle.villainLifePoints = game.getVillains()[villainNumber].getLifePoints();
	}
	
	public int[] calculateTurn(Game game, int villainNumber){
		Player player = game.getPlayer();
		Villain villain = game.getVillains()[villainNumber];
		Arena arena = game.getArena();
		int playerDice = 0;
		int villainDice = 0;
		int playerAttack = 0;
		int villainAttack = 0;
		int playerWinner = 0;
		int villainWinner = 0;
	
				playerDice = arena.getPlayerDice();
				villainDice = arena.getVillainDice();
				
				int playerAttackPoints = player.getAttackPoints();
				int playerDefensePoints = player.getDefensePoints();
				
				int villainAttackPoints = villain.getAttackPoints();
				int villainDefensePoints = villain.getDefensePoints();
				
				if(playerDice > villainDice){
					playerAttack = (playerAttackPoints > villainDefensePoints)? playerAttackPoints : 100;
					int villainNewLife = ((villain.getLifePoints() - playerAttack) < 0) ? 0 : villain.getLifePoints() - playerAttack;
					playerWinner = (villainNewLife == 0) ? 1 : 0 ;
					villain.setLifePoints(villainNewLife);
				}else{
					villainAttack = (villainAttackPoints > playerDefensePoints)? villainDefensePoints : 100;
					int playerNewLife = ((player.getLifePoints() - villainAttack) < 0) ? 0:  player.getLifePoints() - villainAttack;
					villainWinner = (playerNewLife == 0) ? 1 : 0;
					player.setLifePoints(playerNewLife);
				}		
		int[] result = {playerDice, villainDice, playerAttack, villainAttack, playerWinner, villainWinner };
		return result;
	}

	public void resetPointsLife(Game game,int villainNumber){
		Player player = game.getPlayer();
		Villain villain = game.getVillains()[villainNumber];
		
		player.setLifePoints(CalculateBattle.playerLifePoints);
		villain.setLifePoints(CalculateBattle.villainLifePoints);
	}
	
	public float payPlayer(Game game,int villainNumber){
		Player player = game.getPlayer();
		Villain villain = game.getVillains()[villainNumber];
		player.setMoney(player.getMoney() + villain.getMoney());
		return villain.getMoney();
	}
	public float chargePlayer(Game game, int villainNumber){
		Player player = game.getPlayer();
		Villain villain = game.getVillains()[villainNumber];
		player.setMoney(player.getMoney() - 50);
		villain.setMoney(villain.getMoney() + 50);
		
		return 50;
	}
}
