package com.rs.game.player.actions.skills.crafting;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.player.Player;

public class TanHide {
	
	public static void Create(Player player, int[] items, int quantity) {
			int leather = items[0];
			int hide = items[1];
			int price = items[2];
			
			int amountInventory = player.getInventory().getNumberOf(leather);
			
			if(amountInventory <= quantity) {
				quantity = amountInventory;
			}
			int priceTotal = quantity*price;
			if(priceTotal <= player.getMoneyPouch().getTotal()) {
				CreateHide(player, leather, priceTotal, hide, quantity, true);
			}else if(priceTotal <= player.getInventory().getNumberOf(995)) {
				CreateHide(player, leather, priceTotal, hide, quantity, false);
			}else {
				player.getPackets().sendGameMessage("You do not have enough coins for that.");
			}
			
	}
	
	private static void CreateHide(Player player,int leather, int priceTotal, int hide, int quantity, boolean moneypouch) {
		player.getInventory().deleteItem(leather, quantity);
		if(moneypouch) {
			player.getMoneyPouch().takeMoneyFromPouch(priceTotal);
		}else {
			player.getInventory().deleteItem(995, priceTotal);			
		}
		player.getInventory().addItem(hide, quantity);
		player.getPackets()
		.sendGameMessage("You tanned your " + quantity + " "+ ItemDefinitions
                .getItemDefinitions(leather)
                .getName().toLowerCase() +" to "+ ItemDefinitions
                .getItemDefinitions(hide)
                .getName().toLowerCase()+".");
	}
	
	public static boolean hasLeatherHides(Player player) {
		if (player.getInventory().containsItem(1739, 1))
			return true;
		return false;
	}
	
	

	public static boolean hasGreenHides(Player player) {
		if (player.getInventory().containsItem(1753, 1))
			return true;
		return false;
	}

	public static boolean hasBlueHides(Player player) {
		if (player.getInventory().containsItem(1751, 1))
			return true;
		return false;
	}

	public static boolean hasRedHides(Player player) {
		if (player.getInventory().containsItem(1749, 1))
			return true;
		return false;
	}

	public static boolean hasBlackHides(Player player) {
		if (player.getInventory().containsItem(1747, 1))
			return true;
		return false;
	}

	public static boolean hasRoyalHides(Player player) {
		if (player.getInventory().containsItem(24372, 1))
			return true;
		return false;
	}
}
