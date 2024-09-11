package com.rs.game.player.dialogues;

import com.rs.game.npc.NPC;
import com.rs.game.player.Skills;
import com.rs.game.player.content.SkillCapes;

public class BrotherJered extends Dialogue{
	int npcId;
	@Override
	public void start() {	
		NPC npc = (NPC) parameters[0]; 
		npcId = npc.getId();
		if(player.getSkills().getLevelForXp(Skills.PRAYER) >= 99) {
			sendOptionsDialogue("SELECT AN OPTION", "What can you do to help a bold adventurer like myself?", "Praise be to Saradomin!");			
		}else {
			sendPlayerDialogue(HAPPY, "Praise be to Saradomin!");
			stage = 7;
		}
	}

	@Override
	public void run(int interfaceId, int componentId) {
		
		switch(stage) {
		case -1:
			if(componentId == OPTION_1) {
				sendPlayerDialogue(ASKING_FACE, "What can you to help a bold adventurer like myself?");
				stage = 0;
			}else if(componentId == OPTION_2) {
				sendPlayerDialogue(HAPPY, "Praise be to Saradomin!");
				stage = 7;
			}
			break;
		case 0:
			sendNPCDialogue(npcId, HAPPY, "Well, seeing as you are so devout in praising the gods, I"
					+ " could sell you a Skillcape of Prayer.");
			stage = 1;
			break;
		case 1:
			sendOptionsDialogue("SELECT AN OPTION", "Yes, please, so few people have Skillcapes of Prayer!", "No thanks, I can't afford one of those.");
			stage = 2;
			break;
		case 2:
			if(componentId == OPTION_1) {
				sendNPCDialogue(npcId, HAPPY, "One as pious as you has certainly earned the right to wear one, but the monastery"
						+ " requires a donation of 99,000 coins for the privilege.");
				stage = 3;
			}else if(componentId == OPTION_2) {
				sendPlayerDialogue(ASKING_FACE, "No thanks, I can't afford one of those.");
				stage = 6;
			}
			break;
		case 3:
			sendOptionsDialogue("CHOOSE AN OPTION", "99,000 Coins? That`s much too expensive.", "I think I have the money right there, actually.");
			stage = 4;
			break;
		case 4:
			if(componentId == OPTION_1) {
				sendNPCDialogue(npcId, 9827, "Not at all; there are many other adventurers who would"
						+ "love the opportunity to purchase such a prestigious item!"
						+ "you can find me here if you change your mind.");
				stage = 99;
			}else if(componentId == OPTION_2) {
				if(player.getInventory().getFreeSlots() >= 2) {
					boolean buyCape = SkillCapes.buySkillCape(player, "prayer", false);
					if(buyCape) {
						sendNPCDialogue(npcId, HAPPY_FACE, "Excellent! Wear that cape with pride my friend.");
						stage = 99;
					}else {
						sendPlayerDialogue(SAD, "But, unfortunately, I was mistaken.");
						stage = 5;
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
		 case 5:
			sendNPCDialogue(npcId, NORMAL, "Well, come back and see me when you do.");
			stage = 99;
			break;
		 case 6:
			 sendNPCDialogue(npcId, NORMAL, "I am sorry to hear that. If you should find yourself in wealthier times come back and see me.");
				stage = 99;
			 break;
		 case 7:
			 sendNPCDialogue(npcId, NORMAL, "Yes! Praise he who brings life to this world.");
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
