package com.rs.game.player.controlers.varrockmuseum;

import com.rs.game.Animation;
import com.rs.game.player.Player;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;

public class Artefacts {
	
	
	public static final int POTTERY = 11178, OLD_COIN = 11179, ANCIENT_COIN = 11180,
			ANCIENT_SYMBOL = 11181, OLD_SYMBOL = 11182;
	

	
	
	public static void CheckPottery(Player player) { 
		if (player.getInventory().containsItem(POTTERY, 1) && (player.FinishedPottery == true))  {
			player.getDialogueManager().startDialogue("SimpleMessage", "It seems you already contributed the pottery artefact to this display,"
					+ " You may exchange this artefact for another loot at the storage crates.");
			return;
		    }
		if (player.FinishedPottery == true)  {
			Interfaces.ClayPottery(player);
				return;
				}
			player.lock(5);
				player.getPackets().sendGameMessage("You reach for the display case...");
				player.getInventory().deleteItem(POTTERY, 1);
				player.animate(new Animation(537));
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
	                player.getDialogueManager().startDialogue("SimpleMessage", "The display has been updated...");
	               // player.getPackets().sendSoundEffect(54);
					}
				}, 1);
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
		        	player.getPackets().sendConfigByFile(3649, 1);
		        	player.setKudosPoints(player.getKudosPoints() + 10);
		        	player.getPackets().sendGameMessage("And successfully stated the artefact, the Museum rewards you with <col=00e56c>+10 Kudos!");
		        	player.FinishedPottery = true;
		        player.talkedPottery = false;
				}
			}, 2);
			return;
	      }
		 

	

	
		public static void CheckOldCoin(Player player) { 
			if (player.getInventory().containsItem(OLD_COIN, 1) && (player.FinishedOldCoin == true))  {
					player.getDialogueManager().startDialogue("SimpleMessage", "It seems you already contributed the Old Coin artefact to this display,"
							+ " Now you may exchange this artefact for a rarer loot at the storage crates.");
					return;
				}
				if (player.FinishedOldCoin == true)  {
					Interfaces.OldCoin(player);
					return;
					}		
				player.lock(5);
					player.getPackets().sendGameMessage("You reach for the display case...");
					player.getInventory().deleteItem(OLD_COIN, 1);
					player.animate(new Animation(537));
					WorldTasksManager.schedule(new WorldTask() {
						@Override
						public void run() {
		                player.getDialogueManager().startDialogue("SimpleMessage", "The display has been updated...");
		               // player.getPackets().sendSoundEffect(54);
						}
					}, 1);
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
			        	player.getPackets().sendConfigByFile(3648, 1);
			        	player.setKudosPoints(player.getKudosPoints() + 10);
			        	player.getPackets().sendGameMessage("And successfully stated the artefact, the Museum rewards you with <col=00e56c>+10 Kudos!");
			        	player.FinishedOldCoin = true;
			        	player.talkedOldCoin = false;
					}
				}, 2);
				return;	
			}
		
		
         
		
		public static void CheckAncientCoin(Player player) { 
			if (player.getInventory().containsItem(ANCIENT_COIN, 1) && (player.FinishedAncientCoin == true))  {
					player.getDialogueManager().startDialogue("SimpleMessage", "It seems you already contributed the Ancient Coin artefact to this display,"
							+ " Now you may exchange this artefact for a rarer loot at the storage crates.");
					return;
				}
			if (player.FinishedAncientCoin == true)  {
		  	Interfaces.AncientCoin(player);
				return;
				}
				player.lock(5);
					player.getPackets().sendGameMessage("You reach for the display case...");
					player.getInventory().deleteItem(ANCIENT_COIN, 1);
					player.animate(new Animation(537));
					WorldTasksManager.schedule(new WorldTask() {
						@Override
						public void run() {
		                player.getDialogueManager().startDialogue("SimpleMessage", "The display has been updated...");
		               // player.getPackets().sendSoundEffect(54);
						}
					}, 1);
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
			        	player.getPackets().sendConfigByFile(3647, 1);
			        	player.setKudosPoints(player.getKudosPoints() + 10);
			        	player.getPackets().sendGameMessage("And successfully stated the artefact, the Museum rewards you with <col=00e56c>+10 Kudos!");
			        	player.FinishedAncientCoin = true;
			        	player.talkedAncientCoin = false;
					}
				}, 2);
				return;
			}	
		
         
		
		public static void CheckAncientSymbol(Player player) { 
			if (player.getInventory().containsItem(ANCIENT_SYMBOL, 1) && (player.FinishedAncientSymbol == true))  {
					player.getDialogueManager().startDialogue("SimpleMessage", "It seems you already contributed the Ancient Symbol artefact to this display,"
							+ " Now you may exchange this artefact for a rarer loot at the storage crates.");
					return;
				}
			if (player.FinishedAncientSymbol == true)  {
				Interfaces.AncientSymbol(player);
				return;
				}	
				player.lock(5);
					player.getPackets().sendGameMessage("You reach for the display case...");
					player.getInventory().deleteItem(ANCIENT_SYMBOL, 1);
					player.animate(new Animation(537));
					WorldTasksManager.schedule(new WorldTask() {
						@Override
						public void run() {
		                player.getDialogueManager().startDialogue("SimpleMessage", "The display has been updated...");
		               // player.getPackets().sendSoundEffect(54);
						}
					}, 1);
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
			        	player.getPackets().sendConfigByFile(3645, 1);
			        	player.setKudosPoints(player.getKudosPoints() + 10);
			        	player.getPackets().sendGameMessage("And successfully stated the artefact, the Museum rewards you with <col=00e56c>+10 Kudos!");
			        	player.FinishedAncientSymbol = true;
			        	player.talkedAncientSymbol = false;
					}
				}, 2);
				return;
			}	

         
		
		public static void CheckOldSymbol(Player player) { 
			if (player.getInventory().containsItem(OLD_SYMBOL, 1) && (player.FinishedOldSymbol == true))  {
					player.getDialogueManager().startDialogue("SimpleMessage", "It seems you already contributed the Old Symbol artefact to this display,"
							+ " Now you may exchange this artefact for a rarer loot at the storage crates.");
					return;
				}
			if (player.FinishedOldSymbol == true)  {
			Interfaces.OldSymbol(player);
				return;
				}
				player.lock(5);
					player.getPackets().sendGameMessage("You reach for the display case...");
					player.getInventory().deleteItem(OLD_SYMBOL, 1);
					player.animate(new Animation(537));
					WorldTasksManager.schedule(new WorldTask() {
						@Override
						public void run() {
		                player.getDialogueManager().startDialogue("SimpleMessage", "The display has been updated...");
		               // player.getPackets().sendSoundEffect(54);
						}
					}, 1);
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
			        	player.getPackets().sendConfigByFile(3646, 1);
			        	player.setKudosPoints(player.getKudosPoints() + 10);
			        	player.getPackets().sendGameMessage("And successfully stated the artefact, the Museum rewards you with <col=00e56c>+10 Kudos!");
			        	player.FinishedOldSymbol = true;
			        	player.talkedOldSymbol = false;
					}
				}, 2);
				return;
			}
}


