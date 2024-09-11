package com.rs.game.player.dialogues.item;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.World;
import com.rs.game.item.Item;
import com.rs.game.player.dialogues.Dialogue;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;

public class MemberShip extends Dialogue {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		int itemId = (Integer) parameters[0];
		String name = ItemDefinitions.getItemDefinitions(itemId).getName();
		sendOptionsDialogue(name, "Yes", "No");
		
		
		stage = (byte) (itemId == 24861 ? player.isLegendaryMember() ? 4 : 3 : itemId == 24859 ? player.isExtremeMember() ? 4 : 2 : itemId == 24857 ? player.isSuperMember() ? 4 : 1 : 0);
	}

	@Override
	public void run(int interfaceId, int componentId) {
		switch (stage) {
			case END:
				end();
			break;
			case 0:
				player.getInventory().deleteItem(new Item(24855, 1));
				sendItemDialogueNoContinue(player, 24855, 1, "Processing...");
				player.lock();
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						sendDialogue("30 days of membership has successfully been added to your account!");
						player.makeMember(30);
						player.unlock();
						player.member = true;
						player.getAppearence().setTitle(303);
						World.sendWorldMessage("<img=6><col=ff0000>News: " + player.getDisplayName() + " became a Member!", false);
						stage = END;
					}
				}, 5);
			break;
			case 1:
				player.getInventory().deleteItem(new Item(24857, 1));
				sendItemDialogueNoContinue(player, 24857, 1, "Processing...");
				player.lock();
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						sendDialogue("You received Super Member has successfully been added to your account!");
						player.setSuperMember(true);
						player.getAppearence().setTitle(302);
						player.unlock();
						World.sendWorldMessage("<img=6><col=ff0000>News: " + player.getDisplayName() + " became a Super Member!", false);
						stage = END;
					}
				}, 5);
			break;
			case 2:
				player.getInventory().deleteItem(new Item(24859, 1));
				sendItemDialogueNoContinue(player, 24859, 1, "Processing...");
				player.lock();
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						sendDialogue("You received Extreme Member has successfully been added to your account!");
						player.setExtremeMember(true);
						player.getAppearence().setTitle(301);
						player.unlock();
						World.sendWorldMessage("<img=6><col=ff0000>News: " + player.getDisplayName() + " became a Extreme Member!", false);
						stage = END;
					}
				}, 5);
			break;
			case 3:
				player.getInventory().deleteItem(new Item(24861, 1));
				sendItemDialogueNoContinue(player, 24861, 1, "Processing...");
				player.lock();
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						sendDialogue("You received Legendary Member has successfully been added to your account!");
						player.setLegendaryMember(true);
						player.getAppearence().setTitle(300);
						player.unlock();
						World.sendWorldMessage("<img=6><col=ff0000>News: " + player.getDisplayName() + " became a Legenday Member!", false);
						stage = END;
					}
				}, 5);
				
			break;
			case 4:
				player.getPackets().sendGameMessage("You already have this rank.");
				end();
			break;
		}
		
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
