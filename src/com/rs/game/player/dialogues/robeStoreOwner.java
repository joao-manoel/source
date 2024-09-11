package com.rs.game.player.dialogues;

import com.rs.game.npc.NPC;
import com.rs.game.player.Skills;
import com.rs.game.player.content.SkillCapes;

public class robeStoreOwner extends Dialogue{
	int npcId;
	@Override
	public void start() {
		NPC npc = (NPC) parameters[0]; 
		npcId = npc.getId();
		sendNPCDialogue(npcId,HAPPY, "Welcome to the Magic Guild Store. Would you like to buy some magic supplies?");
	}

	@Override
	public void run(int interfaceId, int componentId) {
		switch(stage) {
			case -1:
				if(player.getSkills().getLevelForXp(Skills.MAGIC) >= 99) {
					sendOptionsDialogue("CHOOSE AN OPTION", "Yes please.", 
						"Can I buy a skillcape of Magic?", "No Thanks you.");
					stage = 0;
				}else {
					sendOptionsDialogue("CHOOSE AN OPTION", "Yes please.", "No Thanks you.");
					stage = 1;
				}
				break;
			case 0:
				if (componentId == OPTION_1) {
					sendPlayerDialogue(HAPPY, "Yes please.");
					end();
				}
				else if(componentId == OPTION_2) {
					sendNPCDialogue(npcId,NORMAL, "A wonderful idea. I imagine it's not a problem, but I require 99,000 coins. Runes arent't"
							+ " cheap you know?");
					stage = 2;
				}
				else if(componentId == OPTION_3) {
					sendPlayerDialogue(NORMAL, "No Thanks you.");
					stage = 99;						
				}
				break;
			case 1:
				if (componentId == OPTION_1) {
					sendPlayerDialogue(HAPPY, "Yes please.");
					end();
				}
				else if(componentId == OPTION_2) {
					sendPlayerDialogue(NORMAL, "No Thanks you.");
					stage = 99;					
				}
				break;
			case 2:
				sendOptionsDialogue("CHOOSE AN OPTION", "99,000 Coins? That`s much too expensive.", "I think I have the money right there, actually.");
				stage = 3;
				break;
			case 3:
				if(componentId == OPTION_1) {
					sendNPCDialogue(npcId, 9827, "Not at all; there are many other adventurers who would"
							+ "love the opportunity to purchase such a prestigious item!"
							+ "you can find me here if you change your mind.");
					stage = 99;
				}else if(componentId == OPTION_2) {
					if(player.getInventory().getFreeSlots() >= 2) {
						boolean buyCape = SkillCapes.buySkillCape(player, "magic", false);
						if(buyCape) {
							sendNPCDialogue(npcId, HAPPY_FACE, "Excellent! Wear that cape with pride my friend.");
							stage = 99;
						}else {
							sendPlayerDialogue( BAD_ASS, "But, unfortunately, I was mistaken.");
							stage = 4;
						}
					}else {
						sendNPCDialogue(npcId, NORMAL, "Unfortunately all skillcapes are only available with a free hood,"
								+ " it's part of a skill promotion deal; buy one get one"
								+ " free, you know. So, you'll need to free up some inventory"
								+ "space before I can sell you one.");
						stage = 99;
					}					
					
				}
				break;
			case 4:
				sendNPCDialogue(npcId, NORMAL, "Well, come back and see me when you do.");
				stage = 99;
				break;
			case 99:
				end();
				break;
				
		}
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
