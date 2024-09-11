package com.rs.game.player.content;

import com.rs.game.Animation;
import com.rs.game.item.Item;
import com.rs.game.player.Player;

public class Encant {
	//anim 2145
	
	public static void FarseerHelm(Player player) {
		int Helm = 3755;
		int Charged = 12679;
		if(player.getInventory().contains(new Item(Helm, 1))) { 
			if(player.getSkills().hasRequirements(23, 45)) {
				if(player.getRessurgePoints() >= 100000 && player.canBuy(5000000)) {
					if(player.getInventory().hasFreeSlots()) {
						player.setRessurgePoints(player.getRessurgePoints() - 100000);
						player.getInventory().deleteItem(new Item(Helm, 1));
						player.getInventory().deleteItem(new Item(995, 5000000));
						player.getInventory().addItem(new Item(Charged, 1));
						player.animate(new Animation(2145));
						return;
					}else {
						player.sm("You don't have space in your inventory");
						return;
					}					
					
				}else {
					player.sm("You need 100k of resurge points & 5M");
					return;
				}
			}else {
				player.sm("You need level 20 summoning.");
				return;
			}
		}else {
			player.sm("You don't have the helmet.");
			return;
		}
	}
	
	public static void WarriorHelm(Player player) {
		int Helm = 3753;
		int Charged = 12677;
		if(player.getInventory().contains(new Item(Helm, 1))) { 
			if(player.getSkills().hasRequirements(23, 45)) {
				if(player.getRessurgePoints() >= 100000 && player.canBuy(5000000) ) {
					if(player.getInventory().hasFreeSlots()) {
						player.setRessurgePoints(player.getRessurgePoints() - 100000);
						player.getInventory().deleteItem(new Item(Helm, 1));
						player.getInventory().deleteItem(new Item(995, 5000000));
						player.getInventory().addItem(new Item(Charged, 1));
						player.animate(new Animation(2145));
						return;
					}else {
						player.sm("You don't have space in your inventory");
						return;
					}					
					
				}else {
					player.sm("You need 100k of resurge points 5M");
					return;
				}
			}else {
				player.sm("You need level 20 summoning.");
				return;
			}
		}else {
			player.sm("You don't have the helmet.");
			return;
		}
	}
	
	public static void BerserkerHelm(Player player) {
		int Helm = 3751;
		int Charged = 12675;
		if(player.getInventory().contains(new Item(Helm, 1))) { 
			if(player.getSkills().hasRequirements(23, 45)) {
				if(player.getRessurgePoints() >= 100000 && player.canBuy(5000000) ) {
					if(player.getInventory().hasFreeSlots()) {
						player.setRessurgePoints(player.getRessurgePoints() - 100000);
						player.getInventory().deleteItem(new Item(Helm, 1));
						player.getInventory().deleteItem(new Item(995, 5000000));
						player.getInventory().addItem(new Item(Charged, 1));
						player.animate(new Animation(2145));
						return;
					}else {
						player.sm("You don't have space in your inventory");
						return;
					}					
					
				}else {
					player.sm("You need 100k of resurge points 5M");
					return;
				}
			}else {
				player.sm("You need level 20 summoning.");
				return;
			}
		}else {
			player.sm("You don't have the helmet.");
			return;
		}
	}
	
	public static void ArcherHelm(Player player) {
		int Helm = 3749;
		int Charged = 12673;
		if(player.getInventory().contains(new Item(Helm, 1))) {
			if(player.getSkills().hasRequirements(23, 45)) {
				if(player.getRessurgePoints() >= 100000 && player.canBuy(5000000)) {
					if(player.getInventory().hasFreeSlots()) {
						player.setRessurgePoints(player.getRessurgePoints() - 100000);
						player.getInventory().deleteItem(new Item(Helm, 1));
						player.getInventory().deleteItem(new Item(995, 5000000));
						player.getInventory().addItem(new Item(Charged, 1));
						player.animate(new Animation(2145));
						return;
					}else {
						player.sm("You don't have space in your inventory");
						return;
					}					
					
				}else {
					player.sm("You need 100k of resurge points 5M");
					return;
				}
			}else {
				player.sm("You need level 20 summoning.");
				return;
			}
		}else {
			player.sm("You don't have the helmet.");
			return;
		}
	}
	
	
	public static void NeitiznotHelm(Player player) {
		int Helm = 10828;
		int Charged = 12681;
		if(player.getInventory().contains(new Item(Helm, 1))) { //neitiznot helm
			if(player.getSkills().hasRequirements(23, 45)) {
				if(player.getRessurgePoints() >= 100000 && player.canBuy(5000000) ) {
					if(player.getInventory().hasFreeSlots()) {
						player.setRessurgePoints(player.getRessurgePoints() - 100000);
						player.getInventory().deleteItem(new Item(Helm, 1));
						player.getInventory().deleteItem(new Item(995, 5000000));
						player.getInventory().addItem(new Item(Charged, 1));
						player.animate(new Animation(2145));
						return;
					}else {
						player.sm("You don't have space in your inventory");
						return;
					}					
					
				}else {
					player.sm("You need 100k of resurge points 5M");
					return;
				}
			}else {
				player.sm("You need level 20 summoning.");
				return;
			}
		}else {
			player.sm("You don't have the helmet.");
			return;
		}
	}
	
	public static void SlayerHelm(Player player) {
		int Helm = 13263;
		int Charged = 15497;
		if(player.getInventory().contains(new Item(Helm, 1))) { //slayer helm
			if(player.getSkills().hasRequirements(23, 20)) {
				if(player.getRessurgePoints() >= 100000 && player.canBuy(5000000) ) {
					if(player.getInventory().hasFreeSlots()) {
						player.setRessurgePoints(player.getRessurgePoints() - 100000);
						player.getInventory().deleteItem(new Item(Helm, 1));
						player.getInventory().deleteItem(new Item(995, 5000000));
						player.getInventory().addItem(new Item(Charged, 1));
						player.animate(new Animation(2145));
						return;
					}else {
						player.sm("You don't have space in your inventory");
						return;
					}					
					
				}else {
					player.sm("You need 100k of resurge points 5M");
					return;
				}
			}else {
				player.sm("You need level 20 summoning.");
				return;
			}
		}else {
			player.sm("You don't have the helmet.");
			return;
		}
		
	}
}
