package com.rs.game.player.content;

import com.rs.game.World;
import com.rs.game.item.Item;
import com.rs.game.player.Player;
import com.rs.game.player.content.randomevent.AntiBot;
import com.rs.utils.SerializableFilesManager;
import com.rs.utils.Utils;

/**
 *
 * @Author Tristam <Hassan>
 * @Project - 1. Rain
 * @Date - 2 Jan 2015
 *
 **/

public class ReferSystem {

	// Reward was changed, so if you plan to use this (Yes you) you can put it
	// to whatver. ~Enjoy, Tristam.

	public static void SendInvite(Player player, String value) {
		Player p2 = World.getPlayerByDisplayName(value);
		value = Utils.formatPlayerNameForDisplay(value);
		player.getInterfaceManager().closeChatBoxInterface();
		if (!SerializableFilesManager.containsPlayer(value)) {
			player.sm("Unable to refer player - not found in database.");
			return;
		}
		if (p2 == null) {
			player.sm(value + " is offline.");
			return;
		}
		
		if (p2.getSession().getIP().equals(player.getSession().getIP())) {
			player.sm("Unable to refer as it is not allowed to do it to yourself.");
			return;
		}
		
		if(p2.getAsFriendRefer()) {
			player.sm("This player has already been referenced.");
			return;
		}
		
		if (p2.getIronman().getMode(player, 2)) {
			player.sm(value + " is a Hardcore Ironman. They are restricted from this.");
			return;
		}
		
		if (p2.isInCombat(10000) || p2.isLocked() || p2.getInterfaceManager().containsScreenInter()
				|| p2.getControlerManager().getControler() != null || AntiBot.getInstance().hasEvent) {
			player.sm(value + " is busy. Please wait for them to be done.");
			return;
		}
		
		player.sm("Invite sent to " + value + ".");
		player.putReferred(value);
		p2.putReferrer(player.getDisplayName());
		Open(p2);
	}

	public static void Open(Player p2) {
		p2.sm("<col=ff0000>Attention: " + p2.getReferrer() + " has sent you an invite.");
		p2.getInterfaceManager().sendTab(p2.getInterfaceManager().hasRezizableScreen() ? 112 : 172, 1019);
		p2.getPackets().sendHideIComponent(1019, 11, true);
		p2.getPackets().sendHideIComponent(1019, 9, true);
		p2.getPackets().sendIComponentText(1019, 3, "<col=ff0000>Attention!");
		p2.getPackets().sendIComponentText(1019, 18, "Accept");
		p2.getPackets().sendIComponentText(1019, 16, "Decline");
		p2.getPackets().sendIComponentText(1019, 8,
				p2.getReferrer() + " has sent you a referral invite. Do you wish to accept?");
		p2.getPackets().sendIComponentText(1019, 0, "Declining will close this tab and cancel the invite.");
		p2.getInterfaceManager().openGameTab(1);
	}

	public static void handleButtons(int interId, int cid, Player player) {
		Player p2 = World.getPlayerByDisplayName(player.getReferrer());
		if (p2 == null || player == null) {
			player.sm(player.getReferrer() + " has logged out which led to the invite being cancelled.");
			Reset(p2, player, false);
			return;
		}
		if (interId == 1019) {
			switch (cid) {
			case 18:
				// Add Reward ~ Tristam. Have fun :)
				
				
				if(!player.getAsFriendRefer()) {
					if(player.getAsFriendRefer()) {
						
						if(player.getInventory().getFreeSlots() >= 1) {
							//player.getInventory().addItem(new Item(24853, 1));
						}else {
							//player.getBank().addItem(24853, 1, true);
							//player.sm("Was sent to your bank refer ticket.");
						}
						
						//player que enviou 
						if(p2.getInventory().getFreeSlots() >= 1) {
							//p2.getInventory().addItem(new Item(24853, 1));
							//p2.sm("You received refer ticket.");
						}else {
							//p2.getBank().addItem(24853, 1, true);
						//	p2.sm("Was sent to your bank refer ticket.");
						}
						
						p2.sm("You received one more invite point");
						player.setAsfriendRefer();
						//p2.AddRefPoint();
					}
				}else {
					p2.sm("This player has already been referenced.");
					player.sm("You has already been referenced.");
				}
				
				
				Reset(p2, player, true);
				break;
			case 16:
				p2.sm(player.getUsername()+" declined you invite.");
				Reset(p2, player, false);
				break;
			}
			return;
		}
	}

	private static void Reset(Player p2, Player player, boolean Successful) {
		
		p2.putReferred(null);
		player.putReferrer(null);
		
		if (Successful) {
			if(!player.getAsFriendRefer()) {					
					if(player.getInventory().getFreeSlots() >= 1) {
						player.getInventory().addItem(new Item(24853, 1));
					}else {
						player.getBank().addItem(24853, 1, true);
						player.sm("Was sent to your bank refer ticket.");
					}
					
					//player que enviou 
					if(p2.getInventory().getFreeSlots() >= 1) {
						p2.getInventory().addItem(new Item(24853, 1));
						p2.sm("You received refer ticket.");
					}else {
						p2.getBank().addItem(24853, 1, true);
						p2.sm("Was sent to your bank refer ticket.");
					}
					p2.sm("You received one more invite point");
					player.setAsfriendRefer();
					p2.AddRefPoint();
			}else {
				p2.sm("This player has already been referenced.");
				player.sm("You has already been referenced.");
			}
		}else {
			player.sm("decline");
		}
	}

}
