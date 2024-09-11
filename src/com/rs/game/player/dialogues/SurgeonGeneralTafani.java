package com.rs.game.player.dialogues;

import com.rs.game.Animation;
import com.rs.game.Graphics;
import com.rs.game.npc.NPC;
import com.rs.game.player.Skills;
import com.rs.game.player.content.SkillCapes;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;

public class SurgeonGeneralTafani extends Dialogue{
	int npcId;
	@Override
	public void start() {
		NPC npc = (NPC) parameters[0]; 
		npcId = npc.getId();
		sendPlayerDialogue(HAPPY, "Hi!");
		
	}

	@Override
	public void run(int interfaceId, int componentId) {
		switch(stage) {
			case 99:
				end();
				break;
			case -1:
				sendNPCDialogue(npcId,HAPPY, "Hi. How can I help?");		
				stage = 0;
				break;
			case 0:
				sendOptionsDialogue("SELECT AN OPTION", "Can you heal me?", "Do you see a lot of injured fighters?", "Do you come here often?", 
						"Can I buy a Skillcape of Constitution from you?");
				stage = 1;
				break;
			case 1:
				if (componentId == OPTION_1) {
					sendPlayerDialogue(ASKING_FACE, "Can you heal me?");
					stage = 2;
				}
				if (componentId == OPTION_2) {
					sendPlayerDialogue(ASKING_FACE, "Do you see a lot of injured fighters?");
					stage = 4;
				}
				if (componentId == OPTION_3) {
					sendPlayerDialogue(ASKING_FACE, "Do you come here often?");
					stage = 7;
				}
				if (componentId == OPTION_4) {
					if(player.getSkills().getLevelForXp(Skills.HITPOINTS) >= 99) {
						sendNPCDialogue(npcId,NORMAL, "Why, certainly my friend. However, owning such an item make you part of an elite group, and that privilege will cost you 99,000 coins.");	
						stage = 10;
					}else {
						sendNPCDialogue(npcId,NORMAL, "Unfortunately you are not able to obtain the constitution cape.");
						stage = 99;
					}
				}
				break;
			case 2:
				sendNPCDialogue(npcId,HAPPY, "Of course!");		
				stage = 3;
				break;
			case 3:
				player.lock(3);
				player.getPrayer().restorePrayer(player.getSkills().getLevelForXp(Skills.PRAYER) * 10);
				if (player.getPoison().isPoisoned())
					player.getPoison().reset();
				player.setRunEnergy(100);
				player.heal(player.getMaxHitpoints());
				player.getSkills().restoreSkills();
				player.getAppearence().generateAppearenceData();
				player.getSkills().set(Skills.SUMMONING, player.getSkills().getLevelForXp(Skills.SUMMONING));
				player.getSkills().refresh(Skills.SUMMONING);
				player.getCombatDefinitions().resetSpecialAttack();
				player.animate(new Animation(8502));
				player.gfx(new Graphics(1308));
				
				WorldTasksManager.schedule(new WorldTask() {
					@Override
					public void run() {
						sendNPCDialogue(npcId,HAPPY, "You look healthy to me!");
						stage = 99;
						player.unlock();
					}
				}, 3);			
				
				
				break;
			case 4:
				sendNPCDialogue(npcId,NORMAL, "Yes I do. Thanksfully, we can cope with almost anything."
						+ " Jaraah really is a wonderfull surgeon; his methods are little unorthodox but he gets the job done.");	
				stage = 5;
				break;
			case 5:
				sendNPCDialogue(npcId,NORMAL, "I shouldn't tell you this, but his nickname is 'The Butcher'.");	
				stage = 6;
				break;
			case 6:
				sendPlayerDialogue(ASKING_FACE, "That's reassuring.");	
				stage = 99;
				break;
			case 7:
				sendNPCDialogue(npcId, HAPPY, "I work here, so yes.");	
				stage = 8;
				break;
			case 8:
				sendNPCDialogue(npcId, HAPPY, "You're silly!");	
				stage = 99;
				break;
			case 9:
				stage = 99;
				break;
			case 10:
				sendOptionsDialogue("CHOOSE AN OPTION", "99,000 Coins? That`s much too expensive.", "I think I have the money right there, actually.");
				stage = 11;
				break;
			case 11:
				if(componentId == OPTION_1) {
					sendNPCDialogue(npcId, 9827, "Not at all; there are many other adventurers who would"
							+ "love the opportunity to purchase such a prestigious item!"
							+ "you can find me here if you change your mind.");
					stage = 99;
				}else if(componentId == OPTION_2) {
					if(player.getInventory().getFreeSlots() >= 2) {
						boolean buyCape = SkillCapes.buySkillCape(player, "constitution", false);
						if(buyCape) {
							sendNPCDialogue(npcId, HAPPY_FACE, "Excellent! Wear that cape with pride my friend.");
							stage = 99;
						}else {
							sendPlayerDialogue( BAD_ASS, "But, unfortunately, I was mistaken.");
							stage = 12;
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
			case 12:
				sendNPCDialogue(npcId, NORMAL, "Well, come back and see me when you do.");
				stage = 99;
				break;
				
				
		}
	}

	@Override
	public void finish() {		
	}

}
