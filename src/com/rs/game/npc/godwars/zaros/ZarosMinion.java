package com.rs.game.npc.godwars.zaros;

public class ZarosMinion {
	public static boolean isNexArmour(String name) {
		return name.contains("pernix") || name.contains("torva")
				|| name.contains("virtus") || name.contains("zaryte");
	}
}
