package Control;

import java.util.ArrayList;
import java.util.Arrays;

import Model.Heroe;
import Model.Item;

public class CreateHeroes {
	public static Heroe[] showHeroes(){
		
		//(String name, int lifePoints, ArrayList<Item> items, float money, int attackPoints, int defensePoints, String img, String bg)
		Item batatang = new Item("Batarang", 50, 10, 100, "Batarang are throwing weapons relating to that of either boomarangs or shurikens in the shape of a bat. These can be used for many things such as cutting, immobilizing, etc.", "batatang.png");
		Item batDarts = new Item("Bat-Darts", 30, 5, 80, "Bat-Darts: A form of tranquilizer darts specialized for the needs of Batman.", "dart.png");
		Item explosiveGel = new Item("Explosive Gel", 20, 0, 50, "Explosive Gel: A handheld non-lethal firearm that projects a foam used to stick thugs to walls floors etc.", "gel.png");
		/*
		Item batBolas = new Item("Bat-Bolas", 10, 2, 30, "Bat-Bolas : A bolas to be thrown around the feet of an fleeing opponent.");
		Item batStungun = new Item("Bat Stungun", 30, 10, 65, "Bat Stungun: A knockout tool used by Batman to temporarily paralyze enemies.");
		Item flamethrower = new Item("Flamethrower", 20, 20, 50, "Flamethrower: A miniature flamethrower used on Bat-Bane.");
		Item flashBang = new Item("Flash-Bang Grenades", 30, 20, 90, "Flash-Bang Grenades: Grenades that release a device that temporarily impairs visionary and auditory capabilities to those near after detonation.");
		Item tearGas = new Item("Tears-Gas", 10, 50, 40, "Tear-Gas Pellets: Small capsules that release tear gas with the breaking of the outer shell.");
		Item empGrenade = new Item("EMP Grenade", 60, 5, 120, "EMP Grenade: A small grenade which, once detonated, destroys all electronics within a seven foot radius.");
		*/
		
		ArrayList<Item> batmanItems = new ArrayList<Item>() ;
		batmanItems.add(batatang);
		batmanItems.add(batDarts);
		batmanItems.add(explosiveGel);
		Heroe batman = new Heroe("Batman", 500, batmanItems, 120, 110, 110, "batman.png", "bg_batman.jpg");
		
		Item laser = new Item("Heat Vision", 100 , 100, 100, "His 'heat vision' can destroy the enemy. He will  able to shoot his stored-up solar energy out through his eyes.", "laser.png");
		Item superPunch = new Item("Super Punch", 80, 20, 60, "A superman punch is a technique used in by superman dureing the fight.", "punch.png");
		Item superKick = new Item("Super Kick", 120, 10, 80, "A superman kick is a technique used in by superman dureing the fight.", "kick.png");
		ArrayList<Item> supermanItems = new ArrayList<Item>(Arrays.asList(laser, superPunch, superKick));
		Heroe superman = new Heroe("Superman", 800, supermanItems, 100, 120, 130, "superman.png", "bg_superman.jpg");
		

		Item lasso = new Item("Lasso Of Truth", 50, 10, 100, "Forged into a weapon by the Greek god Hephaestus, the lasso (like most of her weapons) is more than a glowing rope. We have already seen its immense strength in action, but it also has some more magical applications.", "lasso.png" );
		Item bracelets = new Item("Bracelets Of Victory", 10, 80, 80, "A key part of Wonder Woman’s costume, the Bracelets of Victory are silver cuffs worn around Diana’s wrists – but they are far more than jewelry.", "bracelets.png");
		Item tiara = new Item("Royal Tiara", 10, 50, 50, "While Wonder Woman’s tiara is a symbol of her royalty (as Princess of Paradise Island) and her heritage, it’s important to keep in mind that she is a warrior princess — so her crown is also used as a weapon.", "tiara.png");
	
		ArrayList<Item> womanItems = new ArrayList<Item>(Arrays.asList(lasso, bracelets, tiara)) ;		
		Heroe woman = new Heroe("Wonder Woman", 700, womanItems, 120, 120, 110, "woman.png", "bg_woman.jpg");
		
		Heroe[] heroes = {batman, superman, woman};
		
		return heroes;
	}
}
