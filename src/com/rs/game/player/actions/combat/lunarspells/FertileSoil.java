package com.rs.game.player.actions.combat.lunarspells;

import com.rs.game.WorldObject;
import com.rs.game.player.Player;

public class FertileSoil {
	public static boolean cast(Player player, double xp, WorldObject object) {
		player.sm("You have been FertileSoil");
		return true;
	}
}
