package com.rs.game.player.content;

import com.rs.game.WorldTile;
import com.rs.game.player.Player;

public class SpiritTreeTransport {
	
	private static final WorldTile[] TILES = { new WorldTile(2554, 3255, 0),
		new WorldTile(3187, 3507, 0),
		new WorldTile(2416, 2852, 0),
		new WorldTile(2339, 3108, 0),
		new WorldTile(2541, 3170, 0),
		new WorldTile(2462, 3445, 0) };
	
	public static void sendInterface(Player player) {
		player.getInterfaceManager().sendInterface(864);
		player.getVarsManager().sendVarBit(3959, 3);
		player.getPackets().sendUnlockIComponentOptionSlots(864, 6, 0, 7, 0);
		if (player.getRegionId() == 10033)
			player.getVarsManager().sendVar(1469, 0x27b8c61);
		else if (player.getRegionId() == 9781)
			player.getVarsManager().sendVar(1469, 0x2678d74);
		else {
			transport(player, TILES[4]);
		}
	}
	
	private static void transport(Player player, WorldTile tile) {
		player.getPackets().sendGameMessage("You place your hands on the dry rough bark of the tree,"
				+ " and feel a surge of energy run through your veins.");
		Magic.sendTeleportSpell(player, 7082, 7084, 1229, 1229, 1, 0, tile, 4, true, Magic.OBJECT_TELEPORT);
	}
	
	public static void handleSpiritTree(Player player, int slot) {
		if (slot == 0) {
		    if (player.getRegionId() == 10033)
		    	slot = 6;
		    else
		    	slot = 5;
		}
		transport(player, TILES[slot - 1]);
	 }
}
