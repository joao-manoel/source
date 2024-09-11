package com.rs.game.player.dialogues;

import com.rs.game.player.actions.skills.crafting.TanHide;
import com.rs.game.player.content.SkillsDialogue;

public class tanHide extends Dialogue{

	@Override
	public void start() {
		int[] items = {1741, 1745, 2505, 2507, 2509, 24374};
		SkillsDialogue
        .sendSkillsDialogue(
                player,
                SkillsDialogue.MAKE,
                "Choose how many you wish to make,<br>then click on the item to begin.",
                28, items, null);
	}

	@Override
	public void run(int interfaceId, int componentId) {
			int option = SkillsDialogue.getItemSlot(componentId);
	        int quantity = SkillsDialogue.getQuantity(player);
			if (option == 0) {
				if (TanHide.hasLeatherHides(player)) {
					int[] config = {1739, 1741, 1};
					TanHide.Create(player, config , quantity);
					end();
				} else {
					end();
					player.sm("You don't have any leather.");
				}
			}
			else if (option == 1) {
				if (TanHide.hasGreenHides(player)) {
					int[] config = {1753, 1745, 15};
					TanHide.Create(player, config, quantity);
					end();
				} else {
					end();
					player.sm("You don't have any green dragonhides.");
				}
			}else if (option == 2) {
				if (TanHide.hasBlueHides(player)) {
					int[] config = {1751, 2505, 21};
					TanHide.Create(player, config, quantity);
					end();
				} else {
					end();
					player.sm("You don't have any blue dragonhides.");
				}
			} else if (option == 3) {
				if (TanHide.hasRedHides(player)) {
					int[] config = {1749, 2507, 27};
					TanHide.Create(player, config,quantity);
					end();
				} else {
					end();
					player.sm("You don't have any red dragonhides.");
				}
			}else if (option == 4) {
				if (TanHide.hasBlackHides(player)) {
					int[] config = {1747, 2509, 33};
					TanHide.Create(player, config, quantity);
					end();
				} else {
					end();
					player.sm("You don't have any black dragonhides.");
				}
			}else if (option == 5) {
				if (TanHide.hasRoyalHides(player)) {
					int[] config = {24372, 24374, 39};
					TanHide.Create(player, config, quantity);
					end();
				} else {
					end();
					player.sm("You don't have any royal dragonhides.");
				}
			} 
		
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
