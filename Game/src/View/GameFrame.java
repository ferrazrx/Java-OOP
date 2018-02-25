package View;

import Control.CalculateBattle;
import Control.CreateHeroes;
import Control.NewGame;
import Model.Game;
import Model.Heroe;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JTable;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CalculateBattle turn;
	private static GameFrame frame;
	private JLabel villainImg;
	private static Game game;
	private JLabel attackPointsInfo;
	private JLabel bgImg;
	private JPanel contentPane;
	private JTable table;
	private JLabel atpoints;
	private JLabel depoints;
	private JPanel newGame;
	private JButton btnNewGame;
	private JLabel HeroImg;
	private JLabel PlayerArenaImg;
	private JPanel store;
	private JPanel arenaView;
	private static Heroe[] heroes;
	private int heroCount = 0;
	private JLabel villainNameInfo;
	private JLabel heroeName;
	private int villainCount = 0;
	private JPanel dashboard;
	private JTextPane battleInfo;
	private JLabel moneyAmount;
	private JLabel defensePointsInfo;
	private JLabel playerName;
	private JLabel VillainArenaImg;
	private JLabel imgPlayer;
	private JLabel pointsNumber;
	private JLabel bgDashboardImage;
	private String basePath = "/Users/mbp/Documents/NSCC/OOP/Prog1400---OOP/Game/";
	private Timer timer;
	private JLabel ArenaHeroTitle;
	private JLabel ArenaVillainTitle;
	private JLabel heroLifePointsValue;
	private JLabel villainLifePointsValue;
	private JLabel arenaBg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game = new Game();
					heroes = CreateHeroes.showHeroes();
				    frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 477);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Create newGamePanel
		newGame = new JPanel();
		contentPane.add(newGame, "name_404313018465");
		newGame.setLayout(null);
		
		//Create new game button
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = NewGame.createGame(game, heroes[heroCount].getName(), heroes[heroCount].getLifePoints(), heroes[heroCount].getItems(), heroes[heroCount].getMoney(), heroes[heroCount].getAttackPoints(), heroes[heroCount].getDefensePoints(), heroes[heroCount].getImg(), heroes[heroCount].getBackground());
				refreshComponents();
				newGame.setVisible(false);
				dashboard.setVisible(true);
				
			}
		});
		btnNewGame.setBounds(282, 410, 110, 29);
		newGame.add(btnNewGame);
		
		//Player information panel
		JPanel playerInfo = new JPanel();
		playerInfo.setBounds(187, 282, 298, 126);
		newGame.add(playerInfo);
		playerInfo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Player Information:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Keep Calm", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(6, 0, 286, 22);
		playerInfo.add(lblNewLabel_1);
		
		//set initial values
		heroeName = new JLabel(heroes[0].getName());
		heroeName.setHorizontalAlignment(SwingConstants.CENTER);
		heroeName.setFont(new Font("Krungthep", Font.PLAIN, 28));
		heroeName.setBounds(16, 22, 286, 37);
		playerInfo.add(heroeName);
		
		JLabel lblAttackPoints = new JLabel("Attack Points");
		lblAttackPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttackPoints.setFont(new Font("Keep Calm", Font.PLAIN, 13));
		lblAttackPoints.setBounds(6, 72, 141, 16);
		playerInfo.add(lblAttackPoints);
		
		JLabel lblDefensePoints = new JLabel("Defense Points");
		lblDefensePoints.setFont(new Font("Keep Calm", Font.PLAIN, 13));
		lblDefensePoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefensePoints.setBounds(146, 72, 146, 16);
		playerInfo.add(lblDefensePoints);
		
		//Attack Points
		atpoints = new JLabel(Integer.toString(heroes[0].getAttackPoints()));
		atpoints.setHorizontalAlignment(SwingConstants.CENTER);
		atpoints.setFont(new Font("Verdana", Font.PLAIN, 30));
		atpoints.setBounds(6, 89, 141, 31);
		playerInfo.add(atpoints);
		
		//Defense Points
		depoints = new JLabel(Integer.toString(heroes[0].getDefensePoints()));
		depoints.setHorizontalAlignment(SwingConstants.CENTER);
		depoints.setFont(new Font("Verdana", Font.PLAIN, 30));
		depoints.setBounds(150, 88, 142, 31);
		playerInfo.add(depoints);
		
		//Main Title
		JPanel mainTitle = new JPanel();
		mainTitle.setBounds(134, 6, 394, 72);
		newGame.add(mainTitle);
		
		JLabel lblHeroesVsVillains = new JLabel("Heroes Vs Villains");
		lblHeroesVsVillains.setFont(new Font("Silom", Font.PLAIN, 35));
		mainTitle.add(lblHeroesVsVillains);
		
		JLabel lblNewLabel = new JLabel("Select your player:");
		lblNewLabel.setFont(new Font("Keep Calm", Font.PLAIN, 13));
		mainTitle.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		
		JPanel playerImgChoose = new JPanel();
		playerImgChoose.setBackground(Color.LIGHT_GRAY);
		playerImgChoose.setBounds(187, 90, 298, 180);
		newGame.add(playerImgChoose);
		playerImgChoose.setLayout(null);
		
		JButton previous = new JButton("<");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changeHeroeOption("previous");
			}
		});
		previous.setBounds(6, 79, 45, 29);
		playerImgChoose.add(previous);
		
		//Player Img
		HeroImg = new JLabel("");
		HeroImg.setBounds(63, 0, 164, 180);
		playerImgChoose.add(HeroImg);
		HeroImg.setIcon(new ImageIcon(basePath + heroes[0].getImg()));
		HeroImg.setBackground(Color.GRAY);
		
		JButton next = new JButton(">");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changeHeroeOption("next");
			}
		});
		next.setBounds(247, 79, 45, 29);
		playerImgChoose.add(next);
		
		//Background Image
		bgImg = new JLabel("");
		bgImg.setIcon(new ImageIcon(basePath + heroes[0].getBackground()));
		bgImg.setBounds(6, 6, 673, 439);
		newGame.add(bgImg);
		
		dashboard = new JPanel();
		dashboard.setBackground(Color.WHITE);
		contentPane.add(dashboard, "name_404284489252");
		dashboard.setLayout(null);
		
		imgPlayer = new JLabel("");
		imgPlayer.setBounds(37, 23, 150, 180);
		dashboard.add(imgPlayer);
		
		JPanel arena = new JPanel();
		arena.setBounds(228, 238, 445, 201);
		dashboard.add(arena);
		arena.setLayout(null);
		
		JLabel lblArena = new JLabel("Arena");
		lblArena.setHorizontalAlignment(SwingConstants.CENTER);
		lblArena.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblArena.setBounds(6, 6, 433, 16);
		arena.add(lblArena);
		
		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeBattle();
				dashboard.setVisible(false);
				store.setVisible(false);
				newGame.setVisible(false);
				arenaView.setVisible(true);
				
				
			}
		});
		btnFight.setBounds(322, 166, 117, 29);
		arena.add(btnFight);
		
		JLabel lblSelectA = new JLabel("Select a opponent:");
		lblSelectA.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectA.setBounds(201, 34, 238, 16);
		arena.add(lblSelectA);
		
		villainImg = new JLabel("");
		villainImg.setBounds(6, 6, 150, 180);
		arena.add(villainImg);
		
		villainNameInfo = new JLabel("");
		villainNameInfo.setHorizontalAlignment(SwingConstants.LEFT);
		villainNameInfo.setFont(new Font("Keep Calm", Font.PLAIN, 19));
		villainNameInfo.setBounds(201, 62, 238, 42);
		arena.add(villainNameInfo);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeVillainOption("previous");
			}
		});
		button.setBounds(190, 115, 45, 29);
		arena.add(button);
		
		JButton button_1 = new JButton(">");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeVillainOption("next");
			}
		});
		button_1.setBounds(231, 115, 45, 29);
		arena.add(button_1);
		
		JPanel inventory = new JPanel();
		inventory.setBounds(6, 238, 210, 201);
		dashboard.add(inventory);
		inventory.setLayout(null);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setBounds(73, 5, 59, 16);
		inventory.add(lblInventory);
		
		table = new JTable();
		table.setBounds(16, 33, 177, 123);
		inventory.add(table);
		
		JButton btnGoToThe = new JButton("Store");
		btnGoToThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGoToThe.setBounds(58, 166, 98, 29);
		inventory.add(btnGoToThe);
		
		JPanel InfoPanel = new JPanel();
		InfoPanel.setBounds(228, 6, 445, 220);
		dashboard.add(InfoPanel);
		InfoPanel.setLayout(null);
		
		playerName = new JLabel("");
		playerName.setBounds(6, 5, 433, 44);
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		InfoPanel.add(playerName);
		playerName.setFont(new Font("Verdana", Font.PLAIN, 35));
		
		
		JPanel attackInfo = new JPanel();
		attackInfo.setBackground(Color.GREEN);
		attackInfo.setForeground(Color.BLACK);
		attackInfo.setBounds(61, 142, 133, 59);
		InfoPanel.add(attackInfo);
		attackInfo.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Attack Points");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 121, 16);
		attackInfo.add(lblNewLabel_2);
		
		attackPointsInfo = new JLabel("");
		attackPointsInfo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		attackPointsInfo.setHorizontalAlignment(SwingConstants.CENTER);
		attackPointsInfo.setBounds(6, 23, 121, 30);
		attackInfo.add(attackPointsInfo);
		
		JPanel DefenseInfo = new JPanel();
		DefenseInfo.setBackground(Color.RED);
		DefenseInfo.setBounds(258, 142, 133, 59);
		InfoPanel.add(DefenseInfo);
		DefenseInfo.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Defense Points");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(6, 6, 121, 16);
		DefenseInfo.add(lblNewLabel_3);
		
		defensePointsInfo = new JLabel("");
		defensePointsInfo.setHorizontalAlignment(SwingConstants.CENTER);
		defensePointsInfo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		defensePointsInfo.setBounds(6, 23, 121, 30);
		DefenseInfo.add(defensePointsInfo);
		
		JLabel lblLifePoints = new JLabel("Life Points:");
		lblLifePoints.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblLifePoints.setBounds(61, 61, 133, 30);
		InfoPanel.add(lblLifePoints);
		
		pointsNumber = new JLabel("");
		
		pointsNumber.setFont(new Font("Verdana", Font.PLAIN, 34));
		pointsNumber.setBounds(172, 57, 219, 34);
		InfoPanel.add(pointsNumber);
		
		JLabel Money = new JLabel("Gold:");
		Money.setFont(new Font("Verdana", Font.PLAIN, 18));
		Money.setBounds(61, 100, 133, 30);
		InfoPanel.add(Money);
		
		moneyAmount = new JLabel("");
		moneyAmount.setFont(new Font("Verdana", Font.PLAIN, 34));
		moneyAmount.setBounds(117, 96, 219, 34);
		InfoPanel.add(moneyAmount);
		
		JButton btnChangePlayer = new JButton("Change Player");
		btnChangePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard.setVisible(false);
				newGame.setVisible(true);
			}
		});
		btnChangePlayer.setBounds(58, 202, 117, 29);
		dashboard.add(btnChangePlayer);
		
		bgDashboardImage = new JLabel("");
		bgDashboardImage.setBounds(0, 0, 679, 445);
		dashboard.add(bgDashboardImage);
		
		store = new JPanel();
		contentPane.add(store, "name_2408905565437");
		store.setLayout(null);
		
		JButton btnBuyItem = new JButton("Buy Item");
		btnBuyItem.setBounds(48, 410, 117, 29);
		store.add(btnBuyItem);
		
		JPanel storeMainTitle = new JPanel();
		storeMainTitle.setBounds(0, 6, 679, 47);
		store.add(storeMainTitle);
		storeMainTitle.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome to the Store");
		lblNewLabel_5.setBounds(33, 0, 312, 49);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Oswald Stencil", Font.PLAIN, 33));
		storeMainTitle.add(lblNewLabel_5);
		
		JLabel lblGold = new JLabel("Gold:");
		lblGold.setBounds(500, 6, 61, 16);
		storeMainTitle.add(lblGold);
		
		JLabel storeGold = new JLabel("New label");
		storeGold.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		storeGold.setBounds(541, 6, 132, 35);
		storeMainTitle.add(storeGold);
		
		JPanel storeOptions = new JPanel();
		storeOptions.setBounds(216, 75, 444, 335);
		store.add(storeOptions);
		storeOptions.setLayout(null);
		
		JRadioButton rdbtnItemOne = new JRadioButton("Item1");
		rdbtnItemOne.setFont(new Font("Oswald Stencil", Font.PLAIN, 20));
		rdbtnItemOne.setBounds(6, 6, 370, 23);
		storeOptions.add(rdbtnItemOne);
		
		JRadioButton radioButtonTwo = new JRadioButton("Item2");
		radioButtonTwo.setFont(new Font("Oswald Stencil", Font.PLAIN, 20));
		radioButtonTwo.setBounds(6, 113, 370, 23);
		storeOptions.add(radioButtonTwo);
		
		JRadioButton radioButtonThree = new JRadioButton("Item3");
		radioButtonThree.setFont(new Font("Oswald Stencil", Font.PLAIN, 20));
		radioButtonThree.setBounds(6, 228, 370, 23);
		storeOptions.add(radioButtonThree);
		
		JButton btnBackToGame = new JButton("Back to Game");
		btnBackToGame.setBounds(562, 410, 117, 29);
		store.add(btnBackToGame);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/mbp/Documents/NSCC/OOP/Prog1400---OOP/Game/bg_batman.jpg"));
		lblNewLabel_4.setBounds(0, 0, 689, 445);
		store.add(lblNewLabel_4);
		
		arenaView = new JPanel();
		contentPane.add(arenaView, "name_3856763102410");
		arenaView.setLayout(null);
		
		JPanel heroLifePoints = new JPanel();
		heroLifePoints.setBounds(8, 272, 150, 65);
		arenaView.add(heroLifePoints);
		heroLifePoints.setLayout(null);
		
		heroLifePointsValue = new JLabel("New label");
		heroLifePointsValue.setFont(new Font("Oswald Stencil", Font.PLAIN, 28));
		heroLifePointsValue.setHorizontalAlignment(SwingConstants.CENTER);
		heroLifePointsValue.setBounds(6, 6, 138, 53);
		heroLifePoints.add(heroLifePointsValue);
		
		JPanel villainLifePoints = new JPanel();
		villainLifePoints.setBounds(523, 272, 150, 65);
		arenaView.add(villainLifePoints);
		villainLifePoints.setLayout(null);
		
		villainLifePointsValue = new JLabel("New label");
		villainLifePointsValue.setHorizontalAlignment(SwingConstants.CENTER);
		villainLifePointsValue.setFont(new Font("Oswald Stencil", Font.PLAIN, 28));
		villainLifePointsValue.setBounds(6, 6, 138, 53);
		villainLifePoints.add(villainLifePointsValue);
		
		JPanel arenaTitle = new JPanel();
		arenaTitle.setBounds(8, 6, 665, 58);
		arenaView.add(arenaTitle);
		arenaTitle.setLayout(null);
		
		ArenaHeroTitle = new JLabel("New label");
		ArenaHeroTitle.setFont(new Font("Lemon/Milk", Font.PLAIN, 23));
		ArenaHeroTitle.setBounds(6, 6, 294, 46);
		arenaTitle.add(ArenaHeroTitle);
		
		ArenaVillainTitle = new JLabel("New label");
		ArenaVillainTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		ArenaVillainTitle.setFont(new Font("Lemon/Milk", Font.PLAIN, 23));
		ArenaVillainTitle.setBounds(365, 6, 294, 46);
		arenaTitle.add(ArenaVillainTitle);
		
		JPanel ArenaInfo = new JPanel();
		ArenaInfo.setBounds(170, 85, 334, 354);
		arenaView.add(ArenaInfo);
		ArenaInfo.setLayout(null);
		
		JLabel lblArena_1 = new JLabel("Arena");
		lblArena_1.setFont(new Font("Oswald Stencil", Font.PLAIN, 26));
		lblArena_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblArena_1.setBounds(6, 25, 322, 28);
		ArenaInfo.add(lblArena_1);
		
		JButton btnBackToGame_1 = new JButton("Back to Game");
		btnBackToGame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turn.resetPointsLife(game, villainCount);
				timer.stop();
				dashboard.setVisible(true);
				arenaView.setVisible(false);
				newGame.setVisible(false);
				store.setVisible(false);
			}
		});
		btnBackToGame_1.setBounds(109, 319, 117, 29);
		ArenaInfo.add(btnBackToGame_1);
		
		battleInfo = new JTextPane();
		battleInfo.setBounds(16, 65, 301, 178);
		ArenaInfo.add(battleInfo);
		
		PlayerArenaImg = new JLabel("");
		PlayerArenaImg.setBounds(8, 85, 150, 180);
		arenaView.add(PlayerArenaImg);
		
		VillainArenaImg = new JLabel("");
		VillainArenaImg.setBounds(523, 85, 150, 180);
		arenaView.add(VillainArenaImg);
		
		arenaBg = new JLabel("");
		arenaBg.setBounds(0, 0, 679, 445);
		arenaView.add(arenaBg);
		
		dashboard.setVisible(false);
	}
	
	//Helper Functions
	public void changeHeroeOption(String action){
		switch(action){
			case "next":
				heroCount++;
				heroCount = heroCount >= heroes.length? 0 : heroCount;
				heroeName.setText(heroes[heroCount].getName());
				HeroImg.setIcon(new ImageIcon(basePath + heroes[heroCount].getImg()));
				bgImg.setIcon(new ImageIcon(basePath + heroes[heroCount].getBackground()));
				atpoints.setText(Integer.toString(heroes[heroCount].getAttackPoints()));
				depoints.setText(Integer.toString(heroes[heroCount].getDefensePoints()));
				break;
			case "previous":
				heroCount--;
				heroCount = heroCount == -1 ? heroes.length-1 : heroCount;
				heroeName.setText(heroes[heroCount].getName());
				HeroImg.setIcon(new ImageIcon(basePath + heroes[heroCount].getImg()));
				bgImg.setIcon(new ImageIcon(basePath + heroes[heroCount].getBackground()));
				atpoints.setText(Integer.toString(heroes[heroCount].getAttackPoints()));
				depoints.setText(Integer.toString(heroes[heroCount].getDefensePoints()));
				break;	
		}
	}
	
	public void changeVillainOption(String action){
		switch(action){
		case "next":
			villainCount++;
			villainCount = villainCount >= game.getVillains().length? 0 : villainCount;
			villainNameInfo.setText(game.getVillains()[villainCount].getName());
			villainImg.setIcon(new ImageIcon(basePath + game.getVillains()[villainCount].getImg()));
			break;
		case "previous":
			villainCount--;
			villainCount = villainCount == -1 ? game.getVillains().length-1 : villainCount;
			villainNameInfo.setText(game.getVillains()[villainCount].getName());
			villainImg.setIcon(new ImageIcon(basePath + game.getVillains()[villainCount].getImg()));
			break;	
	}
	}
	
	public void refreshComponents(){
		playerName.setText(game.getPlayer().getName());
		pointsNumber.setText(Integer.toString(game.getPlayer().getLifePoints())+" PX");
		attackPointsInfo.setText(Integer.toString(game.getPlayer().getAttackPoints()) + " P");
		defensePointsInfo.setText(Integer.toString(game.getPlayer().getDefensePoints()) + " P");
		villainImg.setIcon(new ImageIcon(basePath + game.getVillains()[0].getImg()));
		villainNameInfo.setText(game.getVillains()[0].getName());
		imgPlayer.setIcon(new ImageIcon(basePath + game.getPlayer().getImg()));
		bgDashboardImage.setIcon(new ImageIcon(basePath + game.getPlayer().getBackground()));
		moneyAmount.setText(Float.toString(game.getPlayer().getMoney()));
	}
	
	public void executeBattle(){
		//Update Battle View
		arenaBg.setIcon(new ImageIcon(basePath + game.getPlayer().getBackground()));
		PlayerArenaImg.setIcon(new ImageIcon(basePath + game.getPlayer().getImg()));
		VillainArenaImg.setIcon(new ImageIcon(basePath + game.getVillains()[villainCount].getImg()));
		ArenaHeroTitle.setText(game.getPlayer().getName());
		ArenaVillainTitle.setText(game.getVillains()[villainCount].getName());
		heroLifePointsValue.setText(Integer.toString(game.getPlayer().getLifePoints()));
		villainLifePointsValue.setText(Integer.toString(game.getVillains()[villainCount].getLifePoints()));	
		battleInfo.setText("");
		
		//Start Battle
		 turn = new CalculateBattle(game, villainCount);
		
		 timer = new Timer(1500, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	int[] results = turn.calculateTurn(game, villainCount);
		    	
		    	if(results[4] != 0){
		    		String message = game.getPlayer().getName() + " won the battle!";
		    		battleInfo.setText(message);
		    		turn.resetPointsLife(game, villainCount);
		    		villainLifePointsValue.setText("0");	
		    		timer.stop();
		    	} else if(results[5] !=0){
		    		String message = game.getVillains()[villainCount].getName() + " won the battle!";
		    		battleInfo.setText(message);
		    		heroLifePointsValue.setText("0");
		    		turn.resetPointsLife(game, villainCount);
		    		timer.stop();
		    	}else{
		    		//{playerDice, villainDice, playerAttack, villainAttack, playerWinner, villainWinner }
			    	String message = game.getPlayer().getName() + " rolled the dice and got " + results[0] + ".\n" +
			    	                 game.getVillains()[villainCount].getName() + " rolled the dice and got " + results[1] + ".\n\n";
			    	if(results[2] != 0){
			    		message += game.getPlayer().getName() + " attacked with " + results[2] + " points.\n";
			    	}else{
			    		message += game.getVillains()[villainCount].getName() + " attaked you with " + results[3] + " points.\n";
			    	}
			    	refreshComponentsArena();
			    	battleInfo.setText(message);
		    	}
		    }    
		});
		timer.start();
	}
	public void refreshComponentsArena(){
		ArenaHeroTitle.setText(game.getPlayer().getName());
		ArenaVillainTitle.setText(game.getVillains()[villainCount].getName());
		heroLifePointsValue.setText(Integer.toString(game.getPlayer().getLifePoints()));
		villainLifePointsValue.setText(Integer.toString(game.getVillains()[villainCount].getLifePoints()));	
	}
}
