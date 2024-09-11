package com.rs.game.player.actions.combat.lunarspells;

import com.rs.game.WorldObject;
import com.rs.game.player.Player;

public class CurePlant {

	public static boolean cast(Player player, double xp, WorldObject object) {
		player.sm("CurePlant");		
		return true;
	}
	
}
