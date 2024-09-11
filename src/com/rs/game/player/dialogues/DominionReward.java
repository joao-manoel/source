package com.rs.game.player.dialogues;

import com.rs.game.item.Item;

public class DominionReward extends Dialogue{

	@Override
	public void start() {
		sendOptions("Gloves", "Goliath gloves", "Spellcaster gloves", "Swift gloves");
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
					sendOptions("Goliath gloves", "Black", "White", "Yellow", "Red");
					stage = 2;
					break;
				case OPTION_2:
					sendOptions("Spellcaster gloves", "Black", "White", "Yellow", "Red");
					stage = 3;
					break;
				case OPTION_3:
					sendOptions("Swift gloves", "Black", "White", "Yellow", "Red");
					stage = 4;
					break;
				}
				break;
			case 2:
				switch (componentId) {
					case OPTION_1:
						player.getInventory().addItem(new Item(22358, 1)); // black
						end();
						break;
					case OPTION_2:
						player.getInventory().addItem(new Item(22359, 1)); // white
						end();
						break;
					case OPTION_3:
						player.getInventory().addItem(new Item(22360, 1)); // yellow
						end();
						break;
					case OPTION_4:
						player.getInventory().addItem(new Item(22361, 1)); // red
						end();
						break;
					
				}
				break;
			case 3:
				switch (componentId) {
					case OPTION_1:
						player.getInventory().addItem(new Item(22366, 1)); // black
						end();
						break;
					case OPTION_2:
						player.getInventory().addItem(new Item(22367, 1)); // white
						end();
						break;
					case OPTION_3:
						player.getInventory().addItem(new Item(22368, 1)); // yellow
						end();
						break;
					case OPTION_4:
						player.getInventory().addItem(new Item(22369, 1)); // red
						end();
						break;
					
				}
				break;
			case 4:
				switch (componentId) {
					case OPTION_1:
						player.getInventory().addItem(new Item(22362, 1)); // black
						end();
						break;
					case OPTION_2:
						player.getInventory().addItem(new Item(22363, 1)); // white
						end();
						break;
					case OPTION_3:
						player.getInventory().addItem(new Item(22364, 1)); // yellow
						end();
						break;
					case OPTION_4:
						player.getInventory().addItem(new Item(22365, 1)); // red
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
