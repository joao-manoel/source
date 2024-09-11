package com.rs.game.player.dialogues.npcs;

import com.rs.game.Animation;
import com.rs.game.npc.NPC;
import com.rs.game.player.Skills;
import com.rs.game.player.content.SkillCapes;
import com.rs.game.player.dialogues.Dialogue;

public class SloaneDialouge extends Dialogue{
	int npcId;
	@Override
	public void start() {
		NPC npc = (NPC) parameters[0]; 
		npcId = npc.getId();
		sendNPCDialogue(8269,HAPPY, "Ahh, hello there, "+player.getUsername()+".");		
	}

	@Override
	public void run(int interfaceId, int componentId) {
		NPC npc = (NPC) parameters[0];
		switch(stage) {
			case -1:
				if(player.getSkills().getLevelForXp(Skills.STRENGTH) >= 99) {
					sendNPCDialogue(npcId, NORMAL, "Ah, but I can see you are already as strong as is possible!"
							+ " Perhaps you have come to me to purchase a Skillcape of Strength, and thus join the elite few who have mastered "
							+ "this exacting skill?");
					stage = 0;
				}else {
					sendOptionsDialogue("SELECT AN OPTION", "What can I do here?", 
							"Why are you wielding a tree branch?", "Bye!");
					stage = 99;
				}
				break;
			case 0:
				sendOptionsDialogue("SELECT AN OPTION", "May i buy a Skillcape of Strength, please?", "What can I do here?", 
						"Why are you wielding a tree branch?", "Bye!");
				stage = 1;
				break;
			case 1: 
				if (componentId == OPTION_1) {
					sendNPCDialogue(npcId,NORMAL, "Hmm, yes, you certainly look strong enough, That'll be"
							+ " 99,000 gold coins, please.");	
					stage = 2;
				}
				else if(componentId == OPTION_2) {
					sendPlayerDialogue(ASKING_FACE, "What can I do here?");
					stage = 5;
				}
				else if(componentId == OPTION_3) {
					sendPlayerDialogue(ASKING_FACE, "Why are you wielding a tree branch?");
					stage = 12;
					
				}
				else if(componentId == OPTION_4) {
					sendPlayerDialogue(NORMAL, "Bye!");
					stage = 23;
				}
				break;
			/*
			 * 1 OPTION - BUY SKILLCAPE
			 */
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
						boolean buyCape = SkillCapes.buySkillCape(player, "strength", false);
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
				
			/*
			 * 2 OPTION - PERGUNTANDO SOBRE O LOCAL
			 */
			case 5:
				sendNPCDialogue(npcId,NORMAL, "Ahh, the shot put is a great test of stregth, and can be quite rewarding, Mind you do it"
						+ " properly, though, you might want to dust your hads with some powdery substance first. It'll give better grip.");
				stage = 6;
				break;
			case 6:
				sendPlayerDialogue( NORMAL, "I'll remember that Waht should I use?");
				stage = 7;
				break;
			case 7:
				sendNPCDialogue(npcId, HAPPY, "I personally prefer ground ashes, it makes a nice fine powder and gives some really good grip.");
				stage = 8;
				break;
			case 8:
				sendPlayerDialogue( ASKING_FACE, "Okay, what else?");
				stage = 9;
				break;
			case 9:
				sendNPCDialogue(npcId, NORMAL, "Basically you'll need to go in there, make sure you've got nothing cluttering up your hands. pick"
						+ "up a shot and throw it Depending upon you technique, you can get quite long throws.");
				stage = 10;
				break;
			case 10:
				sendPlayerDialogue( ASKING_FACE, "What was your best?");
				stage = 11;
				break;
			case 11:
				sendNPCDialogue(npcId, HAPPY, "Ahh, that would be telling.");
				stage = -1;
				break;
			/*
			 * 3 OPTION - 
			 */
			case 12:
				sendNPCDialogue(npcId, NORMAL, "Well...there's a story to that. You see, I should have an axe but-");
				stage = 13;
				break;
			case 13:
				sendPlayerDialogue( ASKING_FACE, "Sloane's axe?");
				stage = 14;
				break;	
			case 14:
				sendNPCDialogue(npcId, HAPPY, "My axe. He won it because of a squirrel.");
				stage = 15;
				break;	
			case 15:
				sendPlayerDialogue( ASKING_FACE, "A squirrel?");
				stage = 16;
				break;	
			case 16:
				sendNPCDialogue(npcId, BAD_ASS, "He bet me that I couldn't catch the squirrel while still holding my axe,"
						+ " but that he could...but he tricked me!");
				stage = 17;
				break;	
			case 17:
				sendPlayerDialogue( TALKING_ALOT, "Ah, yes, Sloane told me that story before...how you tried to chase the squirrel up the tree"
						+ " with your axe, but that he just chopped the tree down with you axe and won it.");
				stage = 18;
				break;	
			case 18:
				sendNPCDialogue(npcId, BAD_ASS, "Yes, this is so.");
				stage = 19;
				break;
			case 19:
				sendPlayerDialogue( ASKING_FACE, "It doesn't explain why you have a tree branch, though.");
				stage = 20;
				break;	
			case 20:
				sendNPCDialogue(npcId, NORMAL, "A barbaria warrior is bound to this axe, I cannot take up"
						+ " another unless my axe is ruined beyond repair. So I used part of the tree that Sloane cut down as my weapon...it"
						+ " also reminds me of him.");
				stage = 21;
				break;
			case 21:
				sendPlayerDialogue( BAD_ASS, "He was a great warrior.");
				stage = 22;
				break;	
			case 22:
				sendNPCDialogue(npcId, HAPPY, "But the would want us to be happy that he is now with this"
						+ " warrior brethren. Can I help you with anything else?");
				stage = -1;
				break;
			/*
			 * 4 OPTION - BYE
			 */
			case 23:
				sendNPCDialogue(npcId, NORMAL, "Be well, warrior "+player.getUsername()+".");
				npc.animate(new Animation(858));
				stage = 99;
				break;
			/*
			 * FIM
			 */
			case 99:
				end();
				break;
		}
	}

	@Override
	public void finish() {
	}

}
