package com.rs.game.player.dialogues;

import com.rs.game.player.actions.skills.crafting.TanHide;
import com.rs.game.player.content.SkillsDialogue;
import com.rs.utils.ShopsHandler;

public class LeatherTanning extends Dialogue {

	int npcId;

	public void resetHideInts() {
		greenHides = 0;
		blueHides = 0;
		redHides = 0;
		blackHides = 0;
		royalHides = 0;
		leatherHide = 0;
	}
	int leatherHide;
	int greenHides;
	int blueHides;
	int redHides;
	int blackHides;
	int royalHides;

	@Override
	public void start() {
		npcId = (Integer) parameters[0];
		sendNPCDialogue(npcId, 9827, "Hello " + player.getDisplayName() + ", What can i do for you?");
	}

	@Override
	public void run(int interfaceId, int componentId) {
		if (stage == -1) {
			stage = 1;
			sendOptionsDialogue("Choose an option", "I'd to tan some dragon hides, please.",
					"I'd like to see what you have to offer!", "Nothing, just walking by.");
		} else if (stage == 1) {
			if (componentId == OPTION_1) {
				stage = 2;
				sendPlayerDialogue(9827, "I'd to tan some dragon hides, please.");
			} else if (componentId == OPTION_2) {
				stage = 25;
				if (player.getIronman().getMode(player, 1) || player.getIronman().getMode(player, 2)) {
					sendNPCDialogue(2824, Sad, "Sorry, but I can't give you access to my shop.");
					stage = 5;
					return;
				}
				sendPlayerDialogue(9827, "I'd like to see what you have to offer!");
			} else if (componentId == OPTION_3) {
				end();
				sendPlayerDialogue(9827, "Nothing, just walking by.");
			}
		} else if (stage == 2) {
			stage = 3;
			sendNPCDialogue(570, 9827, "Sure thing.. one moment.");
		} else if (stage == 3) {
			stage = 4;
			//iniciar aqui
			int[] items = {1741, 1745, 2505, 2507, 2509, 24374};
			SkillsDialogue
            .sendSkillsDialogue(
                    player,
                    SkillsDialogue.MAKE,
                    "Choose how many you wish to make,<br>then click on the item to begin.",
                    28, items, null);
		} else if (stage == 4) {
			 int option = SkillsDialogue.getItemSlot(componentId);
		      
		        int quantity = SkillsDialogue.getQuantity(player);
		        
		        if (option == 0) {
					if (TanHide.hasLeatherHides(player)) {
						int[] config = {1739, 1741, 1};
						TanHide.Create(player, config , quantity);
						end();
					} else {
						stage = 5;
						sendNPCDialogue(npcId, 9827, "You don't have any leather.");
					}
				}
				else if (option == 1) {
					if (TanHide.hasGreenHides(player)) {
						int[] config = {1753, 1745, 15};
						TanHide.Create(player, config, quantity);
						end();
					} else {
						stage = 5;
						sendNPCDialogue(npcId, 9827, "You don't have any green dragonhides.");
					}
				}else if (option == 2) {
					if (TanHide.hasBlueHides(player)) {
						int[] config = {1751, 2505, 21};
						TanHide.Create(player, config, quantity);
						end();
					} else {
						stage = 5;
						sendNPCDialogue(npcId, 9827, "You don't have any blue dragonhides.");
					}
				} else if (option == 3) {
					if (TanHide.hasRedHides(player)) {
						int[] config = {1749, 2507, 27};
						TanHide.Create(player, config,quantity);
						end();
					} else {
						stage = 5;
						sendNPCDialogue(npcId, 9827, "You don't have any red dragonhides.");
					}
				}else if (option == 4) {
					if (TanHide.hasBlackHides(player)) {
						int[] config = {1747, 2509, 33};
						TanHide.Create(player, config, quantity);
						end();
					} else {
						stage = 5;
						sendNPCDialogue(npcId, 9827, "You don't have any black dragonhides.");
					}
				}else if (option == 5) {
					if (TanHide.hasRoyalHides(player)) {
						int[] config = {24372, 24374, 39};
						TanHide.Create(player, config, quantity);
						end();
					} else {
						stage = 5;
						sendNPCDialogue(npcId, 9827, "You don't have any royal dragonhides.");
					}
				} 
		}
		else if (stage == 5) {
			end();
		}  if (stage == 25) {
			end();
			ShopsHandler.openShop(player, 12);
		}
	}

	
	
	

	@Override
	public void finish() {

	}

}
