package com.rs.game.objects.impl;

import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.objects.ObjectScript;
import com.rs.game.player.Player;
import com.rs.game.player.actions.combat.OldMagicSystem;

public class RunespanPortal extends ObjectScript {

	@Override
	public Object[] getKeys() {
		return new Object[] { 38279 };
	}
	
	@Override
	public boolean processObject(Player player, WorldObject object) {
		if(player.getPlane() == 2) {
			OldMagicSystem.sendObjectTeleportSpell(player, true, new WorldTile(3106, 3160, 1));
		}else {
			player.getDialogueManager().startDialogue("RunespanPortalD");						
		}
		return true;
	}
}
