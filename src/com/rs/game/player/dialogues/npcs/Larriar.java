package com.rs.game.player.dialogues.npcs;

import com.rs.game.npc.NPC;
import com.rs.game.player.Skills;
import com.rs.game.player.content.SkillCapes;
import com.rs.game.player.dialogues.Dialogue;

public class Larriar extends Dialogue{
	int npcId;
	@Override
	public void start() {
		NPC npc = (NPC) parameters[0]; 
		npcId = npc.getId();
		sendNPCDialogue(npcId,HAPPY, "Hello, What can I do for you?");		
	}

	@Override
	public void run(int interfaceId, int componentId) {
		switch(stage) {
			case -1:
				if(player.getSkills().getLevelForXp(Skills.RUNECRAFTING) >= 99) {
					sendOptionsDialogue("WHAT WOULD YOU LIKE TO SAY?", "Who are you?", 
							"Can I buy a Runecrafting skillcape?", "Never mind.");
					stage = 0;
				}else {
					sendOptionsDialogue("WHAT WOULD YOU LIKE TO SAY?", "Who are you?", "Never mind.");
					stage = 1;
				}
			break;
			case 0:
				if(componentId == OPTION_1) {
					sendPlayerDialogue( ASKING_FACE, "Who are you?.");
					stage = 2;
				}
				else if(componentId == OPTION_2) {
					sendNPCDialogue(npcId,NORMAL, "Well, it looks like you deserve it after all that running!");	
					stage = 5;
				}
				else if(componentId == OPTION_3) {
					sendPlayerDialogue(NORMAL, "Never mind.");
					stage = 99;
				}
				break;
			case 1:
				if(componentId == OPTION_1) {
					sendPlayerDialogue( ASKING_FACE, "Who are you?.");
					stage = 2;
				}
				else if(componentId == OPTION_2) {
					sendPlayerDialogue(NORMAL, "Never mind.");
					stage = 99;
				}
				break;
			case 2:
				sendNPCDialogue(npcId,HAPPY, "I used to be a runecrafter. Days, weeks and moths I spent at the altars, practising and practising the craft.");
				stage = 3;
				break;
			case 3:
				sendNPCDialogue(npcId, LAUGH_EXCITED, "Now that I've achieved everything I wanted to do, I hang around here, "
						+ "watching other people working. It's far more relaxing!");
				stage = 4;
				break;
			case 4:
				sendNPCDialogue(npcId, HAPPY, "Also, I sell skillcapes to people who deserve them. "
						+ "Now, can I help you?");
				stage = -1;
				break;
			case 5:
				sendOptionsDialogue("CHOOSE AN OPTION", "99,000 Coins? That`s much too expensive.", "I think I have the money right there, actually.");
				stage = 6;
				break;
			case 6:
				if(componentId == OPTION_1) {
					sendNPCDialogue(npcId, 9827, "Not at all; there are many other adventurers who would"
							+ "love the opportunity to purchase such a prestigious item!"
							+ "you can find me here if you change your mind.");
					stage = 99;
				}else if(componentId == OPTION_2) {
					if(player.getInventory().getFreeSlots() >= 2) {
						boolean buyCape = SkillCapes.buySkillCape(player, "runecraft", false);
						if(buyCape) {
							sendNPCDialogue(npcId, HAPPY_FACE, "Excellent! Wear that cape with pride my friend.");
							stage = 99;
						}else {
							sendPlayerDialogue( BAD_ASS, "But, unfortunately, I was mistaken.");
							stage = 7;
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
			case 7:
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
	}

}
