package com.rs.game.player.dialogues;

public class buyDominionReward extends Dialogue{

	@Override
	public void start() {
		sendOptions("Unlock 30 Ruby Points", "Unlock", "Cancel");
		stage = 1;
	}

	@Override
	public void run(int interfaceId, int componentId) {
		switch (stage) {
			case END:
				end();
				break;
			case 1:
				switch (componentId) {
					case OPTION_1:
						if(player.getRubyPoints() >= 30) {
							player.sm("Congratulation you unlock all gloves.");
							player.setRubyPoints(player.getRubyPoints() - 30);
							player.setHasGloves(true);
							end();
						}else {
							player.sm("You don't have enough points.");
							end();
						}
						
						break;
					case OPTION_2:
						end();
						break;
				}
				break;
		}
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
