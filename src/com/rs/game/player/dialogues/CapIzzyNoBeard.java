package com.rs.game.player.dialogues;

import com.rs.game.npc.NPC;
import com.rs.game.player.content.SkillCapes;

public class CapIzzyNoBeard extends Dialogue{
	
	int npcId;
	
	@Override
	public void start() {
		NPC npc = (NPC) parameters[0]; 
		npcId = npc.getId();
		sendPlayerDialogue(HAPPY, "Ahoy, Cap'n!.");	
	}

	@Override
	public void run(int interfaceId, int componentId) {
		switch(stage) {
			case 99:
				end();
				break;
			case -1:
				sendNPCDialogue(npcId,HAPPY, "Ahoy there!");		
				stage = 3;
				break;
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				sendOptionsDialogue("SELECT AN OPTION", "What is this place?", "What do I do in the arena?", 
						"I'd like to use the Agility Arena, please.", "Is it true you sell Skillcapes of Agility?");
				stage = 4;
				break;
			case 4:
				if (componentId == OPTION_1) {
					sendPlayerDialogue( ASKING_FACE, "What is this place?");
					stage = 8;
				}
				else if (componentId == OPTION_2) {
					stage = 99;
				}else if (componentId == OPTION_3) {
					stage = 99;
				}else if (componentId == OPTION_4) {
					sendNPCDialogue(npcId,HAPPY, "Most certainly, I think it'll really suit you. All that remains to be done"
							+ " is pay me 99,000 gold!");	
					stage = 5;
				}
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
						boolean buyCape = SkillCapes.buySkillCape(player, "agility", false);
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
			case 8:
				sendNPCDialogue(npcId, HAPPY, "This, me hearty, is the entrance to the Brimhaven Agility Arena!");
				stage = 9;
				break;
			case 9:
				sendNPCDialogue(npcId, HAPPY, "I were diggin'for buried treasure when I found it! Amazed I was! It was a sight to behold!");
				stage = 11;
				break;
			case 10:
				//passardo falando do 9 para 11
				break;
			case 11:
				sendNPCDialogue(npcId, HAPPY, "It were the biggest thing I'd ever seen! It must've been at least a league from side to side!");
				stage = 12;
				break;
			case 12:
				sendNPCDialogue(npcId, HAPPY, "It made me list, I were that excited!");
				stage = 14;
				break;
			case 13:
				//passaro falando do 12 para 13
				break;
			case 14:
				sendNPCDialogue(npcId, HAPPY, "I'd found a huge cave with all these platforms. I reckon it be an ancient civilisation that mad"
						+ " it. I had to be mighty careful, as there was these traps everywhere! Dangerous it was!");
				stage = 16;
				break;
			case 15:
				//passaro falando do 14 para 13
				sendNPCDialogue(npcId, HAPPY, "Danger! Danger!");
				break;
			case 16:
				sendNPCDialogue(npcId, HAPPY, "Entrance is only 200 coins!");
				stage = 3;
				break;
		}
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
