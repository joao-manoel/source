package com.rs.game.player.dialogues.npcs;

import com.rs.game.player.Skills;
import com.rs.game.player.content.SkillCapes;
import com.rs.game.player.dialogues.Dialogue;

public class Ajjat extends Dialogue{
	int npcId;

	@Override
	public void start() {
		npcId = (Integer) parameters[0];
		sendNPCDialogue(npcId, NORMAL, "Greetings, fellow warrior. I am Ajjat, former Black Knight "
				+ "and now training officer here in the Warrior`s Guild.");
		
	}

	@Override
	public void run(int interfaceId, int componentId) {
		switch (stage) {
			case -1:
				if(player.getSkills().getLevelForXp(Skills.ATTACK) >= 99) {
					sendNPCDialogue(npcId,NORMAL, "Ah, but I can see you are already a master in the fine art"
							+ "of attacking, perhaps you have come to me to purchase "
							+ "a Skillcape of Attack, and thus join the elite few who have mastered this exacting skill?");
					stage = 0;
				}else {
					sendOptionsDialogue("SELECT AN OPTION", "Black Knight? Why are you here?", 
							"What`s the dummy room all about?");
					stage = 12;
				}
				break;
			case 0:
				sendOptionsDialogue("SELECT AN OPTION", "May i buy a Skillcape of Attack, please?", "Black Knight? Why are you here?", 
						"What`s the dummy room all about?");
				stage = 1;
				break;
			case 1:
				if (componentId == OPTION_1) {
					sendNPCDialogue(npcId,NORMAL, "Most certainly, unfortunately being such a prestigious "
							+ "item, they are approriately expensive. I`m afraid I must ask you for 99,000 gold.");	
					stage = 2;
				}
				else if(componentId == OPTION_2) {
					sendPlayerDialogue(ASKING_FACE, "Black Knight? Why are you here?");
					stage = 4;
				}
				else if(componentId == OPTION_3) {
					sendPlayerDialogue(ASKING_FACE, "What`s the Dummy Room all about?");
					stage = 6;
					
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
						boolean buyCape = SkillCapes.buySkillCape(player, "attack", false);
						if(buyCape) {
							sendNPCDialogue(npcId, HAPPY_FACE, "Excellent! Wear that cape with pride my friend.");
							stage = 99;
						}else {
							sendPlayerDialogue( SAD, "But, unfortunately, I was mistaken.");
							stage = 13;
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
				sendNPCDialogue(npcId, NORMAL, "Imdeed I was, however, their...methods did not match with"
						+ "my ideals, so left. Harrallak, recognising my talent as a "
						+ "warrior, took me in and offered me a job here");
				stage = 5;
				break;
			case 5:
				sendPlayerDialogue( NORMAL, "Hmm, well, if Harrallak trusts you, I guess I can.");
				stage = -1;
				break;
			case 6:
				sendNPCDialogue(npcId, HAPPY_FACE, "Ahh yes, the dummies, Another ingenious invention of the"
						+ "nobie dwarf, Gamfred. They`re mechanical, you see, and "
						+ "pop up out of the floor. You have to hit them with the correct attack mode before they disappear again.");
				stage = 7;
				break;
			case 7:
				sendPlayerDialogue(ASKING_FACE, "So, how do I tell which one is which?");
				stage = 8;
				break;
			case 8:
				sendNPCDialogue(npcId, HAPPY_FACE, "There are two different ways, One indication is their "
						+ "colour, the other is the pose and weapons they are"
						+ "holding, for instance, the one holding daggers you will need to hit with a piercing attack.");
				stage = 9;
				break;
			case 9:
				sendNPCDialogue(npcId, HAPPY_FACE, "In the room. you will find a poster on the wall to help you"
						+ "recognise each different dummy.");
				stage = 10;
				break;
			case 10:
				sendPlayerDialogue(NORMAL, "That sounds ingenious!");
				stage = 11;
				break;
			case 11:
				sendNPCDialogue(npcId, NORMAL, "Indeed, you may find that you need several weapons to be "
						+ "successful all of the time, but keep trying. The weapons shop uptairs may help you there.");
				stage = -1;
				break;
			case 12:
				if(componentId == OPTION_1) {
					sendPlayerDialogue(ASKING_FACE, "Black Knight? Why are you here?");
					stage = 4;
				}
				else if(componentId == OPTION_2) {
					sendPlayerDialogue(ASKING_FACE, "What`s the Dummy Room all about?");
					stage = 6;
					
				}
				break;
			case 13:
				sendNPCDialogue(npcId, NORMAL, "Well, come back and see me when you do.");
				stage = 99;
				break;
			case 99:
				end();
				break;
		}
	}
	
	public void options() {
		
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
