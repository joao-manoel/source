package com.rs.game.player.dialogues;

import com.rs.game.player.content.KeldagrimCartTravel;

public class KeldagrimTravel extends Dialogue{

	@Override
	public void start() {
		sendDialogue("This trapdoor leads to a small dwarven mine cart station."
				+ "The mine cart will take you to Keldagrim.");
	}

	@Override
	public void run(int interfaceId, int componentId) {
		if(stage == -1) {
			sendOptionsDialogue(SEND_DEFAULT_OPTIONS_TITLE, "Travel to Keldagrim.", "Stay here.");
			stage = 0;
		}
		else if(stage == 0) {
			if (componentId == OPTION_1) {
				end();
				KeldagrimCartTravel.Start(player);
			}else if(componentId == OPTION_2) {
				end();
			}
		}
		
	}
	
	
	

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
