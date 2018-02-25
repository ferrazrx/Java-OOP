package Control;

import java.util.ArrayList;
import java.util.Arrays;

import Model.Heroe;
import Model.Item;

public class CreateHeroes {
	public static Heroe[] showHeroes(){
		Item batatang = new Item("Batarang", 50, 10, 100, "Batarang are throwing weapons relating to that of either boomarangs or shurikens in the shape of a bat. These can be used for many things such as cutting, immobilizing, etc.");
		Item batDarts = new Item("Bat-Darts", 30, 5, 80, "Bat-Darts: A form of tranquilizer darts specialized for the needs of Batman.");
		Item explosiveGel = new Item("Explosive Gel", 20, 0, 50, "Explosive Gel: A handheld non-lethal firearm that projects a foam used to stick thugs to walls floors etc.");
		/*
		Item batBolas = new Item("Bat-Bolas", 10, 2, 30, "Bat-Bolas : A bolas to be thrown around the feet of an fleeing opponent.");
		Item batStungun = new Item("Bat Stungun", 30, 10, 65, "Bat Stungun: A knockout tool used by Batman to temporarily paralyze enemies.");
		Item flamethrower = new Item("Flamethrower", 20, 20, 50, "Flamethrower: A miniature flamethrower used on Bat-Bane.");
		Item flashBang = new Item("Flash-Bang Grenades", 30, 20, 90, "Flash-Bang Grenades: Grenades that release a device that temporarily impairs visionary and auditory capabilities to those near after detonation.");
		Item tearGas = new Item("Tears-Gas", 10, 50, 40, "Tear-Gas Pellets: Small capsules that release tear gas with the breaking of the outer shell.");
		Item empGrenade = new Item("EMP Grenade", 60, 5, 120, "EMP Grenade: A small grenade which, once detonated, destroys all electronics within a seven foot radius.");
		*/
		
		ArrayList<Item> batmanItems = new ArrayList<Item>(Arrays.asList(batatang, batDarts, explosiveGel)) ;
		Heroe batman = new Heroe("Batman", 500, batmanItems, 160, 90, 90, "batman.png", "bg_batman.jpg");
		
		Item laser = new Item(null, 0, 0, 0, null);
		Item superPunch = new Item(null, 0, 0, 0, null);
		Item superKick = new Item(null, 0, 0, 0, null);
		ArrayList<Item> supermanItems = new ArrayList<Item>(Arrays.asList(laser, superPunch, superKick));
		Heroe superman = new Heroe("Superman", 800, supermanItems, 120, 120, 120, "superman.png", "bg_superman.jpg");
		

		Item lasso = new Item("Lasso Of Truth", 50, 10, 100, "Forged into a weapon by the Greek god Hephaestus, the lasso (like most of her weapons) is more than a glowing rope. We have already seen its immense strength in action, but it also has some more magical applications." );
		Item bracelets = new Item("Bracelets Of Victory", 10, 80, 80, "A key part of Wonder Woman’s costume, the Bracelets of Victory are silver cuffs worn around Diana’s wrists – but they are far more than jewelry.");
		Item tiara = new Item("Royal Tiara", 10, 50, 50, "While Wonder Woman’s tiara is a symbol of her royalty (as Princess of Paradise Island) and her heritage, it’s important to keep in mind that she is a warrior princess — so her crown is also used as a weapon.");
	
		ArrayList<Item> womanItems = new ArrayList<Item>(Arrays.asList(lasso, bracelets, tiara)) ;		
		Heroe woman = new Heroe("Wonder Woman", 800, womanItems, 120, 80, 130, "woman.png", "bg_woman.jpg");
		
		Heroe[] heroes = {batman, superman, woman};
		
		return heroes;
	}
}
