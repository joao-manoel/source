package com.rs.game.player.dialogues.npcs;

import com.rs.game.npc.NPC;
import com.rs.game.player.Skills;
import com.rs.game.player.content.SkillCapes;
import com.rs.game.player.dialogues.Dialogue;

public class ArmourSalesman extends Dialogue{
	int npcId;
	@Override
	public void start() {
		NPC npc = (NPC) parameters[0]; 
		npcId = npc.getId();
		sendPlayerDialogue(HAPPY, "Good day to you.");
	}

	@Override
	public void run(int interfaceId, int componentId) {
		NPC npc = (NPC) parameters[0]; 
		switch(stage) {
			case -1:
				sendNPCDialogue(npc.getId(),HAPPY, "And to you. Can I help you?");
				stage = 0;
				break;
			case 0:
				if(player.getSkills().getLevelForXp(Skills.RANGE) >= 99) {
					sendOptionsDialogue("CHOOSE AN OPTION", "What do you do here?", "I'd like to see what you sell.", 
						"Could I buy a Ranged skillcape?", "I've seen enough, thanks.");
					stage = 1;
				}else {
					sendOptionsDialogue("CHOOSE AN OPTION", "What do you do here?", "I'd like to see what you sell.", 
							"I've seen enough, thanks.");
					stage = 2;
				}
				break;
			case 1:
				if(componentId == OPTION_1) {
					sendPlayerDialogue(HAPPY, "What do you do here?");
					stage = 3;
				}else if(componentId == OPTION_2) {
					sendPlayerDialogue(HAPPY, "I'd like to see what you sell.");
					stage = 27;
				}else if(componentId == OPTION_3) {
					sendNPCDialogue(npc.getId(),NORMAL, "Your eyes tell me all I need to know 99,000 coins and the cape is yours.");
					stage = 29;
				}else if(componentId == OPTION_4) {
					sendPlayerDialogue(NORMAL, "I've seen enough, thanks.");
					stage = 32;
				}
				break;
			case 2:
				if(componentId == OPTION_1) {
					sendPlayerDialogue(HAPPY, "What do you do here?");
					stage = 3;
				}else if(componentId == OPTION_2) {
					sendPlayerDialogue(HAPPY, "I'd like to see what you sell.");
					stage = 27;
				}else if(componentId == OPTION_3) {
					sendPlayerDialogue(NORMAL, "I've seen enough, thanks.");
					stage = 32;
				}
				break;
			case 3:
				sendNPCDialogue(npc.getId(),NORMAL, "Im am supplier of leather amours and accessories. Ask and I will tell you what I know.");
				stage = 4;
				break;
			case 4:
				sendOptionsDialogue("SELECT AN OPTION", "Tell me about your armours.", "Tell me about your accessories.", 
						"I've seen enough thanks.");
				stage = 5;
				break;
			case 5:
				if(componentId == OPTION_1) {
					sendPlayerDialogue(HAPPY, "Tell me about your armours.");
					stage = 6;
				}else if(componentId == OPTION_2) {
					sendPlayerDialogue(HAPPY, "Tell me about your accessories.");
					stage = 13;
				}else if(componentId == OPTION_3) {
					sendPlayerDialogue(NORMAL, "I've seen enough thanks.");
					stage = 26;
				}
				break;
			case 6:
				sendNPCDialogue(npc.getId(),HAPPY, "I have normal, studded and hard types.");
				stage = 7;
				break;
			case 7:
				sendOptionsDialogue("SELECT AN OPTION", "Tell me about normal leather.", "What's studded leather?", 
						"What's hard leather?", "Enough about armour.");
				stage = 8;
				break;
			case 8:
				if(componentId == OPTION_1) {
					sendPlayerDialogue(NORMAL, "Tell me about normal leather.");
					stage = 9;
				}else if(componentId == OPTION_2) {
					sendPlayerDialogue(ASKING, "What's studded leather?");
					stage = 10;
				}else if(componentId == OPTION_3) {
					sendPlayerDialogue(ASKING, "What's hard leather?");
					stage = 11;
				}else if(componentId == OPTION_4) {
					sendPlayerDialogue(NORMAL, "Enough about armour.");
					stage = 12;
				}
				break;
			case 9:
				sendNPCDialogue(npc.getId(),HAPPY, "Indeed, leather armour is excellent for archers. It's supple and not very heavy.");
				stage = 7;
				break;
			case 10:
				sendNPCDialogue(npc.getId(),HAPPY, "Ah, now that's leather covered with studs. It's more protective than ordinary leather.");
				stage = 7;
				break;
			case 11:
				sendNPCDialogue(npc.getId(),HAPPY, "Hard leather is specially treated using oils and drying methods to create a hard-wearing armour.");
				stage = 7;
				break;
			case 12:
				sendNPCDialogue(npc.getId(),NORMAL, "As you wish, traveller");
				stage = 4;
				break;
			case 13:
				sendNPCDialogue(npc.getId(),HAPPY, "Ah yes we have a new range of accessories in stock. "
						+ "Essential items for an archer like you.");
				stage = 14;
				break;
			case 14:
				sendNPCDialogue(npc.getId(),HAPPY, "We have vambraces, chaps, cowls and coifs.");
				stage = 15;
				break;
			case 15:
				sendOptionsDialogue("SELECT AN OPTION", "Tell me about vambraces.", "Tell me about chaps.", 
						"Tell me about cowls.", "Tell me about coifs.", "Enough about accessories.");
				stage = 16;
				break;
			case 16:
				if(componentId == OPTION_1) {
					sendPlayerDialogue(HAPPY, "Tell me about vambraces.");
					stage = 17;
				}else if(componentId == OPTION_2) {
					sendPlayerDialogue(HAPPY, "Tell me about chaps.");
					stage = 19;
				}else if(componentId == OPTION_3) {
					sendPlayerDialogue(HAPPY, "Tell me about cowls.");
					stage = 21;
				}else if(componentId == OPTION_4) {
					sendPlayerDialogue(HAPPY, "Tell me about coifs.");
					stage = 23;
				}else if(componentId == OPTION_5) {
					sendPlayerDialogue(NORMAL, "Enough about accessories.");
					stage = 25;
				}
				break;
			case 17:
				sendNPCDialogue(npc.getId(),HAPPY, "Ah yes, vambraces, These useful items are for your arms.");
				stage = 18;
				break;
			case 18:
				sendNPCDialogue(npc.getId(),HAPPY, "A protective sheath that favours the bow and arrow. An essential purchase.");
				stage = 15;
				break;
			case 19:
				sendNPCDialogue(npc.getId(),HAPPY, "Chaps have two functions. firstly to protect your legs, and secondly for ease of reloading arrows.");
				stage = 20;
				break;
			case 20:
				sendNPCDialogue(npc.getId(),HAPPY, "I can highly recommend these to you for quick archery.");
				stage = 15;
				break;
			case 21:
				sendNPCDialogue(npc.getId(),HAPPY, "The cowl is a soft leather hat, ideal for protection with manouverability.");
				stage = 22;
				break;
			case 22:
				sendNPCDialogue(npc.getId(),HAPPY, "These are highly favoured with our guards.");
				stage = 15;
				break;
			case 23:
				sendNPCDialogue(npc.getId(),HAPPY, "The coif is specialized cowl, that has extra chain protection to keep your neck and shoulders safe.");
				stage = 24;
				break;
			case 24:
				sendNPCDialogue(npc.getId(),HAPPY, "An excellent addition to our range, traveller.");
				stage = 15;
				break;
			case 25:
				sendNPCDialogue(npc.getId(),HAPPY, "As you wish.");
				stage = 4;
				break;
			case 26:
				sendNPCDialogue(npc.getId(),NORMAL, "Very good, adventurer.");
				stage = 99;
				break;
			case 27:
				sendNPCDialogue(npc.getId(),HAPPY, "Indeed, cast your eyes on my wares, adventurer.");
				stage = 28;
				break;
			case 28:
				//open store.
				end();
				break;
			case 29:
				sendOptionsDialogue("CHOOSE AN OPTION", "99,000 Coins? That`s much too expensive.", "I think I have the money right there, actually.");
				stage = 30;
				break;
			case 30:
				if(componentId == OPTION_1) {
					sendNPCDialogue(npcId, 9827, "Not at all; there are many other adventurers who would"
							+ "love the opportunity to purchase such a prestigious item!"
							+ "you can find me here if you change your mind.");
					stage = 99;
				}else if(componentId == OPTION_2) {
					if(player.getInventory().getFreeSlots() >= 2) {
						boolean buyCape = SkillCapes.buySkillCape(player, "ranging", false);
						if(buyCape) {
							sendNPCDialogue(npcId, HAPPY_FACE, "Excellent! Wear that cape with pride my friend.");
							stage = 99;
						}else {
							sendPlayerDialogue( BAD_ASS, "But, unfortunately, I was mistaken.");
							stage = 31;
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
			case 31:
				sendNPCDialogue(npcId, NORMAL, "Well, come back and see me when you do.");
				stage = 99;
				break;
			case 32:
				sendNPCDialogue(npcId, NORMAL, "Very good, adventurer.");
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
