package com.rs.game.player.dialogues.npcs;

import com.rs.game.player.Skills;
import com.rs.game.player.content.SkillCapes;
import com.rs.game.player.dialogues.Dialogue;

public class MeleeInstructor extends Dialogue {
	
	int npcId;

	@Override
	public void start() {
		npcId = (Integer) parameters[0];
		sendOptionsDialogue("WHAT WOULD YOU LIKE TO TALK ABOUT?", "Who are you?", "What is that cape you're wearing?.", "Bye.");
		stage = 0;
	}
	

	@Override
	public void run(int interfaceId, int componentId) {
		npcId = (Integer) parameters[0];
		switch(stage){
			case -1:
				sendOptionsDialogue("WHAT WOULD YOU LIKE TO TALK ABOUT?", "What is that cape you're wearing?.", "Bye.");
				stage = 1;
				break;
			case 0:
				switch(componentId) {
					case OPTION_1:
						sendNPCDialogue(npcId, HAPPY, "My name is Harlan, a master of defence!");
						stage = -1;
						break;
					case OPTION_2:
						sendNPCDialogue(npcId, HAPPY, "Ah, this is a Skillcape of Defence. I have mastered the art of defence and wear it proudly"
								+ " to show others.");
						stage = 2;
						break;
					case OPTION_3:
						sendPlayerDialogue(NORMAL, "Bye!");
						stage = 9;
						break;
				}
				break;
			case 1:
				switch(componentId) {
					case OPTION_1:
						sendNPCDialogue(npcId, HAPPY, "Ah, this is a Skillcape of Defence. I have mastered the art of defence and wear it proudly"
								+ " to show others.");
						stage = 2;
						break;
					case OPTION_2:
						sendPlayerDialogue(NORMAL, "Bye!");
						stage = 9;
						break;
				}
				break;
			case 2:	
				boolean masterDefende = player.getSkills().getLevelForXp(Skills.DEFENCE) >= 99 ? true : false;
				sendPlayerDialogue(masterDefende ? UNSURE : LAUGH_EXCITED , "Hmm, interesting.");
				
				if(masterDefende) {
					stage = 3;
				}else {
					stage = -1;
				}
				break;
			case 3:
				sendNPCDialogue(npcId, NORMAL, "Ah, but I can see you are already a master in the fine art of defence. perhaps you have come"
						+ " to me to purchase a Skillcape of Defence, and thus join the elite few who have mastered this exacting skill?");
				stage = 4;
				break;
			case 4:
				sendOptionsDialogue("CHOOSE AN OPTION", "Yes, please sell me a Skillcape of Defence.", "No, thanks.");
				stage = 5;
				break;
			case 5:
				switch(componentId) {
					case OPTION_1:
						sendNPCDialogue(npcId, NORMAL, "You wish to join the elite defenders of this world? I'm "
								+ "afraid such things do not come cheaply, They cost 99,000 coins, to be precise!");
						stage = 6;
						break;
					case OPTION_2:
						stage = 99;
						break;
				}
				break;
			case 6:
				sendOptionsDialogue("CHOOSE AN OPTION", "99,000 Coins? That`s much too expensive.", "I think I have the money right there, actually.");
				stage = 7;
				break;
			case 7:
				if(componentId == OPTION_1) {
					sendNPCDialogue(npcId, 9827, "Not at all; there are many other adventurers who would"
							+ "love the opportunity to purchase such a prestigious item!"
							+ "you can find me here if you change your mind.");
					stage = 99;
				}else if(componentId == OPTION_2) {
					if(player.getInventory().getFreeSlots() >= 2) {
						boolean buyCape = SkillCapes.buySkillCape(player, "defence", false);
						if(buyCape) {
							sendNPCDialogue(npcId, HAPPY_FACE, "Excellent! Wear that cape with pride my friend.");
							stage = 99;
						}else {
							sendPlayerDialogue(SAD, "But, unfortunately, I was mistaken.");
							stage = 10;
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
			case 8:
				sendNPCDialogue(npcId, NORMAL, "Well, come back and see me when you do.");
				stage = 99;
				break;
			case 9:
				sendNPCDialogue(npcId, NORMAL, "Bye "+player.getUsername()+".");
				stage = 99;
				break;
			case 10:
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