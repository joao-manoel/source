package com.rs.game.player.dialogues;

import com.rs.game.player.content.Encant;

public class EncantDialogue extends Dialogue{

	@Override
	public void start() {
		sendOptionsDialogue("Encant", "Farseer helm", "Warrior helm", "Berserker helm", "Archer helm", "More...");
	}

	@Override
	public void run(int interfaceId, int componentId) {
		switch (stage) {
			case -1:
				if (componentId == OPTION_1) {
					Encant.FarseerHelm(player);
					end();
				}
				else if (componentId == OPTION_2) {
					
					Encant.WarriorHelm(player);
					end();
				}
				else if (componentId == OPTION_3) {
					Encant.BerserkerHelm(player);
					end();
				}
				else if (componentId == OPTION_4) {
					Encant.ArcherHelm(player);
					end();
				}else {
					sendOptionsDialogue("Encant", "Neitiznot helm", "Slayer helm", "Back...");
					stage = 1;
				}
				break;
			case 1:
				if (componentId == OPTION_1) {
					Encant.NeitiznotHelm(player);
					end();
				}
				else if (componentId == OPTION_2) {
					Encant.SlayerHelm(player);
					end();
				}
				else {
					stage = -1;
				}
				break;
		}
		
		
	}

	@Override
	public void finish() {
		
	}

}
